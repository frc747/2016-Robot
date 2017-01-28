package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.ShooterStopCommand;

public class ShooterSubsystem extends Subsystem {
 
    private CANTalon talonShooter = new CANTalon (RobotMap.Canbus.SHOOTER_MOTOR);

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterStopCommand());
        talonShooter.setInverted(true);
    }
    
    public void setShooterSpeed (double shooterSpeed){
        talonShooter.set((shooterSpeed));
    }
}

