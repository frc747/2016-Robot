package org.usfirst.frc.team869.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;

public class AutoReachDefense extends CommandGroup {
    
    public  AutoReachDefense() {
        
        requires(Robot.DRIVE_TRAIN);
        addSequential(new DriveDistanceCommand(AutonomousConfig.ReachDefenses.DISTANCE, AutonomousConfig.ReachDefenses.SPEED));
    }
}
