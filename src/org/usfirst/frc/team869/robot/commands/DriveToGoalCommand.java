package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DriveToGoalCommand extends Command {
    
    private double inchesToTravel;
    private double speed;
    private static final int LOCATION_FUZZINESS = 10;
    private static final double GOAL_CENTER = 280;
    NetworkTable goalTracking = NetworkTable.getTable("SmartDashboard");

    public DriveToGoalCommand(double distanceInches, double speed) {
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
        
        double goalLocation = goalTracking.getNumber("SHAPE_X_COORD", 0);
        
        
//        System.out.println("isFINISHED ****** MedianTicks: " + Double.toString(medianDistanceTraveled) + 
//                "   MedianInches CONVERTED: " + Double.toString(medianInchesTraveled));
        
//        return ((Math.abs(medianInchesTraveled)  > Math.abs(inchesToTravel)) || (goal) ;
        
        return ((Math.abs(medianInchesTraveled)  > Math.abs(inchesToTravel)) || 
        		(goalLocation <= (GOAL_CENTER + LOCATION_FUZZINESS) && goalLocation >= (GOAL_CENTER - LOCATION_FUZZINESS)));
        
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
        this.end();
    }
}
