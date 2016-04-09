package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.IntakeArticulateDownCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossWackyBridges extends CommandGroup {
    
    public  CrossWackyBridges() {
    	requires(Robot.DRIVE_TRAIN);
    	requires(Robot.INTAKE_ARTICULATION);
	
    	addSequential(new DriveDistanceCommand(AutonomousConfig.CrossWackyBridges.INCH_TO_BRIDGE, 
    													AutonomousConfig.CrossWackyBridges.SPEED));
    	addSequential(new IntakeArticulateDownCommand());
    	addSequential(new DriveDistanceCommand(AutonomousConfig.CrossWackyBridges.INCH_TO_BRIDGE, 
														AutonomousConfig.CrossWackyBridges.SPEED));
    }
}
