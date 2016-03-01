package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.StopShootCommand;

public class ShooterSubsystem extends Subsystem {
 
	CANTalon talonShooter = new CANTalon (RobotMap.shooterMotor);

    public void initDefaultCommand() {
    	setDefaultCommand(new StopShootCommand());
    }
    public void setShooterSpeed (double shooterSpeed){
    	talonShooter.set((shooterSpeed));
    	System.out.print("running shooter");	
    }
}

