package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBallInCommand extends Command {
    
    private double timeOutValue, startTimeValue;
    

    public IntakeBallInCommand(double timeOut, double startTime) {
        requires(Robot.INTAKE_SYSTEM);
        
        this.timeOutValue = timeOut;
        this.startTimeValue = startTime;
        
        
        this.setTimeout(this.timeOutValue);
        
    }

    protected void initialize() {
    }

    protected void execute() {
        
        if (this.timeSinceInitialized() >= this.startTimeValue){
            Robot.INTAKE_SYSTEM.setIntakeSpeed(RobotMap.INTAKE_SPEED);            
        }

    }

    protected boolean isFinished() {
        
        if (this.timeOutValue > 0){
            return this.isTimedOut();
        } else {
            return false;
        }
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
