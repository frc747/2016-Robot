package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Command;
//import org.usfirst.frc.team869.robot.subsystems.intakeSubsystem;

/**
 *
 */
public class pickUpBallCommand extends Command {

    public pickUpBallCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.intakeSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//driveShiftSystem.shiftHighTorque();
    	
    	Robot.intakeSystem.setIntakeSpeed(RobotMap.constantIntakeSpeed);
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Robot.intakeSystem.setIntakeSpeed(0);
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.intakeSystem.setIntakeSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
