package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.DriveWithJoysticksCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DriveTrainSubsystem extends Subsystem {
 
    //Create the talons for the drive Train.
    private CANTalon talonFrontLeft  = new CANTalon (RobotMap.LEFT_FRONT_DRIVE_MOTOR);
    private CANTalon talonRearLeft   = new CANTalon (RobotMap.LEFT_REAR_DRIVE_MOTOR);
    private CANTalon talonFrontRight = new CANTalon (RobotMap.RIGHT_FRONT_DRIVE_MOTOR);
    private CANTalon talonRearRight  = new CANTalon (RobotMap.RIGHT_REAR_DRIVE_MOTOR);
    
    private AnalogInput gyroInput = new AnalogInput (RobotMap.GYRO_INPUT);
    private AnalogGyro  driveGyro = new AnalogGyro (gyroInput);
    
   

    public DriveTrainSubsystem() {
        super();
        talonFrontRight.setInverted(true);
        talonRearRight.setInverted(true);
    }

    public void initDefaultCommand() {
        
        //Set driveWithJoysticks as default command.
        //This will make sure when the subsystem is idle (no other commands scheduled) 
        //            it will continue to ALWAYS be scheduled with the joystick input.
        setDefaultCommand(new DriveWithJoysticksCommand());
    }
    
    public void setTankDrive (double rightSpeed, double leftSpeed){
        talonFrontLeft.set((leftSpeed));
        talonRearLeft.set((leftSpeed));
        talonFrontRight.set(rightSpeed);
        talonRearRight.set(rightSpeed);
        
        //TODO - Remove for Production
        System.out.print("running drive train right@:" + rightSpeed + " left @:" + leftSpeed + " \r");
    }
    
    public void stop(){
        talonFrontLeft.disable();
        talonFrontRight.disable();
        talonRearLeft.disable();
        talonRearRight.disable();
    }
    
    public void resetGyro (){
        driveGyro.reset();
    }
    
    public void getGyroAngle (){
        driveGyro.getAngle();
        
        //TODO - Remove for Production
        System.out.print(driveGyro.getAngle());    
    }
    
    public void getGoalLocation (){
        NetworkTable.getTable("GRIP/StrongholdContours");
    }    
}