package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterStartCommand extends Command {

    public ShooterStartCommand() {
        requires(Robot.SHOOTER_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.SHOOTER_SYSTEM.setShooterSpeed(RobotMap.SHOOTER_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
