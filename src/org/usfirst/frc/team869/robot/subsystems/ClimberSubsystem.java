package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
/*remove this
import edu.wpi.first.wpilibj.DoubleSolenoid;
*/
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team869.robot.*;
import org.usfirst.frc.team869.robot.commands.ClimbRetractCommand;

public class ClimberSubsystem extends Subsystem {
    /*remove this
    private Solenoid climbLock = new Solenoid(RobotMap.Solenoid.CLIMB_LOCK);
    */
    private Solenoid climbExtend = new Solenoid(RobotMap.Solenoid.CLIMB_EXTEND);
    private Solenoid climbRetract = new Solenoid(RobotMap.Solenoid.CLIMB_RETRACT);
    

    public void initDefaultCommand() {
        setDefaultCommand(new ClimbRetractCommand());
    }
    
    public void climbExtend (){
    	climbExtend.set(true);
    	climbRetract.set(true);
    	
    }
    public void climbRetract (){
    	climbExtend.set(false);
    	climbRetract.set(false);
    }
    /*remove this
    public void climbLockOn (){
        climbLock.set(true);
    }
    public void climbLockOff(){
        climbLock.set(false);
    }*/
}
