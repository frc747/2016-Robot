package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceStraightCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.DriveToShootCommand;
import org.usfirst.frc.team869.robot.commands.DriveWithCameraToGoalCommand;
import org.usfirst.frc.team869.robot.commands.IntakeBallInCommand;
import org.usfirst.frc.team869.robot.commands.PauseCommand;
import org.usfirst.frc.team869.robot.commands.ShooterShootCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossRockwallANDshoot extends CommandGroup {
    
    public  CrossRockwallANDshoot() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        addSequential(new DriveDistanceStraightCommand(AutonomousConfig.CrossRockwall.TRAVEL_DISTANCE, 
        										AutonomousConfig.CrossRockwall.TRAVEL_SPEED,0));
        //pause for 'X' seconds
        addSequential(new PauseCommand(.3));
        
        
        //rotate to 90 to point the kinect towards the goal
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRockwall.ROTATE_SPEED, AutonomousConfig.CrossRockwall.ROTATE_SEEK_ANGLE));
        //drive straight and Find the goal with the kinect
        addSequential(new DriveWithCameraToGoalCommand(100, -.2));
        
        //ADD in settle at goal (Drive left or right slowly)
        
        //Rotate the robot towards the goal
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRockwall.ROTATE_SPEED, AutonomousConfig.CrossRockwall.ROTATE_GOAL_ANGLE));
        //pause to settle robot after it's turn
        addSequential(new PauseCommand(.25));
        //Drive up to goal to begin shoot. Also start the shooter in parallel to get it revved up
        addParallel(new DriveToShootCommand(30, -.3, 90));
        addSequential(new ShooterShootCommand(5));
      
        //start the shooter again in parallel so it stays running through the final approach and intake feed
        addParallel(new ShooterShootCommand(9));  
        addParallel(new DriveDistanceCommand(28, -.07)); //sets drive train at hold speed to press against tower
        addSequential(new IntakeBallInCommand(10,0));  //feed the fall into the shooter.
        
        
        
    }
}
