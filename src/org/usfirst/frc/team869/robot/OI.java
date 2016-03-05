package org.usfirst.frc.team869.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team869.robot.commands.*;
import org.usfirst.frc.team869.robot.controls.ClimbButton;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private static final Joystick DRIVER_LEFT_CONTROLLER   = new Joystick(RobotMap.DRIVER_LEFT_CONTROLLER_ID);
    private static final Joystick DRIVER_RIGHT_CONTROLLER  = new Joystick(RobotMap.DRIVER_RIGHT_CONTROLLER_ID);
    private static final Joystick OPERATOR_CONTROLLER      = new Joystick(RobotMap.OPERATOR_CONTROLLER_ID);
    
    public OI(){
                
        /*
         * Driver Controller Buttons
         */
         getButton(RobotMap.DRIVER_LEFT_CONTROLLER_ID, RobotMap.DRIVE_HIGH_BUTTON).whileHeld(new DriveHighSpeedCommand());
         getButton(RobotMap.DRIVER_LEFT_CONTROLLER_ID, RobotMap.DRIVE_LOW_BUTTON).whileHeld(new DriveLowSpeedCommand());
         
         /*
          * Operator controller buttons
          */
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.SHOOT_BUTTON).whileHeld(new ShooterStartCommand());
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.INTAKE_IN_BUTTON).whileHeld(new IntakeBallInCommand());
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.INTAKE_OUT_BUTTON).whileHeld(new IntakeBallOutCommand());

         //Retract climber if either button is released
         //Extend Climber when both are pressed
         ClimbButton climbButton = new ClimbButton();
         climbButton.whileHeld(new ClimbExtendCommand());
         
        /* getButton(RobotMap.operatorControllerID, RobotMap.shootBlindButton).whenReleased(new stopShoot());
         getButton(RobotMap.operatorControllerID, RobotMap.intakeButton).whenReleased(new stopIntake());*/

 //getButton(RobotMap.operatorJoystick, 2)
   //      .whileHeld(new AdvanceConveyer());
 
 
    }
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    public static double getOperatorLeftJoy(){
        return OPERATOR_CONTROLLER.getRawAxis(RobotMap.CONTROLLER_L_Y_AXIS);
    }

    public static double getLeftDriveSpeed(){
        return DRIVER_LEFT_CONTROLLER.getRawAxis(RobotMap.JOYSTICK_Y_AXIS);
    }

    public static double getRightDriveSpeed(){
        return DRIVER_RIGHT_CONTROLLER.getRawAxis(RobotMap.JOYSTICK_Y_AXIS);
    }
    
    public JoystickButton getButton(int joyid, int button) {
        switch(joyid) {
            case RobotMap.OPERATOR_CONTROLLER_ID:
                return new JoystickButton(OPERATOR_CONTROLLER, button);
            case RobotMap.DRIVER_LEFT_CONTROLLER_ID:
                return new JoystickButton(DRIVER_LEFT_CONTROLLER, button);
            default:
                return null;
        }
    }
    
    public boolean getButtonState(int joyid, int button) {
        return getButton(joyid, button).get();
    }
    
    public static boolean getClimbState(){
        return OPERATOR_CONTROLLER.getRawButton(RobotMap.CLIMB_BUTTON_1) && 
                OPERATOR_CONTROLLER.getRawButton(RobotMap.CLIMB_BUTTON_2);
    }
}