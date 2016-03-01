package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.ShiftDriveCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class driveShiftSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static DoubleSolenoid driveShifter = new DoubleSolenoid (RobotMap.driveHighSpeed, RobotMap.driveHighTorque);
	
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	//setDefaultCommand(new shiftDriveCommand("Previous"));
    }
    
    public static void shiftHighSpeed (){
    	driveShifter.set(DoubleSolenoid.Value.kForward);
    	
    	
    }
    public static void shiftHighTorque (){
    	driveShifter.set(DoubleSolenoid.Value.kReverse);
    	
    	
    }
}

