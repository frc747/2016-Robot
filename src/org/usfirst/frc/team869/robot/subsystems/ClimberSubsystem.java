package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team869.robot.*;
import org.usfirst.frc.team869.robot.commands.ClimbRetractCommand;

public class ClimberSubsystem extends Subsystem {

    public Solenoid climbExtend  = new Solenoid(RobotMap.Solenoid.CLIMB_EXTEND);
    public Solenoid climbRetract = new Solenoid(RobotMap.Solenoid.CLIMB_RETRACT);

    public void initDefaultCommand() {
        setDefaultCommand(new ClimbRetractCommand());
    }
    
    public void climbExtend (){
        climbExtend.set(true);
        climbRetract.set(true);
        System.out.println("in climbExtend");
        
    }
    public void climbRetract (){
        climbExtend.set(false);
        climbRetract.set(false);
        System.out.println("in climbRetract");
    }
}
