package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBallInCommand extends Command {

    public IntakeBallInCommand() {
        requires(Robot.INTAKE_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.INTAKE_SYSTEM.setIntakeSpeed(RobotMap.INTAKE_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
