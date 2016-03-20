package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistanceCommand extends Command {
	
	public double inchesToTravel;
	public double speed;

    public DriveDistanceCommand(double distanceInches, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DRIVE_TRAIN);
    	
    	this.inchesToTravel = distanceInches;
    	this.speed = speed;
    	
    	
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DRIVE_TRAIN.resetLeftEncoder();
    	Robot.DRIVE_TRAIN.resetRightEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.DRIVE_TRAIN.setTankDrive(speed, speed);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	//IF DISTANCE TRAVELED = DISTANCE DESIRED RETURN TRUE ROBOT WILL STOP
    	
    	final double medianDistanceTraveled = (Robot.DRIVE_TRAIN.getLeftEncoderDistance() + Robot.DRIVE_TRAIN.getRightEncoderDistance())/2;
    	
    	final double medianInchesTraveled = Robot.DRIVE_TRAIN.convertEncoderTicksToInches(medianDistanceTraveled);
    	
    	return medianInchesTraveled  > inchesToTravel;
    	
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
