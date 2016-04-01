/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2016. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team869.robot.controls;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.RawData;
import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.vision.USBCamera;

public final class CustomCameraServer {

    private static final int    K_PORT                 = 1180;
    private static final byte[] K_MAGIC_NUMBER         = {0x01, 0x00, 0x00, 0x00};
    private static final int    K_SIZE_640_480         = 0;
    private static final int    K_SIZE_320_240         = 1;
    private static final int    K_SIZE_160_120         = 2;
    private static final int    K_HARDWARE_COMPRESSION = -1;
    private static final int    K_MAX_IMAGE_SIZE       = 200000;
    
    private static CustomCameraServer server;

    public static CustomCameraServer getInstance() {
        if (server == null) {
            server = new CustomCameraServer();
        }
        return server;
    }

    private Thread            serverThread;
    private int               mQuality;
    private boolean           mAutoCaptureStarted;
    private boolean           mHWClient = true;
    private USBCamera         mCamera;
    private CameraData        mImageData;
    private Deque<ByteBuffer> mImageDataPool;

    private class CameraData {
        private RawData data;
        private int     start;

        public CameraData(RawData d, int s) {
            data = d;
            start = s;
        }
    }

    private CustomCameraServer() {
        mQuality       = 75;
        mCamera        = null;
        mImageData     = null;
        mImageDataPool = new ArrayDeque<>(3);
        for (int i = 0; i < 3; i++) {
            mImageDataPool.addLast(ByteBuffer.allocateDirect(K_MAX_IMAGE_SIZE));
        }
        serverThread = new Thread(new Runnable() {
            public void run() {
                try {
                    serve();
                } catch (IOException e) {
                    // do stuff here
                } catch (InterruptedException e) {
                    // do stuff here
                }
            }
        });
        serverThread.setName("CameraServer Send Thread");
        serverThread.start();
    }

    private synchronized void setImageData(RawData data, int start) {
        if (mImageData != null && mImageData.data != null) {
            mImageData.data.free();
            if (mImageData.data.getBuffer() != null){
                mImageDataPool.addLast(mImageData.data.getBuffer());
            }
            mImageData = null;
        }
        mImageData = new CameraData(data, start);
        notifyAll();
    }

    /**
     * Manually change the image that is served by the MJPEG stream. This can be
     * called to pass custom annotated images to the dashboard. Note that, for
     * 640x480 video, this method could take between 40 and 50 milliseconds to
     * complete.
     *
     * This shouldn't be called if {@link #startAutomaticCapture} is called.
     *
     * @param image The IMAQ image to show on the dashboard
     */
    public void setImage(Image image) {
        // handle multi-threadedness

    /* Flatten the IMAQ image to a JPEG */

        RawData data =
                NIVision.imaqFlatten(image, NIVision.FlattenType.FLATTEN_IMAGE,
                        NIVision.CompressionType.COMPRESSION_JPEG, 10 * mQuality);
        ByteBuffer buffer = data.getBuffer();
        boolean hwClient;

        synchronized (this) {
            hwClient = mHWClient;
        }

    /* Find the start of the JPEG data */
        int index = 0;
        if (hwClient) {
            while (index < buffer.limit() - 1) {
                if ((buffer.get(index) & 0xff) == 0xFF && (buffer.get(index + 1) & 0xff) == 0xD8){
                    break;
                }
                index++;
            }
        }

        if (buffer.limit() - index - 1 <= 2) {
            throw new VisionException("data size of flattened image is less than 2. Try another camera! ");
        }

        setImageData(data, index);
    }

    /**
     * Start automatically capturing images to send to the dashboard. You should
     * call this method to just see a camera feed on the dashboard without doing
     * any vision processing on the roboRIO. {@link #setImage} shouldn't be called
     * after this is called. This overload calles
     * {@link #startAutomaticCapture(String)} with the default camera name
     */
    public void startAutomaticCapture() {
        startAutomaticCapture(USBCamera.kDefaultCameraName);
    }

    /**
     * Start automatically capturing images to send to the dashboard.
     *
     * You should call this method to just see a camera feed on the dashboard
     * without doing any vision processing on the roboRIO. {@link #setImage}
     * shouldn't be called after this is called.
     *
     * @param cameraName The name of the camera interface (e.g. "cam1")
     */
    public void startAutomaticCapture(String cameraName) {
        try {
            USBCamera camera = new USBCamera(cameraName);
            camera.openCamera();
            startAutomaticCapture(camera);
        } catch (VisionException ex) {
            DriverStation.reportError(
                    "Error when starting the camera: " + cameraName + " " + ex.getMessage(), true);
        }
    }

    public synchronized void startAutomaticCapture(USBCamera camera) {
        if (camera==null) {
            return;
        }

        if (mAutoCaptureStarted) {
            mCamera.stopCapture();
            mCamera = camera;
            mCamera.startCapture();
            return;
        }
        mAutoCaptureStarted = true;
        mCamera = camera;

        mCamera.startCapture();

        Thread captureThread = new Thread(new Runnable() {
            @Override
            public void run() {
                capture();
            }
        });
        captureThread.setName("Camera Capture Thread");
        captureThread.start();
    }

    protected void capture() {
        Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        while (true) {
            boolean hwClient;
            ByteBuffer dataBuffer = null;
            synchronized (this) {
                hwClient = mHWClient;
                if (hwClient) {
                    dataBuffer = mImageDataPool.removeLast();
                }
            }

            try {
                if (hwClient && dataBuffer != null) {
                    // Reset the image buffer limit
                    dataBuffer.limit(dataBuffer.capacity() - 1);
                    mCamera.getImageData(dataBuffer);
                    setImageData(new RawData(dataBuffer), 0);
                } else {
                    mCamera.getImage(frame);
                    setImage(frame);
                }
            } catch (VisionException ex) {
                DriverStation.reportError("Error when getting image from the camera: " + ex.getMessage(),
                        true);
                if (dataBuffer != null) {
                    synchronized (this) {
                        mImageDataPool.addLast(dataBuffer);
                        Timer.delay(.1);
                    }
                }
            }
        }
    }



    /**
     * check if auto capture is started
     *
     */
    public synchronized boolean isAutoCaptureStarted() {
        return mAutoCaptureStarted;
    }

    /**
     * Sets the size of the image to use. Use the public kSize constants to set
     * the correct mode, or set it directory on a camera and call the appropriate
     * autoCapture method
     *$
     * @param size The size to use
     */
    public synchronized void setSize(int size) {
        if (mCamera == null){
            return;
        }
        switch (size) {
            case K_SIZE_640_480:
                mCamera.setSize(640, 480);
                break;
            case K_SIZE_320_240:
                mCamera.setSize(320, 240);
                break;
            case K_SIZE_160_120:
                mCamera.setSize(160, 120);
                break;
        }
    }

    /**
     * Set the quality of the compressed image sent to the dashboard
     *
     * @param quality The quality of the JPEG image, from 0 to 100
     */
    public synchronized void setQuality(int quality) {
        mQuality = quality > 100 ? 100 : quality < 0 ? 0 : quality;
    }

    /**
     * Get the quality of the compressed image sent to the dashboard
     *
     * @return The quality, from 0 to 100
     */
    public synchronized int getQuality() {
        return mQuality;
    }

    /**
     * Run the M-JPEG server.
     *
     * This function listens for a connection from the dashboard in a background
     * thread, then sends back the M-JPEG stream.
     *
     * @throws IOException if the Socket connection fails
     * @throws InterruptedException if the sleep is interrupted
     */
    protected void serve() throws IOException, InterruptedException {

        ServerSocket socket = new ServerSocket();
        socket.setReuseAddress(true);
        InetSocketAddress address = new InetSocketAddress(K_PORT);
        socket.bind(address);

        while (true) {
            try {
                Socket s = socket.accept();

                DataInputStream is = new DataInputStream(s.getInputStream());
                DataOutputStream os = new DataOutputStream(s.getOutputStream());

                int fps = is.readInt();
                int compression = is.readInt();
                int size = is.readInt();

                if (compression != K_HARDWARE_COMPRESSION) {
                    DriverStation.reportError("Choose \"USB Camera HW\" on the dashboard", false);
                    s.close();
                    continue;
                }

                // Wait for the camera
                synchronized (this) {
                    System.out.println("Camera not yet ready, awaiting image");
                    if (mCamera == null){
                        wait();
                    }
                    mHWClient = compression == K_HARDWARE_COMPRESSION;
                    if (!mHWClient){
                        setQuality(100 - compression);
                    } else if (mCamera != null){
                        mCamera.setFPS(fps);
                    }
                    setSize(size);
                }

                long period = (long) (1000 / (1.0 * fps));
                while (true) {
                    long t0 = System.currentTimeMillis();
                    CameraData imageData = null;
                    synchronized (this) {
                        wait();
                        imageData = mImageData;
                        mImageData = null;
                    }

                    if (imageData == null){
                        continue;
                    }
                    // Set the buffer position to the start of the data,
                    // and then create a new wrapper for the data at
                    // exactly that position
                    imageData.data.getBuffer().position(imageData.start);
                    byte[] imageArray = new byte[imageData.data.getBuffer().remaining()];
                    imageData.data.getBuffer().get(imageArray, 0, imageData.data.getBuffer().remaining());

                    // write numbers
                    try {
                        os.write(K_MAGIC_NUMBER);
                        os.writeInt(imageArray.length);
                        os.write(imageArray);
                        os.flush();
                        long dt = System.currentTimeMillis() - t0;

                        if (dt < period) {
                            Thread.sleep(period - dt);
                        }
                    } catch (IOException | UnsupportedOperationException ex) {
                        DriverStation.reportError(ex.getMessage(), true);
                        break;
                    } finally {
                        imageData.data.free();
                        if (imageData.data.getBuffer() != null) {
                            synchronized (this) {
                                mImageDataPool.addLast(imageData.data.getBuffer());
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                DriverStation.reportError(ex.getMessage(), true);
                continue;
            }
        }
    }
}