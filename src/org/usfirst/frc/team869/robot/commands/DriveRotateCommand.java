package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Negative degrees is anti-clockwise and positive degrees is clockwise
 */
public class DriveRotateCommand extends Command {
    
    private double speed;
    private int    degrees;
    
    private static final int DEGREE_FUZZINESS = 10;

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
    }

    protected boolean isFinished() {
        return (Robot.DRIVE_TRAIN.getNavX360Angle() <= (this.degrees + DriveRotateCommand.DEGREE_FUZZINESS) && Robot.DRIVE_TRAIN.getNavX360Angle() >= (this.degrees - DriveRotateCommand.DEGREE_FUZZINESS));
    }

    protected void end() {
        Robot.DRIVE_TRAIN.setTankDrive(0, 0);
    }

    protected void interrupted() {
        this.end();
    }
}
