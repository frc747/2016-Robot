package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.DriveWithJoysticksCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import com.kauailabs.navx.frc.*;

public class DriveTrainSubsystem extends Subsystem {
 
    //Create the talons for the drive Train.
    private CANTalon talonFrontLeft  = new CANTalon (RobotMap.Canbus.Drive.LEFT_FRONT),
                     talonRearLeft   = new CANTalon (RobotMap.Canbus.Drive.LEFT_REAR),
                     talonFrontRight = new CANTalon (RobotMap.Canbus.Drive.RIGHT_FRONT),
                     talonRearRight  = new CANTalon (RobotMap.Canbus.Drive.RIGHT_REAR);

    private AHRS navX = new AHRS(SPI.Port.kMXP);
    
    private Encoder driveLeftEncoder = new Encoder (RobotMap.DigitalIO.Encoder.DRIVE_LEFT_CHANNEL_A, 
                                                        RobotMap.DigitalIO.Encoder.DRIVE_LEFT_CHANNEL_B, false),
                    driveRightEncoder = new Encoder (RobotMap.DigitalIO.Encoder.DRIVE_RIGHT_CHANNEL_B, 
                                                        RobotMap.DigitalIO.Encoder.DRIVE_RIGHT_CHANNEL_A, false);
    
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
        
        System.out.println("left encoder = " + Integer.toString(this.driveLeftEncoder.get()) + 
                " right encoder get= " + Integer.toString(this.driveRightEncoder.get()) + " ***GYRO ANGLE: "
                + Double.toString(this.getNavX360Angle()));
    }
    
    public void stop() {
        talonFrontLeft.set(0);
        talonFrontRight.set(0);
        talonRearLeft.set(0);
        talonRearRight.set(0);
    }
    
    //TODO - Move this to a utility function or a separate subsystem
    public double convertEncoderTicksToInches(double inchesToTravel){
        
        //static hardware values (Encoder is grayhill 63R128, r128 is 128 pulsePerRevolution)
        final double stg1Gear1 = 22, 
                     stg1Gear2 = 12,
                     //Competition bot
//                     stg2Gear1 = 60, 
//                     stg2Gear2 = 24,
                     //practice bot
                     stg2Gear1 = 50, 
                     stg2Gear2 = 34,
                     //end of different ratio
                     stg3Gear1 = 36, 
                     stg3Gear2 = 12, 
                     wheelCircumference = 23.75, 
                     ticksPerEncoder = 128;
        
        //Calculate wheel circumference to see how far one revolution of the wheel goes
        //final double wheelCircumference = (Math.PI*wheelDiameter);
        
        //Calculate gear ratios per stage
        final double stage1Ratio = (stg1Gear1 / stg1Gear2),
                     stage2Ratio = (stg2Gear1 / stg2Gear2),
                     stage3Ratio = (stg3Gear1 / stg3Gear2);
        
        //Calculate final gear ratio to the encoder
        final double encoderRevolutionsPerWheelRevolution = (stage1Ratio * stage2Ratio * stage3Ratio);
        
        //Calculate how many ticks per inch
        final double ticksPerInch = ((encoderRevolutionsPerWheelRevolution * ticksPerEncoder) / wheelCircumference);
        
        final double encoderTicks = inchesToTravel / ticksPerInch;
        
        return encoderTicks;
    }
    
    public double getNavXTotalAngle(){
        return this.navX.getAngle();
    }
    
    public void resetNavXYaw(){
    	
        this.navX.zeroYaw();
    }
    
    public double getNavX360Angle(){
    	
    	double Angle360 = 0;
    	
    	if (this.navX.getYaw() < 0){
    		Angle360 = (180 + this.navX.getYaw()) + 180;
    		
    	} else {
    		Angle360 = this.navX.getYaw();
    	}
        return Angle360;
    }
    
    public boolean isRobotMoving(){
        return this.navX.isMoving();
    }
    
    public boolean isRobotRotating(){
        return this.navX.isRotating();
    }

    public double getNavXRoll(){
        return this.navX.getRoll();
    }
    
    public double getLeftEncoderDistance()    {
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