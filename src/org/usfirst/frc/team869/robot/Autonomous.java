package org.usfirst.frc.team869.robot;


import edu.wpi.first.wpilibj.smartdashboard.*;

import org.usfirst.frc.team869.robot.autonomous.CrossDefense;
import org.usfirst.frc.team869.robot.autonomous.ReachDefense;
import org.usfirst.frc.team869.robot.autonomous.SpyBox;

public class Autonomous{
    
    public enum AutoMode{
        AUTOMODE_NONE,
        AUTOMODE_REACH_DEFENSE,
        AUTOMODE_CROSS_DEFENSE,
        AUTOMODE_SPY_BOX,
    }
    
    private SendableChooser autoChooser1;
//    private SendableChooser autoChooser2;
    
    public Autonomous(){
        autoChooser1 = new SendableChooser();
//        autoChooser2 = new SendableChooser();
        
        
        autoChooser1.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
        autoChooser1.addObject("Spy Box", AutoMode.AUTOMODE_SPY_BOX);
        autoChooser1.addObject("Reach Defense", AutoMode.AUTOMODE_REACH_DEFENSE);
        autoChooser1.addObject("Cross Defense", AutoMode.AUTOMODE_CROSS_DEFENSE);
        SmartDashboard.putData("Auto mode", autoChooser1);
        
//        autoChooser2.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
//        autoChooser2.addObject("Spy Box", AutoMode.AUTOMODE_SPY_BOX);
//        autoChooser2.addObject("Reach Defense");
//        autoChooser2.addObject("Cross Defense");
//        SmartDashboard.putData("Autonomous Position", autoChooser2);
        
    }
    
    public void startMode(){
        
        AutoMode selectedAutoMode = (AutoMode)(autoChooser1.getSelected());
                    
        switch (selectedAutoMode){
            case AUTOMODE_SPY_BOX:
                //new SpyBox();
                break;
            case AUTOMODE_REACH_DEFENSE:
                new ReachDefense().start();
                break;
            case AUTOMODE_CROSS_DEFENSE:
                new CrossDefense().start();
                break;
            case AUTOMODE_NONE:
                //DO NOTHING
            default:
                break;
            }
    }
}