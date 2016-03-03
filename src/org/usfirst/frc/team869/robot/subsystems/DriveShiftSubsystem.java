package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.ShiftDriveCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class DriveShiftSubsystem extends Subsystem {
	
	public static DoubleSolenoid driveShifter = new DoubleSolenoid (RobotMap.DRIVE_HIGH_SPEED, RobotMap.DRIVE_LOW_SPEED);

    public void initDefaultCommand() {
    }
    
    public static void shiftHighSpeed (){
    	driveShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public static void shiftLowSpeed (){
    	driveShifter.set(DoubleSolenoid.Value.kReverse);
    }
}