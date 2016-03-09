package org.usfirst.frc.team869.robot.controls;

import org.usfirst.frc.team869.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;

public class IntakeDownButton extends Button{

    @Override
    public boolean get() {
        return OI.getIntakeDownButton();
    }
}
