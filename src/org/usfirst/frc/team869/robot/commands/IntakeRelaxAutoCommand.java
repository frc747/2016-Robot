package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeRelaxAutoCommand extends Command{

    public IntakeRelaxAutoCommand() {
        requires(Robot.INTAKE_ARTICULATION);
    }

    protected void initialize() {
        this.setTimeout(RobotMap.Timeout.INTAKE_ARTICULATE_BUMP_UP);
    }

    protected void execute() {
        Robot.INTAKE_ARTICULATION.articulateIntakeUp();
        end();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        Robot.INTAKE_ARTICULATION.articulateIntakeOff();
        isFinished();
    }

    protected void interrupted() {
        end();
    }
}
