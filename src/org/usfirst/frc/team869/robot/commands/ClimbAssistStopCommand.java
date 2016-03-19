package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbAssistStopCommand extends Command {

    public ClimbAssistStopCommand() {
        requires(Robot.CLIMBER_ASSIST_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.CLIMBER_ASSIST_SYSTEM.climbStop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
