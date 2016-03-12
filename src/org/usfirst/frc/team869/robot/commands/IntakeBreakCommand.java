package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBreakCommand extends Command {

    public IntakeBreakCommand() {
        requires(Robot.INTAKE_SYSTEM);
    }

    protected void initialize() {
        this.setTimeout(RobotMap.INTAKE_BREAK_TIMEOUT);
    }

    protected void execute() {
        Robot.INTAKE_SYSTEM.setIntakeSpeed(-1*(RobotMap.INTAKE_SPEED));
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
