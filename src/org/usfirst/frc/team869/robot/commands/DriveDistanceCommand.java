package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistanceCommand extends Command {
    
    private double inchesToTravel;
    private double speed;

    public DriveDistanceCommand(double distanceInches, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.DRIVE_TRAIN);
        
        this.inchesToTravel = distanceInches;
        this.speed = speed;
    }

    protected void initialize() {
        Robot.DRIVE_TRAIN.resetLeftEncoder();
        Robot.DRIVE_TRAIN.resetRightEncoder();
        this.setTimeout(3.5);
    }

    protected void execute() {
        Robot.DRIVE_TRAIN.setTankDrive(speed, speed);
    }

    protected boolean isFinished() {
        
        //IF DISTANCE TRAVELED = DISTANCE DESIRED RETURN TRUE ROBOT WILL STOP
        /*
        final double medianDistanceTraveled = (Robot.DRIVE_TRAIN.getLeftEncoderDistance() + Robot.DRIVE_TRAIN.getRightEncoderDistance())/2;
        
        final double medianInchesTraveled = Robot.DRIVE_TRAIN.convertEncoderTicksToInches(medianDistanceTraveled);
        
        return medianInchesTraveled  > inchesToTravel;
        */
        
        return this.isTimedOut();
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
    }
}
