package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.*;
import org.usfirst.frc.team869.robot.commands.climbRetractCommand;


import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class climberSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid climbSolenoid = new DoubleSolenoid (RobotMap.climbExtendSolenoid, RobotMap.climbRetractSolenoid);
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new climbRetractCommand());
    	
    }
    
    public void climbExtend (){
    	climbSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void climbRetract (){
    	climbSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

