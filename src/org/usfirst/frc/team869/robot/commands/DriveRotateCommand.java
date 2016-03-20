package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Negative degrees is anti-clockwise and positive degrees is clockwise
 */
public class DriveRotateCommand extends Command {
	
	private double speed;
	private int degrees;
	

    public DriveRotateCommand(double speed, int degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DRIVE_TRAIN);
    	
    	this.speed = speed;
    	this.degrees = degrees;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.DRIVE_TRAIN.resetNavXYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		Robot.DRIVE_TRAIN.setTankDrive(speed, -speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	
    	if (Robot.DRIVE_TRAIN.getNavXAngle() <= this.degrees){
    		return false;
    	} else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}