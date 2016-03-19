package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbRetractCommand extends Command {

    public ClimbRetractCommand() {
        requires(Robot.CLIMBER_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.CLIMBER_SYSTEM.climbRetract();
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
