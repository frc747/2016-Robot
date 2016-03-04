package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopShootCommand extends Command {

    public StopShootCommand() {
    	requires(Robot.shooterSystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.shooterSystem.setShooterSpeed(0);
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
