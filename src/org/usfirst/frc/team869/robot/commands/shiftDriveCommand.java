package org.usfirst.frc.team869.robot.commands;

//import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.subsystems.DriveShiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftDriveCommand extends Command {
	public String nextGear; //TODO - This should not be a string
	
    public ShiftDriveCommand(String gear) {
    	nextGear = gear;
    	requires(Robot.driveShiftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (nextGear == "HighSpeed"){  //TODO - This should not be a string, this type of string compare won't work.
    		DriveShiftSubsystem.shiftHighSpeed();
    	} else if (nextGear == "LowSpeed") {
    		DriveShiftSubsystem.shiftHighTorque();
    	} else {
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
