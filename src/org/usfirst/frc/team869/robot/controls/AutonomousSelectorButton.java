package org.usfirst.frc.team869.robot.controls;

import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Button;

public class AutonomousSelectorButton extends Button{

	@Override
	public boolean get() {
		return OI.getAutonomousButton();
	}
}
