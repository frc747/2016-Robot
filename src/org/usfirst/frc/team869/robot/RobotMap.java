package org.usfirst.frc.team869.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
    
    private RobotMap() {
        //Hidden constructor to ensure that class is never created
     }

    public static final int DRIVER_LEFT_CONTROLLER_ID  = 1;
    public static final int DRIVER_RIGHT_CONTROLLER_ID = 2;
    public static final int OPERATOR_CONTROLLER_ID     = 3;

    /**
     * Gampad Controller Mapping
     * 
     * DO NOT MODIFY
     */
    //"Controller Gampad (F310)" Button Addresses
    public static final int CONTROLLER_A_BUTTON       = 1;
    public static final int CONTROLLER_B_BUTTON       = 2;
    public static final int CONTROLLER_X_BUTTON       = 3;
    public static final int CONTROLLER_Y_BUTTON       = 4;
    public static final int CONTROLLER_LB_BUTTON      = 5;
    public static final int CONTROLLER_RB_BUTTON      = 6;
    public static final int CONTROLLER_BACK_BUTTON    = 7;
    public static final int CONTROLLER_START_BUTTON   = 8;
    public static final int CONTROLLER_L_STICK_BUTTON = 9;
    public static final int CONTROLLER_R_STICK_BUTTON = 10;

    //"Controller Gampad (F310)" Axis Addresses
    public static final int CONTROLLER_L_X_AXIS  = 0;
    public static final int CONTROLLER_L_Y_AXIS  = 1;
    public static final int CONTROLLER_L_TRIGGER = 2;
    public static final int CONTROLLER_R_TRIGGER = 3;
    public static final int CONTROLLER_R_X_AXIS  = 4;
    public static final int CONTROLLER_R_Y_AXIS  = 5;
    
    /**
     * Joystick Mapping
     * 
     * All of the Joystick buttons are numbered. Those numbers map directly to library maps.
     * 
     * DO NOT MODIFY
     */
    
    //Joystick X3D Axis Addresses
    public static final int JOYSTICK_X_AXIS        = 0;
    public static final int JOYSTICK_Y_AXIS        = 1;
    public static final int JOYSTICK_Z_AXIS        = 2;
    public static final int JOYSTICK_THROTTLE_AXIS = 3;
    
    /**
     * CANBUS Addresses
     */
    //DriveTrain values
    public static final int LEFT_FRONT_DRIVE_MOTOR  = 1;
    public static final int LEFT_REAR_DRIVE_MOTOR   = 2;
    public static final int RIGHT_FRONT_DRIVE_MOTOR = 3;
    public static final int RIGHT_REAR_DRIVE_MOTOR  = 4;
    //Operator Values
    public static final int SHOOTER_MOTOR     = 5;
    public static final int INTAKE_MOTOR      = 6;
    public static final int CONVEYOR_MOTOR    = 7;
    public static final int LIFT_ASSIST_MOTOR = 8;
    
    /**
     * Solenoid Addresses
     */    
    //Driver Values
    public static final int DRIVE_HIGH_SPEED = 0;
    public static final int DRIVE_LOW_SPEED  = 1;
    //Operator Values
    public static final int CLIMB_RETRACT = 2;
    public static final int CLIMB_EXTEND  = 3;
    public static final int INTAKE_STOW   = 4;
    public static final int INTAKE_DEPLOY = 5;
    public static final int CLIMB_LOCK	  = 6;
    
    
    
    /**
     * Analog Input Addresses
     */    
    public static final int GYRO_INPUT = 0;
    
    
    /**
     * Digital I/O Addresses
     */
    public static final int BALL_TRANSFER_LIMIT = 0;
    //Encoder locations
    public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 1;
    public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 2;
    public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 3;
    public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 4;
    
    
    
    
    /**
     * Remapping buttons with clear descriptions
     */

    //Operator Buttons
    public static final int INTAKE_OUT_BUTTON = CONTROLLER_Y_BUTTON;
    public static final int INTAKE_IN_BUTTON  = CONTROLLER_A_BUTTON;
    public static final int CLIMB_BUTTON_1    = CONTROLLER_LB_BUTTON;
    public static final int CLIMB_BUTTON_2    = CONTROLLER_RB_BUTTON;
    public static final int ASSIST_EXTEND     = CONTROLLER_X_BUTTON;
    public static final int ASSIST_RETRACT    = CONTROLLER_B_BUTTON;
    
     //Driver buttons
    public static final int DRIVE_LOW_BUTTON        = 7;
    public static final int DRIVE_HIGH_BUTTON       = 9;
    public static final int DRIVE_HALF_SPEED_BUTTON = 11;
    
    /**
     * Constants
     */
    public static final double SHOOTER_SPEED     = -1;
    public static final double INTAKE_SPEED      = 1;
    public static final double BUMP_SPEED        = -0.5;
    public static final double LIFT_ASSIST_SPEED = 1;
    
    //Threshold before using joystick as input
    public static final double JOYSTICK_THRESHOLD = .75;
    public static final double TRIGGER_THRESHOLD  = .4;
    
    
    /**
     * Autonomous constants
     * 
     */
    //AutoSpyBox
    public static final double AUTO_SPY_BOX_FIRST_DISTANCE_INCHES = 0; //TODO figure out distance and set to something
    public static final double AUTO_SPY_BOX_SECOND_DISTANCE_INCHES = 0;
    public static final double AUTO_SPY_BOX_ROTATION_DEGREES = 0;
    public static final double AUTO_SPY_BOX_DRIVE_SPEED = .5;
    //AutoPosition2
    //AutoPosition3
    //AutoPosition4
    //AutoPosition5
    //AutoRockwall2
    //AutoRockwall3
    //AutoRockwall4
    //AutoRockwall5
    
    /**
     * Subsystem Timeouts
     */
    public static final double INTAKE_ARTICULATE_BUMP_UP_TIMEOUT = 0.1;
    public static final double SHOOTER_SPIN_UP_TIMEOUT           = 1.2;
    public static final double INTAKE_BREAK_TIMEOUT              = 0.2;
    public static final double DRIVE_BUMP_TIMEOUT                = 0.2;
    
}