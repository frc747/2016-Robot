package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team869.robot.commands.StopIntakeCommand;

public class IntakeSubsystem extends Subsystem {
    /*
     * at 11.9V the motor runs at 4450
     */
    
    private DigitalInput transferOpticalGate = new DigitalInput (RobotMap.BALL_TRANSFER_LIMIT);
    private CANTalon     talonIntake         = new CANTalon (RobotMap.INTAKE_MOTOR);

    public void initDefaultCommand() {
        setDefaultCommand(new StopIntakeCommand());
    }

    public void setIntakeSpeed (double intakeSpeed){
        if (!transferOpticalGate.get()){
            talonIntake.set((intakeSpeed));
            
            //TODO - Remove for Production
            System.out.print("running intake @" + intakeSpeed + " speed optical gate not tripped\r");    
        }/*else if (!transferOpticalGate.get() && ){
            //TODO - Need to set a condition here where it will enable if the shooter is at speed
        }*/else {
            talonIntake.set((0));
            
            //TODO - Remove for Production
            System.out.print("running intake @ 0 speed\r");    
        }
    }
}