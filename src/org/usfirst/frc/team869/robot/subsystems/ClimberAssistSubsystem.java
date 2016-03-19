package org.usfirst.frc.team869.robot.subsystems;

import org.usfirst.frc.team869.robot.RobotMap;
import org.usfirst.frc.team869.robot.commands.ClimbAssistStopCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberAssistSubsystem extends Subsystem {
    
    private CANTalon assistMotor = new CANTalon(RobotMap.LIFT_ASSIST_MOTOR);
    
    public void climbExtend (){
        assistMotor.set(-RobotMap.LIFT_ASSIST_SPEED);
    }
    
    public void climbRetract (){
        assistMotor.set(RobotMap.LIFT_ASSIST_SPEED);
    }
    
    public void climbStop(){
        assistMotor.set(0);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ClimbAssistStopCommand());
    }
}
