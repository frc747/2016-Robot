package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.ArticulateIntake;


/**
 *
 */
public class intakeArticulationSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static int downPosition = 0;
	public static DoubleSolenoid articulateIntake = new DoubleSolenoid (RobotMap.articulateIntakeDownSolenoid, RobotMap.articulateIntakeUpSolenoid);
	
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    	setDefaultCommand(new ArticulateIntake());
    	
    	
    	
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

