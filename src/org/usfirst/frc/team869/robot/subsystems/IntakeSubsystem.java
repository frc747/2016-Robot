package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.IntakeStopCommand;

public class IntakeSubsystem extends Subsystem {
    /*
     * at 11.9V the motor runs at 4450
     */
    
    private DigitalInput transferLimit = new DigitalInput (RobotMap.BALL_TRANSFER_LIMIT);
    private CANTalon     talonIntake   = new CANTalon (RobotMap.INTAKE_MOTOR);
    private CANTalon     talonConveyor = new CANTalon (RobotMap.CONVEYOR_MOTOR);

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeStopCommand());
    }

    public void setIntakeSpeed (double intakeSpeed, boolean isShooterReady){
        
        talonIntake.set((intakeSpeed));
        
        if(transferLimit.get() || isShooterReady){
            talonConveyor.set(-(intakeSpeed));
        } else {
            talonConveyor.set(0);
        }
    }
}