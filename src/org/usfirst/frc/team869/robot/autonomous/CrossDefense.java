package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossDefense extends CommandGroup {
    
    public  CrossDefense() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossDefense.TRAVEL_DISTANCE, AutonomousConfig.CrossDefense.TRAVEL_SPEED));
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossDefense.ROTATE_SPEED, AutonomousConfig.CrossDefense.ROTATE_ANGLE));
        
    }
}
