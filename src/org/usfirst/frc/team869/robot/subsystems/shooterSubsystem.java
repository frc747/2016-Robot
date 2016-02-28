package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.stopShoot;

/**
 *
 */
public class shooterSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon talonShooter = new CANTalon (RobotMap.shooterMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new stopShoot());
    	
    }
    public void setShooterSpeed (double shooterSpeed){
    	//Set intake drive speed
    	talonShooter.set((shooterSpeed));
    	System.out.print("running shooter");	
    }
    
    
    
}

