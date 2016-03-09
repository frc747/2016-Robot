package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterShootCommand extends Command {

    public ShooterShootCommand() {
        requires(Robot.SHOOTER_SYSTEM);
    }

    protected void initialize() {
        this.setTimeout(RobotMap.SHOOTER_SPIN_UP_TIMEOUT);
    }

    protected void execute() {
        Robot.SHOOTER_SYSTEM.setShooterSpeed(RobotMap.SHOOTER_SPEED);
        if(isTimedOut()){
            Robot.SHOOTER_SYSTEM.setShooterReady(true);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.SHOOTER_SYSTEM.setShooterReady(false);
    }

    protected void interrupted() {
        this.end();
    }
}
