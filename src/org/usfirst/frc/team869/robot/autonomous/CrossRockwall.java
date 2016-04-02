package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossRockwall extends CommandGroup {
    
    public  CrossRockwall() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossRockwall.TRAVEL_DISTANCE, AutonomousConfig.CrossRockwall.TRAVEL_SPEED));
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRockwall.ROTATE_SPEED, AutonomousConfig.CrossRockwall.ROTATE_ANGLE));
        
    }
}
