package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArticulateUpAutoCommand extends Command{

    public IntakeArticulateUpAutoCommand() {
        requires(Robot.INTAKE_ARTICULATION);
    }
    
    protected void initialize() {
    	//this.setTimeout(1);
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
