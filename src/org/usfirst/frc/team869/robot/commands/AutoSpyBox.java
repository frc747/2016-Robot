package org.usfirst.frc.team869.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSpyBox extends CommandGroup {
    
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
    	
    	
    	
    	/*
    	 * Step1: Drive forward 50% XX inches
    	 * Step2: Rotate left XX degrees
    	 * Step3: Drive forward 50% XX inches
    	 * Step4: Rev shooter
    	 * Step5: intake in
    	 */
    }
}
