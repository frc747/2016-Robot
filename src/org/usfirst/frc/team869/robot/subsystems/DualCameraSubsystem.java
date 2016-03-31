package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.controls.CustomCameraServer;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class DualCameraSubsystem extends Subsystem
{
	CustomCameraServer cameraServer;
	USBCamera firstCam = null;
	USBCamera secondCam = null;
	String camName1, camName2;
	
	boolean isCam1 = true;

	public DualCameraSubsystem(String cam1, String cam2)
	{
		this.camName1 = cam1;
		this.camName2 = cam2;
	}
	
	public void initDefaultCommand() {}

	public void switchCameras()
	{
		if(isCam1)
		{
			cameraServer.startAutomaticCapture(secondCam);
			isCam1 = false;
		}
		else
		{
			cameraServer.startAutomaticCapture(firstCam);
			isCam1 = true;
		}
	}

	public void endCameras()
	{
		if (firstCam != null)
		{
			firstCam.closeCamera();
			firstCam = null;
		}
		if (secondCam != null)
		{
			secondCam.closeCamera();
			secondCam = null;
		}
	}

	public void initializeCameras()
	{
		endCameras();
		try
		{
			firstCam = new USBCamera(camName1);
		} catch (Exception e)
		{
			firstCam = null;
		}

		try
		{
			secondCam = new USBCamera(camName2);
		} catch (Exception e)
		{
			secondCam = null;
		}

		if (cameraServer == null)
		{
			cameraServer = CustomCameraServer.getInstance();
			cameraServer.setQuality(50);
		}
		cameraServer.startAutomaticCapture(firstCam);
	}
}