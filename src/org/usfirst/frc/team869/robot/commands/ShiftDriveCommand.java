package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftDriveCommand extends Command {
	public boolean nextGear;
	
    public ShiftDriveCommand(boolean gear) {
    	nextGear = gear;
    	requires(Robot.driveShiftSystem);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	if (nextGear == RobotMap.HIGH_SPEED){
    		Robot.driveShiftSystem.shiftHighSpeed();
    	} else if (nextGear == RobotMap.LOW_SPEED) {
    		Robot.driveShiftSystem.shiftLowSpeed();
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
