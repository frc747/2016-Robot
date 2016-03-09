package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeStopCommand extends Command {

    public IntakeStopCommand() {
        requires(Robot.INTAKE_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.INTAKE_SYSTEM.setIntakeSpeed(0, true);
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
