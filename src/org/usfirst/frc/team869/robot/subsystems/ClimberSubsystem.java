package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team869.robot.*;
import org.usfirst.frc.team869.robot.commands.ClimbRetractCommand;

public class ClimberSubsystem extends Subsystem {
    
    private DoubleSolenoid climbSolenoid = new DoubleSolenoid (RobotMap.CLIMB_EXTEND, RobotMap.CLIMB_RETRACT);
    private Solenoid climbLock = new Solenoid(RobotMap.CLIMB_LOCK);

    public void initDefaultCommand() {
        setDefaultCommand(new ClimbRetractCommand());
    }
    
    public void climbExtend (){
        climbSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void climbRetract (){
        climbSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void climbLockOn (){
    	climbLock.set(true);
    }
    public void climbLockOff(){
    	climbLock.set(false);
    }
}
