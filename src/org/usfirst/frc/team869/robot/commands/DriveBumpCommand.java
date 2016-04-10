package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBumpCommand extends Command {
    
    public DriveBumpCommand() {
        requires(Robot.DRIVE_TRAIN);
    }

    protected void initialize() {
        this.setTimeout(RobotMap.Timeout.DRIVE_BUMP_TIMEOUT);
    }
    
    protected void execute() {
        Robot.DRIVE_TRAIN.setTankDrive(RobotMap.Speed.BUMP_SPEED, RobotMap.Speed.BUMP_SPEED);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
        this.end();
    }
}
