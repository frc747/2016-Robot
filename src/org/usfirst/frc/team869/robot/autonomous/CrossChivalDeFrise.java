package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.IntakeArticulateDownAutoCommand;
import org.usfirst.frc.team869.robot.commands.IntakeArticulateUpAutoCommand;
import org.usfirst.frc.team869.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class CrossChivalDeFrise extends CommandGroup {
	
    public  CrossChivalDeFrise() {
  
    	requires(Robot.DRIVE_TRAIN);
    	requires(Robot.INTAKE_ARTICULATION);
    	
    	
    	addSequential(new IntakeArticulateUpAutoCommand());
    	addSequential(new DriveDistanceCommand(AutonomousConfig.CrossWackyBridges.INCH_TO_BRIDGE, AutonomousConfig.CrossWackyBridges.SPEED));
    	addSequential(new IntakeArticulateDownAutoCommand());
    	addSequential(new DriveDistanceCommand(AutonomousConfig.CrossWackyBridges.INCH_OVER_BRIDGE, AutonomousConfig.CrossWackyBridges.SPEED));
    	
    	
    }
}
