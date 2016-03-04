package org.usfirst.frc.team869.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

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
	 * DO NOT MODIFY
	 */
	//Joystick X3D Button Addresses
	//TODO - Map the Joystick Buttons
	
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
	public static final int SHOOTER_MOTOR  = 5;
	public static final int INTAKE_MOTOR   = 6;
	public static final int CONVEYOR_MOTOR = 7;
	
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
	
	
	/**
	 * Analog Input Addresses
	 */	
	public static final int GYRO_INPUT = 0;
	
	
	/**
	 * Digital I/O Addresses
	 */
	public static final int BALL_TRANSFER_LIMIT = 0;
	
	/**
	 * Remapping buttons with clear descriptions
	 */

	//Operator Buttons
	public static final int INTAKE_OUT_BUTTON = CONTROLLER_Y_BUTTON;
	public static final int INTAKE_IN_BUTTON  = CONTROLLER_A_BUTTON;
	public static final int SHOOT_BUTTON      = CONTROLLER_R_TRIGGER;
	public static final int CLIMB_BUTTON_1    = CONTROLLER_LB_BUTTON;
	public static final int CLIMB_BUTTON_2    = CONTROLLER_RB_BUTTON;
	
	 //Driver buttons
	public static final int DRIVE_LOW_BUTTON        = CONTROLLER_LB_BUTTON;
	public static final int DRIVE_HIGH_BUTTON       = CONTROLLER_RB_BUTTON;
	public static final int DRIVE_HALF_SPEED_BUTTON = CONTROLLER_R_TRIGGER;
	
	/**
	 * Constants
	 */
	public static final double SHOOTER_SPEED = 1;
	public static final double INTAKE_SPEED  = .5;

	//Threshold before using joystick as input
	public static final double JOYSTICK_THRESHOLD = .75;
	
	/**
	 * Value Maps
	 */
	public static final boolean LOW_SPEED  = false;
	public static final boolean HIGH_SPEED = true;
}
