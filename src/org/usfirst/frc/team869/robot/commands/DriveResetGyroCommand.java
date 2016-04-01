package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveResetGyroCommand extends Command {

    public DriveResetGyroCommand() {
        requires(Robot.DRIVE_TRAIN);
    }

    protected void initialize() {
    }

    protected void execute() {        
        Robot.DRIVE_TRAIN.resetNavXYaw();
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }

    protected void interrupted() {
    }
}
