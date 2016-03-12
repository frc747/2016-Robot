package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArticulationSubsystem extends Subsystem {
    
    private DoubleSolenoid articulateIntake = new DoubleSolenoid (RobotMap.INTAKE_DEPLOY, RobotMap.INTAKE_STOW);

    public void initDefaultCommand() {
    }
    
    public void articulateIntakeDown (){
        articulateIntake.set(DoubleSolenoid.Value.kForward);
    }
    
    public void articulateIntakeUp (){
        articulateIntake.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void articulateIntakeOff (){
        articulateIntake.set(DoubleSolenoid.Value.kOff);
    }

}

