package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArticulateUpCommand extends Command{

    public IntakeArticulateUpCommand() {
        requires(Robot.INTAKE_ARTICULATION);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        Robot.INTAKE_ARTICULATION.articulateIntakeUp();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
