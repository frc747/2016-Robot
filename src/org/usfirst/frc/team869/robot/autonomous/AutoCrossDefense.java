package org.usfirst.frc.team869.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;

public class AutoCrossDefense extends CommandGroup {
    
    public  AutoCrossDefense() {
        
        requires(Robot.DRIVE_TRAIN);
        
        double speed = .5;
        //TODO find a good distance to travel
        double distance = 50;        
        
        addSequential(new DriveDistanceCommand(distance, speed));
        
    }
}
