package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterShootCommand extends Command {
	
	private double timeOutValue;

    public ShooterShootCommand(double timeOut) {
        requires(Robot.SHOOTER_SYSTEM);
        
        this.timeOutValue = timeOut;
        
        
        this.setTimeout(timeOut);
        
        
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.SHOOTER_SYSTEM.setShooterSpeed(RobotMap.SHOOTER_SPEED);
    }

    protected boolean isFinished() {
    	
    	
    	if (this.timeOutValue > 0){
    		return this.isTimedOut();
    	} else{
    		return false;
    	}
    	
    }

    protected void end() {
    }

    protected void interrupted() {
        this.end();
    }
}
