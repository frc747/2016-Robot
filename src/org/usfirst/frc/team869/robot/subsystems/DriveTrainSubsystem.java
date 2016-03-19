package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.DriveWithJoysticksCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import com.kauailabs.navx.frc.*;

public class DriveTrainSubsystem extends Subsystem {
 
    //Create the talons for the drive Train.
    private CANTalon talonFrontLeft  = new CANTalon (RobotMap.LEFT_FRONT_DRIVE_MOTOR);
    private CANTalon talonRearLeft   = new CANTalon (RobotMap.LEFT_REAR_DRIVE_MOTOR);
    private CANTalon talonFrontRight = new CANTalon (RobotMap.RIGHT_FRONT_DRIVE_MOTOR);
    private CANTalon talonRearRight  = new CANTalon (RobotMap.RIGHT_REAR_DRIVE_MOTOR);
    
    private AnalogInput gyroInput = new AnalogInput (RobotMap.GYRO_INPUT);
    private AnalogGyro  driveGyro = new AnalogGyro (gyroInput);
    
    private AHRS navX = new AHRS(SPI.Port.kMXP);
    
    
    
    
    
    private Encoder driveLeftEncoder = new Encoder (RobotMap.DRIVE_ENCODER_LEFT_CHANNEL_A, 
    													RobotMap.DRIVE_ENCODER_LEFT_CHANNEL_B, false);
    private Encoder driveRightEncoder = new Encoder (RobotMap.DRIVE_ENCODER_RIGHT_CHANNEL_A, 
    													RobotMap.DRIVE_ENCODER_RIGHT_CHANNEL_B, false);
    
    
    
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
    }
    
    public void stop() {
        talonFrontLeft.set(0);
        talonFrontRight.set(0);
        talonRearLeft.set(0);
        talonRearRight.set(0);
    }
    
    public void resetGyro (){
        driveGyro.reset();
    }
    
    public void getGyroAngle (){
        driveGyro.getAngle();
    }
    
    
    public double convertEncoderTicksToInches(double inchesToTravel){
    	
    	//static hardware values (Encoder is grayhill 63R128, r128 is 128 pulsePerRevolution)
    	final double 	stg1Gear1 = 22, 
    					stg1Gear2 = 12,
    					stg2Gear1 = 60, 
    					stg2Gear2 = 24, 
    					stg3Gear1 = 36, 
    					stg3Gear2 = 12, 
    					wheelDiameter = 7.75, 
    					ticksPerEncoder = 128;
    	
    	//Calculate wheel circumference to see how far one revolution of the wheel goes
    	final double 	wheelCircumference = (Math.PI*wheelDiameter);
    	
    	//Calculate gear ratios per stage
    	final double 	stage1Ratio = (stg1Gear1 / stg1Gear2),
    					stage2Ratio = (stg2Gear1 / stg2Gear2),
    					stage3Ratio = (stg3Gear1 / stg3Gear2);
    	
    	//Calculate final gear ratio to the encoder
    	final double 	encoderRevolutionsPerWheelRevolution = (stage1Ratio * stage2Ratio * stage3Ratio);
    	
    	//Calculate how many ticks per inch
    	final double 	ticksPerInch = ((encoderRevolutionsPerWheelRevolution * ticksPerEncoder) / wheelCircumference);
    	
    	final double 	encoderTicks = inchesToTravel / ticksPerInch;
    	
    	return encoderTicks;
    }
    
    public double getNavXCurrentAngle(){
    	return this.navX.getAngle();
    }
    public void resetNavXYaw(){
    	this.navX.zeroYaw();
    }
    public boolean isRobotMoving(){
    	return this.navX.isMoving();
    }
    public boolean isRobotRotating(){
    	return this.navX.isRotating();
    }
    public double getNavXAngle(){
    	return this.navX.getYaw();
    }
    public double getNavXRoll(){
    	return this.navX.getRoll();
    }
    
    public double getLeftEncoderDistance()	{
    	return this.driveLeftEncoder.getDistance();
    }
    
    public void resetLeftEncoder(){
    	this.driveLeftEncoder.reset();
    }
    
    public double getRightEncoderDistance(){
    	return this.driveRightEncoder.getDistance();
    }
    
    public void resetRightEncoder(){
    	this.driveRightEncoder.reset();
    }
    
    public void getGoalLocation (){
        NetworkTable.getTable("GRIP/StrongholdContours");
    }    
}