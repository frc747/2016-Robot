package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterShootCommand extends Command {
    
    private double speed;

    public ShooterShootCommand() {
        requires(Robot.SHOOTER_SYSTEM);
        this.speed = RobotMap.SHOOTER_SPEED;
    }
    
    public ShooterShootCommand(double speed){
        this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.SHOOTER_SYSTEM.setShooterSpeed(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        this.end();
    }
}
