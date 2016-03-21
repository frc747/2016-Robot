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

    public static final int DRIVER_LEFT_CONTROLLER_ID  = 1,
                            DRIVER_RIGHT_CONTROLLER_ID = 2,
                            OPERATOR_CONTROLLER_ID     = 3;

    /**
     * Gampad Controller Mapping
     * 
     * DO NOT MODIFY
     */
    //"Controller Gampad (F310)" Button Addresses
    public static final int CONTROLLER_A_BUTTON       = 1,
                            CONTROLLER_B_BUTTON       = 2,
                            CONTROLLER_X_BUTTON       = 3,
                            CONTROLLER_Y_BUTTON       = 4,
                            CONTROLLER_LB_BUTTON      = 5,
                            CONTROLLER_RB_BUTTON      = 6,
                            CONTROLLER_BACK_BUTTON    = 7,
                            CONTROLLER_START_BUTTON   = 8,
                            CONTROLLER_L_STICK_BUTTON = 9,
                            CONTROLLER_R_STICK_BUTTON = 10;

    //"Controller Gampad (F310)" Axis Addresses
    public static final int CONTROLLER_L_X_AXIS  = 0,
                            CONTROLLER_L_Y_AXIS  = 1,
                            CONTROLLER_L_TRIGGER = 2,
                            CONTROLLER_R_TRIGGER = 3,
                            CONTROLLER_R_X_AXIS  = 4,
                            CONTROLLER_R_Y_AXIS  = 5;
    
    /**
     * Joystick Mapping
     * 
     * All of the Joystick buttons are numbered. Those numbers map directly to library maps.
     * 
     * DO NOT MODIFY
     */
    
    //Joystick X3D Axis Addresses
    public static final int JOYSTICK_X_AXIS        = 0,
                            JOYSTICK_Y_AXIS        = 1,
                            JOYSTICK_Z_AXIS        = 2,
                            JOYSTICK_THROTTLE_AXIS = 3;
    
    /**
     * CANBUS Addresses
     */
    //DriveTrain values
    public static final int LEFT_FRONT_DRIVE_MOTOR  = 1,
                            LEFT_REAR_DRIVE_MOTOR   = 2,
                            RIGHT_FRONT_DRIVE_MOTOR = 3,
                            RIGHT_REAR_DRIVE_MOTOR  = 4;
    //Operator Values
    public static final int SHOOTER_MOTOR     = 5,
                            INTAKE_MOTOR      = 6,
                            CONVEYOR_MOTOR    = 7,
                            LIFT_ASSIST_MOTOR = 8;
    
    /**
     * Solenoid Addresses
     */    
    //Driver Values
    public static final int DRIVE_HIGH_SPEED = 0,
                            DRIVE_LOW_SPEED  = 1;
    //Operator Values
    public static final int CLIMB_RETRACT = 2,
                            CLIMB_EXTEND  = 3,
                            INTAKE_STOW   = 4,
                            INTAKE_DEPLOY = 5,
                            CLIMB_LOCK    = 6;
    
    
    
    /**
     * Analog Input Addresses
     */    
    public static final int GYRO_INPUT = 0;
    
    
    /**
     * Digital I/O Addresses
     */
    public static final int BALL_TRANSFER_LIMIT = 0;
    //Encoder locations
    public static final int DRIVE_ENCODER_LEFT_CHANNEL_A  = 1,
                            DRIVE_ENCODER_LEFT_CHANNEL_B  = 2,
                            DRIVE_ENCODER_RIGHT_CHANNEL_A = 3,
                            DRIVE_ENCODER_RIGHT_CHANNEL_B = 4;
    
    
    /**
     * Remapping buttons with clear descriptions
     */

    //Operator Buttons
    public static final int INTAKE_OUT_BUTTON = CONTROLLER_Y_BUTTON,
                            INTAKE_IN_BUTTON  = CONTROLLER_A_BUTTON,
                            CLIMB_BUTTON_1    = CONTROLLER_LB_BUTTON,
                            CLIMB_BUTTON_2    = CONTROLLER_RB_BUTTON,
                            ASSIST_EXTEND     = CONTROLLER_X_BUTTON,
                            ASSIST_RETRACT    = CONTROLLER_B_BUTTON;
    
     //Driver buttons
    public static final int DRIVE_LOW_BUTTON        = 7,
                            DRIVE_HIGH_BUTTON       = 9,
                            DRIVE_HALF_SPEED_BUTTON = 11;
    
    /**
     * Constants
     */
    public static final double SHOOTER_SPEED     = 1,
                               INTAKE_SPEED      = 1,
                               LIFT_ASSIST_SPEED = 1;
    
    //Threshold before using joystick as input
    public static final double JOYSTICK_THRESHOLD = .75,
                               TRIGGER_THRESHOLD  = .4;
    
    /**
     * Subsystem Timeouts
     */
    public static final double INTAKE_ARTICULATE_BUMP_UP_TIMEOUT = 0.1,
                               SHOOTER_SPIN_UP_TIMEOUT           = 1.2,
                               INTAKE_BREAK_TIMEOUT              = 0.2;
}