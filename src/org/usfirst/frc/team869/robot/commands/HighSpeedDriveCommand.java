package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HighSpeedDriveCommand extends Command {
    
    
    public HighSpeedDriveCommand() {
        requires (Robot.DRIVE_SHIFT_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.DRIVE_SHIFT_SYSTEM.shiftHighSpeed();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
