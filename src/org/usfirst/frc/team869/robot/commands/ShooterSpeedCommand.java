package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;
import java.util.Timer;
import org.usfirst.frc.team869.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterSpeedCommand extends Command {
	Timer runTime = new Timer();
	

    public ShooterSpeedCommand() {
        requires(Robot.SHOOTER_SYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
        
	    if (OI.getOperatorShoot() >= RobotMap.TRIGGER_THRESHOLD){
	        Robot.SHOOTER_SYSTEM.setShooterSpeed(RobotMap.SHOOTER_SPEED);
	        System.out.print("ShooterON");
	    } else{
	    	Robot.SHOOTER_SYSTEM.setShooterSpeed(0);
	    	 System.out.print("ShooterOFF");
	    }
        
       
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
