package org.usfirst.frc.team869.robot;

import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team869.robot.commands.*;
import org.usfirst.frc.team869.robot.controls.ClimbButton;
import org.usfirst.frc.team869.robot.controls.IntakeDownButton;
import org.usfirst.frc.team869.robot.controls.IntakeUpButton;
import org.usfirst.frc.team869.robot.controls.ShootButton;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private static final Joystick DRIVER_LEFT_CONTROLLER   = new Joystick(RobotMap.DRIVER_LEFT_CONTROLLER_ID),
                                  DRIVER_RIGHT_CONTROLLER  = new Joystick(RobotMap.DRIVER_RIGHT_CONTROLLER_ID),
                                  OPERATOR_CONTROLLER      = new Joystick(RobotMap.OPERATOR_CONTROLLER_ID);
    
    public OI(){
                
        /*
         * Driver Controller Buttons
         */
         getButton(RobotMap.DRIVER_LEFT_CONTROLLER_ID, RobotMap.DRIVE_HIGH_BUTTON).whileHeld(new DriveHighSpeedCommand());
         getButton(RobotMap.DRIVER_LEFT_CONTROLLER_ID, RobotMap.DRIVE_LOW_BUTTON).whileHeld(new DriveLowSpeedCommand());
         getButton(RobotMap.DRIVER_LEFT_CONTROLLER_ID, RobotMap.CAMERA_TOGGLE_BUTTON).whenReleased(new VisionToggleCommand());
         getButton(RobotMap.DRIVER_RIGHT_CONTROLLER_ID, RobotMap.CAMERA_TOGGLE_BUTTON).whenReleased(new VisionToggleCommand());
         
         /*
          * Operator controller buttons
          */
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.INTAKE_IN_BUTTON).whileHeld(new IntakeBallInCommand(0,0));
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.INTAKE_OUT_BUTTON).whileHeld(new IntakeBallOutCommand());
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.ASSIST_EXTEND).whileHeld(new ClimbAssistExtendCommand());
         getButton(RobotMap.OPERATOR_CONTROLLER_ID, RobotMap.ASSIST_RETRACT).whileHeld(new ClimbAssistRetractCommand());
         
         //Retract climber if either button is released
         //Extend Climber when both are pressed
         ClimbButton climbButton = new ClimbButton();
         climbButton.whileHeld(new ClimbExtendCommand());
         
         //Spin the shooter as long as the button is held
         ShootButton shootButton = new ShootButton();
         shootButton.whileHeld(new ShooterShootCommand());
         
         //Push the intake down
         IntakeDownButton intakeDownButton = new IntakeDownButton();
         intakeDownButton.whileHeld(new IntakeArticulateDownCommand());
         
         //Push the intake up
         IntakeUpButton intakeUpButton = new IntakeUpButton();
         intakeUpButton.whileHeld(new IntakeArticulateUpCommand());
    }

    public static double getLeftDriveSpeed(){
        return DRIVER_LEFT_CONTROLLER.getRawAxis(RobotMap.Joystick.Y_AXIS);
    }

    public static double getRightDriveSpeed(){
        return DRIVER_RIGHT_CONTROLLER.getRawAxis(RobotMap.Joystick.Y_AXIS);
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
    
    public static boolean getIntakeUpButton(){
        return OPERATOR_CONTROLLER.getRawAxis(RobotMap.Gamepad.L_Y_AXIS)
                >= RobotMap.Threshold.GAMEPAD_JOYSTICK;
    }
    
    public static boolean getIntakeDownButton(){
        return OPERATOR_CONTROLLER.getRawAxis(RobotMap.Gamepad.L_Y_AXIS)
                < -RobotMap.Threshold.GAMEPAD_JOYSTICK;
    }
    
    public static boolean getShootButton(){
        return OPERATOR_CONTROLLER.getRawAxis(RobotMap.Gamepad.R_TRIGGER) 
                >= RobotMap.Threshold.TRIGGER;
    }
    
    public static boolean getAutonomousSelectorButton(){
        return DRIVER_RIGHT_CONTROLLER.getRawAxis(RobotMap.Joystick.THROTTLE_AXIS) > RobotMap.Threshold.AUTONOMOUS_THROTTLE;
    }
}