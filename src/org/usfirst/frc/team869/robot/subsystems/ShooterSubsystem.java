package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.ShooterSpeedCommand;

public class ShooterSubsystem extends Subsystem {
 
    private CANTalon talonShooter = new CANTalon (RobotMap.SHOOTER_MOTOR);

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterSpeedCommand());
    }
    
    public void setShooterSpeed (double shooterSpeed){
        talonShooter.set((shooterSpeed));
        //TODO - Remove for Production
        System.out.print("running shooter");    
    }
}

