package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeRelaxCommand extends Command{

    public IntakeRelaxCommand() {
        requires(Robot.INTAKE_ARTICULATION);
    }

    protected void initialize() {
        this.setTimeout(RobotMap.INTAKE_ARTICULATE_BUMP_UP_TIMEOUT);
    }

    protected void execute() {
        Robot.INTAKE_ARTICULATION.articulateIntakeUp();
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
        Robot.INTAKE_ARTICULATION.articulateIntakeOff();
    }

    protected void interrupted() {
        end();
    }
}
