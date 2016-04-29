package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.PauseCommand;
import org.usfirst.frc.team869.robot.commands.ShooterShootCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceSpeedOffsetCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceStraightCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.IntakeBallInCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossRampartsTEST extends CommandGroup {
    
    public  CrossRampartsTEST() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);

        //TESTING DRIVE STRAIGHT
        addSequential(new DriveDistanceStraightCommand(500, 1, 0));
//        addSequential(new DriveDistanceCommand(480, 1));
        
        
        
        /*
        
        addSequential(new DriveDistanceStraightCommand(AutonomousConfig.CrossRamparts.CROSS_ALL_THE_WAY, 
        												AutonomousConfig.CrossRamparts.SPEED_EQUAL, 0));
        
        //pause for 'X' seconds
        addSequential(new PauseCommand(1));
        //180 spin
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRamparts.ROTATE_SPEED, AutonomousConfig.CrossRamparts.ROTATE_GOAL_ANGLE));
        addSequential(new PauseCommand(1));
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossRamparts.APPROACH_GOAL, AutonomousConfig.CrossRamparts.SPEED_EQUAL_2));
        */
        

        
    }
}
