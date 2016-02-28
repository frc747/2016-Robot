package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
//import org.usfirst.frc.team869.robot.subsystems.intakeArticulationSubsystem;
import org.usfirst.frc.team869.robot.OI;


import edu.wpi.first.wpilibj.command.Command;




/**
 *
 */
public class articulateIntake extends Command {
	
	public String intake;

	//public static final intakeArticulationSubsystem articulateIntake = new intakeArticulationSubsystem();

    public articulateIntake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	
    	requires(Robot.intakeArticulation);
    	
    	//requires(articulateIntake);
    	
    	
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intake = "up";
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	// 	Robot.DriveTrain.setTankDrive((OI.getRightDriveSpeed()), (OI.getLeftDriveSpeed()));
    	
    	if (OI.getOperatorLeftJoy() >= .75){
    		Robot.intakeArticulation.articulateIntakeDown();
    		intake = "down";
    	} else if (OI.getOperatorLeftJoy() < -.75){
    		Robot.intakeArticulation.articulateIntakeUp();
    		intake = "up";
    	} else {
    		if (intake == "down"){
    			Robot.intakeArticulation.articulateIntakeOff();
    		} else{
    			Robot.intakeArticulation.articulateIntakeUp();
    		}
    	}
    	/*if (intakeLocation == "up"){
    		
    	}*/
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
