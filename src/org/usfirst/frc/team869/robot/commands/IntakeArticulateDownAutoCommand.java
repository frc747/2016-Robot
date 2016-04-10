package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArticulateDownAutoCommand extends Command{

    public IntakeArticulateDownAutoCommand() {
        requires(Robot.INTAKE_ARTICULATION);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.INTAKE_ARTICULATION.articulateIntakeDown();
        end();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        new IntakeRelaxAutoCommand().start();
        isFinished();
    }

    protected void interrupted() {
        end();
    }
}
