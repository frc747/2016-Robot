package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Negative degrees is anti-clockwise and positive degrees is clockwise
 */
public class DriveRotateCommand extends Command {
    
    private double speed;
    private int    degrees;

    public DriveRotateCommand(double speed, int degrees) {
        requires(Robot.DRIVE_TRAIN);
        
        this.speed = speed;
        this.degrees = degrees;
    }

    protected void initialize() {
        Robot.DRIVE_TRAIN.resetNavXYaw();
    }

    protected void execute() {
        Robot.DRIVE_TRAIN.setTankDrive(speed, -speed);
        System.out.println("ROTATING******************");
        
    }

    protected boolean isFinished() {
    	
    	boolean stopRotate = false;
    	
    	if (Robot.DRIVE_TRAIN.getNavX360Angle() <= (this.degrees + 10) && Robot.DRIVE_TRAIN.getNavX360Angle() >= (this.degrees - 10)){
    		stopRotate = true;
    	}
//    	if (this.degrees > 0){
//    	 Robot.DRIVE_TRAIN.getNavX360Angle() >= this.degrees ;
//    	} else if (this.degrees < 0) {
//         Robot.DRIVE_TRAIN.getNavX360Angle() <= this.degrees ;
//    		
//    	}
    		
    	return stopRotate;
        
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
        this.end();
    }
}
