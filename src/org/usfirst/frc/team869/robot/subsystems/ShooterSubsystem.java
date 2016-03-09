package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.ShooterStopCommand;

public class ShooterSubsystem extends Subsystem {
 
    private CANTalon talonShooter = new CANTalon (RobotMap.SHOOTER_MOTOR);
    private boolean  isShooterReady;
    
    public ShooterSubsystem(){
        isShooterReady = false;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterStopCommand());
    }
    
    public void setShooterSpeed (double shooterSpeed){
        talonShooter.set((shooterSpeed));
    }
    
    public boolean isShooterReady(){
        return isShooterReady;
    }

    public void setShooterReady(boolean isShooterReady) {
        this.isShooterReady = isShooterReady;
    }
}

