package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArticulateCommand extends Command {
    
    //TODO - This should not be a string.
    private String intake;    

    public IntakeArticulateCommand() {
        requires(Robot.INTAKE_ARTICULATION);
        intake = "up";
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if (OI.getOperatorLeftJoy() >= RobotMap.JOYSTICK_THRESHOLD){
            Robot.INTAKE_ARTICULATION.articulateIntakeUp();
            intake = "up";
        } else if (OI.getOperatorLeftJoy() < -RobotMap.JOYSTICK_THRESHOLD){
            Robot.INTAKE_ARTICULATION.articulateIntakeDown();
            intake = "down";
        } else {
            if (intake.equals("down")){ 
                Robot.INTAKE_ARTICULATION.articulateIntakeOff();
            } else{
                Robot.INTAKE_ARTICULATION.articulateIntakeUp();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
