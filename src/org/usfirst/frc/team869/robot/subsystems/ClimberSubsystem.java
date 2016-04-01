package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team869.robot.*;
import org.usfirst.frc.team869.robot.commands.ClimbRetractCommand;

public class ClimberSubsystem extends Subsystem {
    
//    private DoubleSolenoid climbSolenoid = new DoubleSolenoid (RobotMap.Solenoid.CLIMB_EXTEND, RobotMap.Solenoid.CLIMB_RETRACT);
    private Solenoid climbLock = new Solenoid(RobotMap.Solenoid.CLIMB_LOCK);
    private Solenoid climbExtend = new Solenoid(RobotMap.Solenoid.CLIMB_EXTEND);
    private Solenoid climbRetract = new Solenoid(RobotMap.Solenoid.CLIMB_RETRACT);
    

    public void initDefaultCommand() {
        setDefaultCommand(new ClimbRetractCommand());
    }
    
    public void climbExtend (){
//        climbSolenoid.set(DoubleSolenoid.Value.kForward);
    	climbExtend.set(true);
    	climbRetract.set(true);
    	
    }
    public void climbRetract (){
//        climbSolenoid.set(DoubleSolenoid.Value.kReverse);
    	climbExtend.set(false);
    	climbRetract.set(false);
    }
    public void climbLockOn (){
        climbLock.set(true);
    }
    public void climbLockOff(){
        climbLock.set(false);
    }
}
