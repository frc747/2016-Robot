package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArticulateDownCommand extends Command{

    public IntakeArticulateDownCommand() {
        requires(Robot.INTAKE_ARTICULATION);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.INTAKE_ARTICULATION.articulateIntakeDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.INTAKE_ARTICULATION.articulateIntakeOff();
    }

    protected void interrupted() {
        end();
    }
}
