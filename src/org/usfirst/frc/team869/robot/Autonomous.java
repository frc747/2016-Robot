package org.usfirst.frc.team869.robot;


import org.usfirst.frc.team869.robot.autonomous.CrossDefense;
import org.usfirst.frc.team869.robot.autonomous.CrossDefenseANDshoot;
import org.usfirst.frc.team869.robot.autonomous.CrossRamparts;
import org.usfirst.frc.team869.robot.autonomous.CrossRampartsANDshoot;
import org.usfirst.frc.team869.robot.autonomous.CrossRockwall;
import org.usfirst.frc.team869.robot.autonomous.CrossRockwallANDshoot;
//import org.usfirst.frc.team869.robot.autonomous.CrossChivalDeFrise;
import org.usfirst.frc.team869.robot.autonomous.ReachDefense;
//import org.usfirst.frc.team869.robot.autonomous.SpyBox;
//import org.usfirst.frc.team869.robot.autonomous.TestAuto;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous{
    
    public enum AutoMode{
        AUTOMODE_NONE,
        AUTOMODE_REACH_DEFENSE,
        AUTOMODE_CROSS_DEFENSE,
        AUTOMODE_CROSS_ROCKWALL,
        AUTOMODE_CROSS_RAMPARTS,
        AUTOMODE_SHOOT_DEFENSE,
        AUTOMODE_SHOOT_ROCKWALL,
        AUTOMODE_SHOOT_RAMPARTS
    }
    
    private SendableChooser autoChooser;
    
    public Autonomous(){
        autoChooser = new SendableChooser();
        
        autoChooser.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
//        autoChooser.addObject("Spy Box", AutoMode.AUTOMODE_SPY_BOX);
        autoChooser.addObject("Reach Defense", AutoMode.AUTOMODE_REACH_DEFENSE);
        autoChooser.addObject("Cross Defense", AutoMode.AUTOMODE_CROSS_DEFENSE);
        autoChooser.addObject("Cross Ramparts", AutoMode.AUTOMODE_CROSS_RAMPARTS);
        autoChooser.addObject("Cross Rockwall", AutoMode.AUTOMODE_CROSS_ROCKWALL);
        autoChooser.addObject("Shoot Defense", AutoMode.AUTOMODE_SHOOT_DEFENSE);
        autoChooser.addObject("Shoot Ramparts", AutoMode.AUTOMODE_SHOOT_RAMPARTS);
        autoChooser.addObject("Shoot Rockwall", AutoMode.AUTOMODE_SHOOT_ROCKWALL);
//        autoChooser.addObject("Cross Wacky Bridges", AutoMode.AUTOMODE_CROSS_WACKY_BRIDGES);
        SmartDashboard.putData("Auto mode", autoChooser);
    }
    
    public void startMode(){
        
        AutoMode selectedAutoMode = (AutoMode)(autoChooser.getSelected());
                    
        switch (selectedAutoMode){
//            case AUTOMODE_SPY_BOX:
//                //Change to .start() once this is proofed out
////                new SpyBox().cancel();
//                new TestAuto().start();
////            	new CrossWackyBridges().start();
//                break;
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
            case AUTOMODE_SHOOT_DEFENSE:
                new CrossDefenseANDshoot().start();
                break;
            case AUTOMODE_SHOOT_RAMPARTS:
                new CrossRampartsANDshoot().start();
                break;
            case AUTOMODE_SHOOT_ROCKWALL:
                new CrossRockwallANDshoot().start();
                break;
//            case AUTOMODE_CROSS_WACKY_BRIDGES:
//                new CrossChivalDeFrise().start();
//                break;
            case AUTOMODE_NONE:
                //DO NOTHING
            default:
                break;
            }
    }
}