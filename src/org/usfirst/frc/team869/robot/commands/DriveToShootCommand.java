package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToShootCommand extends Command {
    
    private double inchesToTravel,
    			   speed,
    			   targetAngle;

    public DriveToShootCommand(double distanceInches, double speed, double angle) {
        requires(Robot.DRIVE_TRAIN);
        
        this.inchesToTravel = distanceInches;
        this.speed = speed;
        this.targetAngle = angle;
        
       
        
    }

    protected void initialize() {
        Robot.DRIVE_TRAIN.resetLeftEncoder();
        Robot.DRIVE_TRAIN.resetRightEncoder();
        
//        System.out.println("RESET Should Be 0 ****** left encoder =" + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "   right encoder get=" + Double.toString(Robot.DRIVE_TRAIN.getRightEncoderDistance()));
        
    }

    protected void execute() {
        
//        Robot.DRIVE_TRAIN.setTankDrive(speed, speed);
        Robot.DRIVE_TRAIN.driveStraight(speed, targetAngle);
        
//        System.out.println("EXECUTE ****** left encoder =" + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "  right encoder get=" + Double.toString(Robot.DRIVE_TRAIN.getRightEncoderDistance()));
    }

    protected boolean isFinished() {
        
        final double medianDistanceTraveled = (Robot.DRIVE_TRAIN.getLeftEncoderDistance() + Robot.DRIVE_TRAIN.getRightEncoderDistance())/2;
        
        final double medianInchesTraveled = Robot.DRIVE_TRAIN.convertEncoderTicksToInches(medianDistanceTraveled);
        
        
//        System.out.println("isFINISHED ****** MedianTicks: " + Double.toString(medianDistanceTraveled) + 
//                "   MedianInches CONVERTED: " + Double.toString(medianInchesTraveled));
        
        //TODO add in "or is timed out"
        return (Math.abs(medianInchesTraveled)  >= Math.abs(inchesToTravel));
        
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
        this.end();
    }
}
