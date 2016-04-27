package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.PauseCommand;
import org.usfirst.frc.team869.robot.commands.ShooterShootCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceSpeedOffsetCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceStraightCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.DriveToShootCommand;
import org.usfirst.frc.team869.robot.commands.DriveWithCameraToGoalCommand;
import org.usfirst.frc.team869.robot.commands.IntakeBallInCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossRampartsANDshoot extends CommandGroup {
    
    public  CrossRampartsANDshoot() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   /*
        //reach ramparts
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossRamparts.REACH_RAMPARTS, AutonomousConfig.CrossRamparts.SPEED_EQUAL));
        //cross ramparts
        addSequential(new DriveDistanceSpeedOffsetCommand(AutonomousConfig.CrossRamparts.CROSS_RAMPARTS, 
        													AutonomousConfig.CrossRamparts.SPEED_LEFT, 
        													AutonomousConfig.CrossRamparts.SPEED_RIGHT));
        
     *///removing to try to drive straight with gyro instead. may have to readd. 
        
        addSequential(new DriveDistanceStraightCommand(AutonomousConfig.CrossRamparts.CROSS_ALL_THE_WAY, 
        												AutonomousConfig.CrossRamparts.SPEED_EQUAL, 0));
        //pause to settle after cross ramparts
        addSequential(new PauseCommand(.3));
        

        //rotate to 90 to point the kinect towards the goal
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRamparts.ROTATE_SPEED, AutonomousConfig.CrossRamparts.ROTATE_SEEK_ANGLE));
        //drive straight and Find the goal with the kinect
        addSequential(new DriveWithCameraToGoalCommand(100, -.2));
        
        //ADD in settle at goal (Drive left or right slowly)
        
        //Rotate the robot towards the goal
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRamparts.ROTATE_SPEED, AutonomousConfig.CrossRamparts.ROTATE_GOAL_ANGLE));
        //pause to settle robot after it's turn
        addSequential(new PauseCommand(.25));
        //Drive up to goal to begin shoot. Also start the shooter in parallel to get it revved up
        addParallel(new DriveToShootCommand(30, -.3, 90));
        addSequential(new ShooterShootCommand(5));
      
        //start the shooter again in parallel so it stays running through the final approach and intake feed
        addParallel(new ShooterShootCommand(9));  
        addParallel(new DriveDistanceCommand(28, -.07)); //sets drive train at hold speed to press against tower
        addSequential(new IntakeBallInCommand(10,0));  //feed the fall into the shooter.
        
        /*
         * 1. reach ramparts
         * 2. cross ramparts
         * 3. rotate 90 degrees
         * 4. drive straight to find goal w/kinect
         * 5. rotate to 180 degrees
         * 6. drive straight until pitch increases
         * 7. slow down until no motion
         * 8. IF goal was found Sequential drive train hold speed and shoot
         */
        
        
    }
}
