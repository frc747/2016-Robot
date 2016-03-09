package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBallOutCommand extends Command {

    public IntakeBallOutCommand() {
        requires(Robot.INTAKE_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.INTAKE_SYSTEM.setIntakeSpeed(-1*(RobotMap.INTAKE_SPEED), true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
