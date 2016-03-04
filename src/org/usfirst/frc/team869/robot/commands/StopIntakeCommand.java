package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopIntakeCommand extends Command {

    public StopIntakeCommand() {
    	requires(Robot.intakeSystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intakeSystem.setIntakeSpeed(0);
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
