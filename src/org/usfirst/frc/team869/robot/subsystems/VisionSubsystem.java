package org.usfirst.frc.team869.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;


import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;
/**
 *
 */
public class VisionSubsystem extends Subsystem {
	
	
	private final int camFront;
	private final int camBack;
	private Image frame;
	private CameraServer server;
	private boolean isShooterCamera;
	

	
	public VisionSubsystem()
	{
        // Get camera ids by supplying camera name ex 'cam0', found on roborio web interface
        camFront = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        camBack = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        // Img that will contain camera img
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        // Server that we'll give the img to
        server = CameraServer.getInstance();
        server.setQuality(90);
        
        this.isShooterCamera = true;
        
	}
	
	public void initDefaultCommand() {}
    
    public void toggleCamera(){
    
    	if(this.isShooterCamera){
    		NIVision.IMAQdxStopAcquisition(camFront);
        	NIVision.IMAQdxConfigureGrab(camBack);
        	NIVision.IMAQdxStartAcquisition(camBack);
    	} else {
    		NIVision.IMAQdxStopAcquisition(camBack);
        	NIVision.IMAQdxConfigureGrab(camFront);
        	NIVision.IMAQdxStartAcquisition(camFront);
    	}
    	this.isShooterCamera = !this.isShooterCamera;
    }
    public void updateCam()
    {
    	if(this.isShooterCamera){
    		NIVision.IMAQdxGrab(camBack, frame, 1);
    		server.setImage(frame);
    	} else {
    		NIVision.IMAQdxGrab(camFront, frame, 1);
            server.setImage(frame);
    	}
    }
}

