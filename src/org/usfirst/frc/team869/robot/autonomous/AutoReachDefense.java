package org.usfirst.frc.team869.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;

public class AutoReachDefense extends CommandGroup {
    
    private double speed    = -.25;
    private double distance = RobotMap.AUTO_TEST_DISTANCE;
    
    
    public  AutoReachDefense() {
        
        requires(Robot.DRIVE_TRAIN);
        
        addSequential(new DriveDistanceCommand(this.distance, this.speed));
        
    }
}
