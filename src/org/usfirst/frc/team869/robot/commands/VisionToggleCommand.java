package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionToggleCommand extends Command {

    public VisionToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	/*Added this*/
    	requires(Robot.DUAL_CAMERA);
    	/*Added this*/
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*Added this*/
    	Robot.DUAL_CAMERA.switchCameras();
    	isFinished();
    	/*Added this*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*Added this*/
        return true;
        /*Added this*/
        
        /*removed this
         * return false;
         */
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
