package org.usfirst.frc.team869.robot;


import edu.wpi.first.wpilibj.smartdashboard.*;

import org.usfirst.frc.team869.robot.autonomous.AutoCrossDefense;
import org.usfirst.frc.team869.robot.autonomous.AutoReachDefense;
import org.usfirst.frc.team869.robot.autonomous.AutoSpyBox;

public class Autonomous{
    
    public enum AutoMode{
        AUTOMODE_NONE,
        AUTOMODE_REACH_DEFENSE,
        AUTOMODE_CROSS_DEFENSE,
        AUTOMODE_SPY_BOX,
    }
    
    private SendableChooser autoChooser;
    
    public Autonomous(){
        autoChooser = new SendableChooser();
        autoChooser.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
        autoChooser.addObject("Spy Box", AutoMode.AUTOMODE_SPY_BOX);
        autoChooser.addObject("Reach Defense", AutoMode.AUTOMODE_REACH_DEFENSE);
        autoChooser.addObject("Cross Defense", AutoMode.AUTOMODE_CROSS_DEFENSE);
        SmartDashboard.putData("Autonomous Strategies", autoChooser);
    }
    
    public void startMode(){
        
        AutoMode selectedAutoMode = (AutoMode)(autoChooser.getSelected());
                    
        switch (selectedAutoMode){
            case AUTOMODE_SPY_BOX:
                new AutoSpyBox();
                break;
            case AUTOMODE_REACH_DEFENSE:
                new AutoReachDefense();
                break;
            case AUTOMODE_CROSS_DEFENSE:
                new AutoCrossDefense();
                break;
            case AUTOMODE_NONE:
                //DO NOTHING
            default:
                break;
            }
            
    }

}