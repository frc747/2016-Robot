package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArticulationSubsystem extends Subsystem {
    
    private DoubleSolenoid articulateIntake = new DoubleSolenoid (RobotMap.Solenoid.INTAKE_DEPLOY, RobotMap.Solenoid.INTAKE_STOW);
    private Solenoid flopperRelaxer = new Solenoid(RobotMap.Solenoid.FLOPPER_RELAXER);
    
    

    public void initDefaultCommand() {
    }
    
    public void articulateIntakeDown (){
        articulateIntake.set(DoubleSolenoid.Value.kForward);
        flopperRelaxer.set(false);
    }
    
    public void articulateIntakeUp (){
        articulateIntake.set(DoubleSolenoid.Value.kReverse);
        flopperRelaxer.set(false);
    }
    
    public void articulateIntakeOff (){
        articulateIntake.set(DoubleSolenoid.Value.kOff);
        flopperRelaxer.set(true);
    }

}

