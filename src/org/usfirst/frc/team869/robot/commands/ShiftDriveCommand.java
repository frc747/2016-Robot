package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftDriveCommand extends Command {
    private boolean nextGear;
    
    public ShiftDriveCommand(boolean gear) {
        nextGear = gear;
        requires(Robot.DRIVE_SHIFT_SYSTEM);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        if (nextGear == RobotMap.HIGH_SPEED){
            Robot.DRIVE_SHIFT_SYSTEM.shiftHighSpeed();
        } else if (nextGear == RobotMap.LOW_SPEED) {
            Robot.DRIVE_SHIFT_SYSTEM.shiftLowSpeed();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
