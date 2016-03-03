package org.usfirst.frc.team869.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team869.robot.subsystems.*;
import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.Robot;

public class DriveWithJoysticksCommand extends Command {
	
    public DriveWithJoysticksCommand() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setTankDrive((OI.getRightDriveSpeed()), (OI.getLeftDriveSpeed()));
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
