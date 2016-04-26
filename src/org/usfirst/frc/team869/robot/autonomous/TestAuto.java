package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveToGoalCommand;
import org.usfirst.frc.team869.robot.commands.DriveToShootCommand;
import org.usfirst.frc.team869.robot.commands.IntakeBallInCommand;
import org.usfirst.frc.team869.robot.commands.ShooterShootCommand;

import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.PauseCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup {
    
    public  TestAuto() {
        
        requires(Robot.DRIVE_TRAIN);
//        requires(Robot.INTAKE_ARTICULATION);
   
        addSequential(new DriveToGoalCommand(100, -.2));
        //pause for 'X' seconds
        addSequential(new PauseCommand(.5));
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRamparts.ROTATE_SPEED, 96));
        addSequential(new PauseCommand(.5));
        addParallel(new DriveToShootCommand(30, -.3));
        addSequential(new ShooterShootCommand(5));
        
        addParallel(new ShooterShootCommand(9));
//        addParallel(new PauseCommand(.2));
//        addParallel(new DriveToShootCommand(0, -.07));
        addParallel(new DriveToShootCommand(28, -.07));
        addSequential(new IntakeBallInCommand(0,0));
//        addSequential(new PauseCommand(.5));
        
        
//        addSequential(new DriveRotateCommand(AutonomousConfig.CrossDefense.ROTATE_SPEED, AutonomousConfig.CrossDefense.ROTATE_ANGLE));
//        addSequential(new PauseCommand(.25));
//        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossDefense.TRAVEL_DISTANCE_2, AutonomousConfig.CrossDefense.TRAVEL_SPEED_2));
    }
}
