package org.usfirst.frc.team869.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team869.robot.subsystems.*;
import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.Robot;

public class DriveWithJoysticksCommand extends Command {
	
    public DriveWithJoysticksCommand() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }
    
    protected void execute() {
    	Robot.driveTrain.setTankDrive((OI.getRightDriveSpeed()), (OI.getLeftDriveSpeed()));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
