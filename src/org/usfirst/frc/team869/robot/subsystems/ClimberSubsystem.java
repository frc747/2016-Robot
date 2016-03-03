package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team869.robot.*;
import org.usfirst.frc.team869.robot.commands.ClimbRetractCommand;

public class ClimberSubsystem extends Subsystem {
	
	DoubleSolenoid climbSolenoid = new DoubleSolenoid (RobotMap.CLIMB_EXTEND, RobotMap.CLIMB_RETRACT);

    public void initDefaultCommand() {
    	setDefaultCommand(new ClimbRetractCommand());
    }
    
    public void climbExtend (){
    	climbSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void climbRetract (){
    	climbSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
