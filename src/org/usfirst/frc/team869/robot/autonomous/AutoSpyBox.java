package org.usfirst.frc.team869.robot.autonomous;

import org.usfirst.frc.team869.robot.AutonomousConfig;
import org.usfirst.frc.team869.robot.Robot;
import org.usfirst.frc.team869.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team869.robot.commands.DriveRotateCommand;
import org.usfirst.frc.team869.robot.commands.IntakeBallInCommand;
import org.usfirst.frc.team869.robot.commands.ShooterShootCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSpyBox extends CommandGroup {
    
    public  AutoSpyBox() {
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
        
        addSequential(new DriveDistanceCommand(AutonomousConfig.SpyBox.FIRST_DISTANCE, AutonomousConfig.SpyBox.DRIVE_SPEED));
        addSequential(new DriveRotateCommand(AutonomousConfig.SpyBox.DRIVE_SPEED, AutonomousConfig.SpyBox.ROTATION));
        addSequential(new DriveDistanceCommand(AutonomousConfig.SpyBox.SECOND_DISTANCE, AutonomousConfig.SpyBox.DRIVE_SPEED));
        addParallel(new ShooterShootCommand(AutonomousConfig.SpyBox.SHOOTER_STOP)); 
        addSequential(new IntakeBallInCommand(AutonomousConfig.SpyBox.INTAKE_STOP, AutonomousConfig.SpyBox.INTAKE_START));
    }
}
