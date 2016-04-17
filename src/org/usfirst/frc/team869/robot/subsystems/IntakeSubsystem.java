package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.OI;
import org.usfirst.frc.team869.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.IntakeStopCommand;

public class IntakeSubsystem extends Subsystem {
    /*
     * at 11.9V the motor runs at 4450
     */
    
    private CANTalon talonIntake   = new CANTalon (RobotMap.Canbus.INTAKE_MOTOR),
                     talonConveyor = new CANTalon (RobotMap.Canbus.CONVEYOR_MOTOR);

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeStopCommand());
    }

    public void setIntakeSpeed (double intakeSpeed){
    	
    	if(!OI.getShootButton()){
        talonIntake.set((intakeSpeed));
        } else {
        	talonIntake.set(0);
        }
    	
        talonConveyor.set(-(intakeSpeed));        
    }
}