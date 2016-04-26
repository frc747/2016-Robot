package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToShootCommand extends Command {
    
    private double inchesToTravel;
    private double speed;

    public DriveToShootCommand(double distanceInches, double speed) {
        requires(Robot.DRIVE_TRAIN);
        
        this.inchesToTravel = distanceInches;
        this.speed = speed;
        
       
        
    }

    protected void initialize() {
        Robot.DRIVE_TRAIN.resetLeftEncoder();
        Robot.DRIVE_TRAIN.resetRightEncoder();
        
//        System.out.println("RESET Should Be 0 ****** left encoder =" + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "   right encoder get=" + Double.toString(Robot.DRIVE_TRAIN.getRightEncoderDistance()));
        
    }

    protected void execute() {
        
        Robot.DRIVE_TRAIN.setTankDrive(speed, speed);
        
//        System.out.println("EXECUTE ****** left encoder =" + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "  right encoder get=" + Double.toString(Robot.DRIVE_TRAIN.getRightEncoderDistance()));
    }

    protected boolean isFinished() {
        
        final double medianDistanceTraveled = (Robot.DRIVE_TRAIN.getLeftEncoderDistance() + Robot.DRIVE_TRAIN.getRightEncoderDistance())/2;
        
        final double medianInchesTraveled = Robot.DRIVE_TRAIN.convertEncoderTicksToInches(medianDistanceTraveled);
        
//        Robot.DRIVE_TRAIN.getNavXPitch();
        
//        System.out.println("isFINISHED ****** MedianTicks: " + Double.toString(medianDistanceTraveled) + 
//                "   MedianInches CONVERTED: " + Double.toString(medianInchesTraveled));
        
        return (Math.abs(medianInchesTraveled)  > Math.abs(inchesToTravel));
//        		return ((!Robot.DRIVE_TRAIN.isRobotMoving()));
        
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
        this.end();
    }
}
