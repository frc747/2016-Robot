package org.usfirst.frc.team869.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.IntakeArticulateDownCommand;

public class CrossDefense extends CommandGroup {
    
    public  CrossDefense() {
        
        requires(Robot.DRIVE_TRAIN);
        requires(Robot.INTAKE_ARTICULATION);
   
        
       // addSequential(new IntakeArticulateDownCommand());
        addSequential(new DriveDistanceCommand(AutonomousConfig.CrossDefense.DISTANCE, AutonomousConfig.CrossDefense.SPEED));
        addSequential(new DriveRotateCommand((.5), 180));
        
    }
}
