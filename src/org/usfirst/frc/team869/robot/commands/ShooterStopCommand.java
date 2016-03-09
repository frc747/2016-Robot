package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterStopCommand extends Command {

    public ShooterStopCommand() {
        requires(Robot.SHOOTER_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.SHOOTER_SYSTEM.setShooterReady(false);
        Robot.SHOOTER_SYSTEM.setShooterSpeed(0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
    protected void interrupted() {
        end();
    }
}
