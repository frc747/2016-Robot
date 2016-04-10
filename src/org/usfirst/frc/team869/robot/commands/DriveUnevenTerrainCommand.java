package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUnevenTerrainCommand extends Command {
    
    private double inchesToTravel;
    private double leftSpeed,
    			   rightSpeed;

    public DriveUnevenTerrainCommand(double distanceInches, double leftSpeed, double rightSpeed) {
        requires(Robot.DRIVE_TRAIN);
        
        this.inchesToTravel = distanceInches;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        
    }

    protected void initialize() {
        Robot.DRIVE_TRAIN.resetLeftEncoder();
        Robot.DRIVE_TRAIN.resetRightEncoder();
//        System.out.println("RESET Should Be 0 ****** left encoder =" + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "   right encoder get=" + Double.toString(Robot.DRIVE_TRAIN.getRightEncoderDistance()));
        
    }

    protected void execute() {
        
        Robot.DRIVE_TRAIN.setTankDrive(rightSpeed, leftSpeed);
        
//        System.out.println("EXECUTE SpeedOFFSET ****** left encoder =" + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "  right encoder get=" + Double.toString(Robot.DRIVE_TRAIN.getRightEncoderDistance()));
    }

    protected boolean isFinished() {
        
        
        
        final double inchesTraveled = Robot.DRIVE_TRAIN.convertEncoderTicksToInches(Robot.DRIVE_TRAIN.getLeftEncoderDistance());
        
//        System.out.println("isFINISHED SpeedOFFSET****** Ticks: " + Double.toString(Robot.DRIVE_TRAIN.getLeftEncoderDistance()) + 
//                "   Inches CONVERTED: " + Double.toString(inchesTraveled));
        
        return Math.abs(inchesTraveled)  > Math.abs(inchesToTravel);
        
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
        this.end();
    }
}