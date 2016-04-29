package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.PauseCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceSpeedOffsetCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceStraightCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossRamparts extends CommandGroup {
    
    public  CrossRamparts() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        //reach ramparts
        addSequential(new DriveDistanceStraightCommand(AutonomousConfig.CrossRamparts.CROSS_ALL_THE_WAY, 
        		AutonomousConfig.CrossRamparts.SPEED_EQUAL,0));
        //cross ramparts
//        addSequential(new DriveDistanceSpeedOffsetCommand(AutonomousConfig.CrossRamparts.CROSS_RAMPARTS, 
//        													AutonomousConfig.CrossRamparts.SPEED_LEFT, 
//        													AutonomousConfig.CrossRamparts.SPEED_RIGHT));
        //pause for 'X' seconds
        addSequential(new PauseCommand(1));
        //180 spin
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRamparts.ROTATE_SPEED, AutonomousConfig.CrossRamparts.ROTATE_GOAL_ANGLE));
        addSequential(new PauseCommand(.25));
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossRamparts.APPROACH_GOAL, AutonomousConfig.CrossRamparts.SPEED_EQUAL_2));
        
        
    }
}
