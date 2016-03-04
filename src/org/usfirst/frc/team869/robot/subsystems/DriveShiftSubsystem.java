package org.usfirst.frc.team869.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team869.robot.RobotMap;

public class DriveShiftSubsystem extends Subsystem {
    
    private DoubleSolenoid driveShifter = new DoubleSolenoid (RobotMap.DRIVE_HIGH_SPEED, RobotMap.DRIVE_LOW_SPEED);

    public void initDefaultCommand() {
    }
    
    public void shiftHighSpeed (){
        driveShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftLowSpeed (){
        driveShifter.set(DoubleSolenoid.Value.kReverse);
    }
}