package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.PauseCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossDefenseANDshoot extends CommandGroup {
    
    public  CrossDefenseANDshoot() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossDefense.TRAVEL_DISTANCE, AutonomousConfig.CrossDefense.TRAVEL_SPEED));
        //pause for 'X' seconds
        addSequential(new PauseCommand(.5));
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossDefense.ROTATE_SPEED, AutonomousConfig.CrossDefense.ROTATE_GOAL_ANGLE));
        addSequential(new PauseCommand(.25));
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossDefense.TRAVEL_DISTANCE_2, AutonomousConfig.CrossDefense.TRAVEL_SPEED_2));
    }
}
