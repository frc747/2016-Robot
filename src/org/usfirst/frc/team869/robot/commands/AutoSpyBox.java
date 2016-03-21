package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSpyBox extends CommandGroup {
	
	private int distance1, distance2, rotateDegrees;
	private double speed, intakeStart, intakeStop, shooterStop;
    
    public  AutoSpyBox() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.DRIVE_TRAIN);
    	requires(Robot.SHOOTER_SYSTEM);
    	requires(Robot.INTAKE_SYSTEM);
    	
    	/*
    	 * Step1: Drive forward 50% XX inches
    	 * Step2: Rotate left XX degrees
    	 * Step3: Drive forward 50% XX inches
    	 * Step4: Rev shooter
    	 * Step5: intake in
    	 */
    	speed = .5; //TODO find out actual speed
    	distance1 = 100; //TODO find out actual distance
    	distance2 = 100; //TODO find out actual distacne
    	rotateDegrees = -10;
    	shooterStop = 10;
    	intakeStart = 1.5;
    	intakeStop = 10;
    	
    	addSequential(new DriveDistanceCommand(distance1, speed));
    	addSequential(new DriveRotateCommand(speed, rotateDegrees));
    	addSequential(new DriveDistanceCommand(distance2, speed));
    	addParallel(new ShooterShootCommand(shooterStop)); 
    	addSequential(new IntakeBallInCommand(intakeStop, intakeStart));
    	
    }
}
