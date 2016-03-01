package org.usfirst.frc.team869.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.subsystems.DriveShiftSubsystem;

public class HighSpeedDriveCommand extends Command {
	
	
    public HighSpeedDriveCommand() {
		requires (Robot.driveShiftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveShiftSubsystem.shiftHighSpeed();
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
