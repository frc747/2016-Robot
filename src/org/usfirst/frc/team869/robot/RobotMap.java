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
     * "Controller Gampad (F310)" Controller Mapping
     * 
     * DO NOT MODIFY
     */
    public final class Gamepad{
        private Gamepad(){
        }
        
        //Button Addresses
        public static final int A_BUTTON       = 1,
                                B_BUTTON       = 2,
                                X_BUTTON       = 3,
                                Y_BUTTON       = 4,
                                LB_BUTTON      = 5,
                                RB_BUTTON      = 6,
                                BACK_BUTTON    = 7,
                                START_BUTTON   = 8,
                                L_STICK_BUTTON = 9,
                                R_STICK_BUTTON = 10;

        // Axis Addresses
        public static final int L_X_AXIS  = 0,
                                L_Y_AXIS  = 1,
                                L_TRIGGER = 2,
                                R_TRIGGER = 3,
                                R_X_AXIS  = 4,
                                R_Y_AXIS  = 5;
    }
    
    
    /**
     * Joystick Mapping
     * 
     * All of the Joystick buttons are numbered. Those numbers map directly to library maps.
     * 
     * DO NOT MODIFY
     */
    public final class Joystick{
        private Joystick(){
        }
        
        public static final int X_AXIS        = 0,
                                Y_AXIS        = 1,
                                Z_AXIS        = 2,
                                THROTTLE_AXIS = 3;
    }
    
    
    /**
     * CANBUS Addresses
     */
    public final class Canbus{
        private Canbus(){
        }
        
        /**
         * Drivetrain Addresses 
         */
        public final class Drive{
            private Drive(){
            }
            public static final int LEFT_FRONT  = 1,
                                    LEFT_REAR   = 2,
                                    RIGHT_FRONT = 3,
                                    RIGHT_REAR  = 4;
        }
        
        //Operator Values
        public static final int SHOOTER_MOTOR     = 5,
                                INTAKE_MOTOR      = 6,
                                CONVEYOR_MOTOR    = 7,
                                LIFT_ASSIST_MOTOR = 8;
    }
    
    /**
     * Solenoid Addresses
     */  
    public final class Solenoid{
        private Solenoid(){
        }
        
        //Driver Values
        public static final int DRIVE_HIGH_SPEED = 0,
                                DRIVE_LOW_SPEED  = 1;
        //Operator Values
        public static final int CLIMB_RETRACT = 2,
                                CLIMB_EXTEND  = 3,
                                INTAKE_STOW   = 4,
                                INTAKE_DEPLOY = 5,
                                FLOPPER_RELAXER = 7;
    }
   
    /**
     * Analog Input Addresses
     */   
    public final class AnalogInput{
        
        private AnalogInput(){
        }
        
        public static final int GYRO_INPUT = 0;
    }

    /**
     * Digital I/O Addresses
     */
    public final class DigitalIO{
        private DigitalIO(){
        }

        public static final int BALL_TRANSFER_LIMIT = 0;

        /**
         * Encoder locations
         */
        public final class Encoder{
            private Encoder(){
            }
            public static final int DRIVE_LEFT_CHANNEL_A  = 1,
                                    DRIVE_LEFT_CHANNEL_B  = 2,
                                    DRIVE_RIGHT_CHANNEL_A = 3,
                                    DRIVE_RIGHT_CHANNEL_B = 4;
        }
    }
    
    
    /**
     * Remapping buttons with clear descriptions
     */
    //Operator Buttons
    public static final int INTAKE_OUT_BUTTON = Gamepad.Y_BUTTON,
                            INTAKE_IN_BUTTON  = Gamepad.A_BUTTON,
                            CLIMB_BUTTON_1    = Gamepad.LB_BUTTON,
                            CLIMB_BUTTON_2    = Gamepad.RB_BUTTON,
                            ASSIST_EXTEND     = Gamepad.X_BUTTON,
                            ASSIST_RETRACT    = Gamepad.B_BUTTON,
                            DRIVE_BUMP    		= Gamepad.L_TRIGGER;
    
     //Driver buttons
    public static final int DRIVE_LOW_BUTTON        		= 7,
                            CAMERA_TOGGLE_BUTTON    		= 8, 
                            CAMERA_TOGGLE_ON_OFF_BUTTON 	= 1,
                            DRIVE_HIGH_BUTTON       		= 9,
                            DRIVE_HALF_SPEED_BUTTON 		= 11,
                            TEMPORARY_RESET_GYRO    		= 12;
    /**
     * Speed Constants
     */
    public final class Speed{
        private Speed(){
        }
        
        public static final double SHOOTER     = 1,
                                   INTAKE      = 1,
                                   LIFT_ASSIST = 1,
        						   BUMP_SPEED    = -0.5;

    }
    
    /**
     * Threshold before using joystick as input 
     */
    public final class Threshold{
        private Threshold(){
        }

        public static final double GAMEPAD_JOYSTICK    = .75,
                                   AUTONOMOUS_THROTTLE = 0.5,
                                   TRIGGER             = 0.6;
    }
    
    /**
     * Subsystem Timeouts
     */
    public final class Timeout{
        private Timeout(){
        }
        public static final double INTAKE_ARTICULATE_BUMP_UP = 0.1,
                                   SHOOTER_SPIN_UP           = 1.2,
                                   INTAKE_BREAK              = 0.2,
                                   DRIVE_BUMP_TIMEOUT        = 0.2;

    }
}