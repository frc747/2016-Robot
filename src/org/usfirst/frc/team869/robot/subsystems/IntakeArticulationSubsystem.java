package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.ArticulateIntakeCommand;

public class IntakeArticulationSubsystem extends Subsystem {
 	
	public static int downPosition = 0; //TODO - Change this to a boolean
	public static DoubleSolenoid articulateIntake = new DoubleSolenoid (RobotMap.INTAKE_DEPLOY, RobotMap.INTAKE_STOW);

    public void initDefaultCommand() {

    	setDefaultCommand(new ArticulateIntakeCommand());
    	
    	//Make sure to only set the doublesolenoid to off if the last position of the intake was down
    	/*if (downPosition == 1){
    		setDefaultCommand(new articulateIntake("down"));
    	} else {
    		setDefaultCommand(new articulateIntake("up"));
    		
    	}*/
    }
    
    public static void articulateIntakeDown (){
    	articulateIntake.set(DoubleSolenoid.Value.kForward);
    	downPosition = 1;
    }
    
    public static void articulateIntakeUp (){
    	articulateIntake.set(DoubleSolenoid.Value.kReverse);
    	downPosition = 0;
    }
    
    public static void articulateIntakeOff (){
    	articulateIntake.set(DoubleSolenoid.Value.kOff);
    }
}

