package org.usfirst.frc.team869.robot;


import org.usfirst.frc.team869.robot.autonomous.CrossDefense;
import org.usfirst.frc.team869.robot.autonomous.CrossRamparts;
import org.usfirst.frc.team869.robot.autonomous.CrossRampartsTEST;
import org.usfirst.frc.team869.robot.autonomous.CrossRockwall;
import org.usfirst.frc.team869.robot.autonomous.ReachDefense;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous{
    
    public enum AutoMode{
        AUTOMODE_NONE,
        AUTOMODE_REACH_DEFENSE,
        AUTOMODE_CROSS_DEFENSE,
        AUTOMODE_CROSS_ROCKWALL,
        AUTOMODE_CROSS_RAMPARTS,
        AUTOMODE_CROSS_RAMPARTS_TEST
    }
    
    private SendableChooser autoChooser;
    
    public Autonomous(){
        autoChooser = new SendableChooser();
        
        autoChooser.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
        autoChooser.addObject("Reach Defense", AutoMode.AUTOMODE_REACH_DEFENSE);
        autoChooser.addObject("Cross Defense", AutoMode.AUTOMODE_CROSS_DEFENSE);
        autoChooser.addObject("Cross Ramparts", AutoMode.AUTOMODE_CROSS_RAMPARTS);
        autoChooser.addObject("Cross Rockwall", AutoMode.AUTOMODE_CROSS_ROCKWALL);
        autoChooser.addObject("**TEST** Cross Ramparts", AutoMode.AUTOMODE_CROSS_RAMPARTS_TEST);
        SmartDashboard.putData("Auto mode", autoChooser);
    }
    
    public void startMode(){
        
        AutoMode selectedAutoMode = (AutoMode)(autoChooser.getSelected());
                    
        switch (selectedAutoMode){
            case AUTOMODE_REACH_DEFENSE:
                new ReachDefense().start();
                break;
            case AUTOMODE_CROSS_DEFENSE:
                new CrossDefense().start();
                break;
            case AUTOMODE_CROSS_RAMPARTS:
                new CrossRamparts().start();
                break;
            case AUTOMODE_CROSS_ROCKWALL:
                new CrossRockwall().start();
                break;
            case AUTOMODE_CROSS_RAMPARTS_TEST:
                new CrossRampartsTEST().start();
                break;
            case AUTOMODE_NONE:
                //DO NOTHING
            default:
                break;
            }
    }
}