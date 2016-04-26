package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.PauseCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveDistanceSpeedOffsetCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossRampartsANDshoot extends CommandGroup {
    
    public  CrossRampartsANDshoot() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        //reach ramparts
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossRamparts.REACH_RAMPARTS, AutonomousConfig.CrossRamparts.SPEED_EQUAL));
        //cross ramparts
        addSequential(new DriveDistanceSpeedOffsetCommand(AutonomousConfig.CrossRamparts.CROSS_RAMPARTS, 
        													AutonomousConfig.CrossRamparts.SPEED_LEFT, 
        													AutonomousConfig.CrossRamparts.SPEED_RIGHT));
        //pause for 'X' seconds
        addSequential(new PauseCommand(1));
        //180 spin
        addSequential(new DriveRotateCommand(AutonomousConfig.CrossRamparts.ROTATE_SPEED, AutonomousConfig.CrossRamparts.ROTATE_GOAL_ANGLE));
        addSequential(new PauseCommand(.25));
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossRamparts.APPROACH_GOAL, AutonomousConfig.CrossRamparts.SPEED_EQUAL_2));
        
        
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
