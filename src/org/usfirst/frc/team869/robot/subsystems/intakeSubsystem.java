package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.stopIntake;

/**
 *
 */
public class intakeSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/*
	 * at 11.9V the motor runs at 4450
	 */
	
	DigitalInput transferOpticalGate = new DigitalInput (RobotMap.ballTransferLimit);
	CANTalon talonIntake = new CANTalon (RobotMap.intakeMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new stopIntake());
    	
    }

    public void setIntakeSpeed (double intakeSpeed){
    	//Set intake drive speed
    	
    	if (!transferOpticalGate.get()){
    		talonIntake.set((intakeSpeed));
    		System.out.print("running intake @" + intakeSpeed + " speed optical gate not tripped\r");	
    	}/*else if (!transferOpticalGate.get() && ){
    		Need to set a condition here where it will enable if the shooter is at speed
    	}*/else {
    		talonIntake.set((0));
    		System.out.print("running intake @ 0 speed\r");	
    	}
    	
    	
    }

}



