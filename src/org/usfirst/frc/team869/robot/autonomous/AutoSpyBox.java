package org.usfirst.frc.team869.robot.autonomous;

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
        
        int rotateDegrees = -10, 
        //TODO find out actual distance
            distance1 = 100,
        //TODO find out actual distance
            distance2 = 100;

        //TODO find out actual speed
        double speed = .5,
               shooterStop = 10,
               intakeStart = 1.5,
               intakeStop = 10;
        
        addSequential(new DriveDistanceCommand(distance1, speed));
        addSequential(new DriveRotateCommand(speed, rotateDegrees));
        addSequential(new DriveDistanceCommand(distance2, speed));
        addParallel(new ShooterShootCommand(shooterStop)); 
        addSequential(new IntakeBallInCommand(intakeStop, intakeStart));
        
    }
}
