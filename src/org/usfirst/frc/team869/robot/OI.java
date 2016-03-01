package org.usfirst.frc.team869.robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team869.robot.commands.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
	
    private static final Joystick driverController = new Joystick(RobotMap.driverControllerID);
    private static final Joystick operatorController = new Joystick(RobotMap.operatorControllerID);
	
	public OI(){
				
		/*
		 * Driver Controller Buttons
		 */
		 getButton(RobotMap.driverControllerID, RobotMap.driveSpeedButton).whileHeld(new ShiftDriveCommand("HighSpeed"));
		 getButton(RobotMap.driverControllerID, RobotMap.driveTorqueButton).whileHeld(new ShiftDriveCommand("LowSpeed"));
		 
		 
		 /*
		  * Operator controller buttons
		  */
		 getButton(RobotMap.operatorControllerID, RobotMap.shootButton).whileHeld(new ShootBlindCommand());
		 getButton(RobotMap.operatorControllerID, RobotMap.intakeButtonIn).whileHeld(new PickUpBallCommand());
		 getButton(RobotMap.operatorControllerID, RobotMap.intakeButtonOut).whileHeld(new DropBallCommand());
		 //Retract climber if either button is released
		// getButton(RobotMap.operatorControllerID, RobotMap.climbButton1).whenReleased(new climbRetractCommand());
		// getButton(RobotMap.operatorControllerID, RobotMap.climbButton2).whenReleased(new climbRetractCommand());
		 //Extend Climber
		 if (getButton(RobotMap.operatorControllerID, RobotMap.climbButton1).get()){
			 getButton(RobotMap.operatorControllerID, RobotMap.climbButton2).whileHeld(new ClimbExtendCommand());
			 
		 }
		 
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
		return operatorController.getRawAxis(RobotMap.logitechControllerLYAxis);
	}

	public static double getLeftDriveSpeed(){
		return driverController.getRawAxis(RobotMap.logitechControllerLYAxis);
	}

	public static double getRightDriveSpeed(){
		return driverController.getRawAxis(RobotMap.logitechControllerRYAxis);
	}
	
    public JoystickButton getButton(int joyid, int button) {
        switch(joyid) {
            case RobotMap.operatorControllerID:
                return new JoystickButton(operatorController , button);
            case RobotMap.driverControllerID:
                return new JoystickButton(driverController , button);
            default:
                return null;
        }
    }
    
    public boolean getButtonState(int joyid, int button) {
        return getButton(joyid, button).get();
    }
	
}

