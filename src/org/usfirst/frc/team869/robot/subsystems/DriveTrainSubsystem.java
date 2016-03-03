package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;



import org.usfirst.frc.team869.robot.commands.*;
import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.networktables.*;

public class DriveTrainSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	//Create the talons for the drive Train.
	CANTalon talonFrontLeft = new CANTalon (RobotMap.leftFrontDriveMotor);
	CANTalon talonRearLeft = new CANTalon (RobotMap.leftRearDriveMotor);
	CANTalon talonFrontRight = new CANTalon (RobotMap.rightFrontDriveMotor);
	CANTalon talonRearRight = new CANTalon (RobotMap.rightRearDriveMotor);
	
	AnalogInput gyroInput = new AnalogInput (RobotMap.gyroInput);
	AnalogGyro driveGyro = new AnalogGyro (gyroInput);
	
    public void initDefaultCommand() {
    	
    	//Set driveWithJoysticks as default command.
    	//This will make sure when the subsystem is idle (no other commands scheduled) 
    	//			it will continue to ALWAYS be scheduled with the joystick input.
    	setDefaultCommand(new DriveWithJoysticksCommand());
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setTankDrive (double rightSpeed, double leftSpeed){
    	//Set left and right speeds. Invert left value to accommodate motors spinning on the mirrored side.
    	talonFrontLeft.set((leftSpeed));
    	talonRearLeft.set((leftSpeed));
    	talonFrontRight.set(-rightSpeed);
    	talonRearRight.set(-rightSpeed);
    	
    	System.out.print("running drive train right@:" + rightSpeed + " left @:" + leftSpeed + " \r");
    }
    
    
    public void resetGyro (){
    	driveGyro.reset();
    }
    
    public void getGyroAngle (){
    	driveGyro.getAngle();
    	System.out.print(driveGyro.getAngle());	
    }
    
    
    public void getGoalLocation (){
    	
    	NetworkTable.getTable("GRIP/StrongholdContours");

    }    
}