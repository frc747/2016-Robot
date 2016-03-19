package org.usfirst.frc.team869.robot;


import edu.wpi.first.wpilibj.smartdashboard.*;
import org.usfirst.frc.team869.robot.commands.*;



public class Autonomous{
	
	public enum AutoMode{
		AUTOMODE_NONE,
		AUTOMODE_REACH_DEFENSE,
		AUTOMODE_CROSS_DEFENSE,
		AUTOMODE_SPY_BOX,
//		AUTOMODE_POSITION_2,
//		AUTOMODE_POSITION_3,
//		AUTOMODE_POSITION_4,
//		AUTOMODE_POSITION_5,
//		AUTOMODE_ROCKWALL_2,
//		AUTOMODE_ROCKWALL_3,
//		AUTOMODE_ROCKWALL_4,
//		AUTOMODE_ROCKWALL_5,
		//AUTOMODE_SHOVEL_THE_FRIES_2,
		//AUTOMODE_SHOVEL_THE_FRIES_3,
		//AUTOMODE_SHOVEL_THE_FRIES_4,
		//AUTOMODE_SHOVEL_THE_FRIES_5
    }
	
	
	private Robot robot;
	private SendableChooser autoChooser;
	
	
	public Autonomous(Robot robot){
			this.robot = robot;
	        autoChooser = new SendableChooser();
	        autoChooser.addDefault("No autonomous", AutoMode.AUTOMODE_NONE);
	        autoChooser.addObject("Spy Box", AutoMode.AUTOMODE_SPY_BOX);
	        autoChooser.addObject("Reach Defense", AutoMode.AUTOMODE_REACH_DEFENSE);
	        autoChooser.addObject("Cross Defense", AutoMode.AUTOMODE_CROSS_DEFENSE);
//	        autoChooser.addObject("Position 2", AutoMode.AUTOMODE_POSITION_2);
//	        autoChooser.addObject("Position 3", AutoMode.AUTOMODE_POSITION_3);
//	        autoChooser.addObject("Position 4", AutoMode.AUTOMODE_POSITION_4);
//	        autoChooser.addObject("Position 5", AutoMode.AUTOMODE_POSITION_5);
//	        autoChooser.addObject("Rockwall 2", AutoMode.AUTOMODE_ROCKWALL_2);
//	        autoChooser.addObject("Rockwall 3", AutoMode.AUTOMODE_ROCKWALL_3);
//	        autoChooser.addObject("Rockwall 4", AutoMode.AUTOMODE_ROCKWALL_4);
//	        autoChooser.addObject("Rockwall 5", AutoMode.AUTOMODE_ROCKWALL_5);
	//        autoChooser.addObject("Shovel The Fries Posi 2", AutoMode.AUTOMODE_SHOVEL_THE_FRIES_2);
	//        autoChooser.addObject("Shovel The Fries Posi 3", AutoMode.AUTOMODE_SHOVEL_THE_FRIES_3);
	//        autoChooser.addObject("Shovel The Fries Posi 4", AutoMode.AUTOMODE_SHOVEL_THE_FRIES_4);
	//        autoChooser.addObject("Shovel The Fries Posi 5", AutoMode.AUTOMODE_SHOVEL_THE_FRIES_5);
	        SmartDashboard.putData("Autonomous Strategies", autoChooser);
	}   //Autonomous
	
	
	
	
	public void startMode(){
		
			AutoMode selectedAutoMode = (AutoMode)(autoChooser.getSelected());
					
			switch (selectedAutoMode){
			
					default:
					case AUTOMODE_NONE:
					          //DO NOTHING
					break;
					case AUTOMODE_SPY_BOX:
		                			new AutoSpyBox();
		            break;
					case AUTOMODE_REACH_DEFENSE:
            			new AutoSpyBox();
            		break;
					case AUTOMODE_CROSS_DEFENSE:
            			new AutoSpyBox();
            		break;
//					case AUTOMODE_POSITION_2:
//					                new AutoPosition2();
//					break;
//					case AUTOMODE_POSITION_3:
//					              	new AutoPosition3();
//					break;
//					case AUTOMODE_POSITION_4:
//									new AutoPosition4();
//					break;
//					case AUTOMODE_POSITION_5:
//									new AutoPosition3();
//					break;
//					case AUTOMODE_ROCKWALL_2:
//									new AutoRockwall3();
//					break;
//					case AUTOMODE_ROCKWALL_3:
//									new AutoRockwall5();
//					break;	
//					case AUTOMODE_ROCKWALL_4:
//									new AutoRockwall4();
//					break;
//					case AUTOMODE_ROCKWALL_5:
//									new AutoRockwall5();
//					break;
			        }
			
	}   //startMode
	
	public void stopMode(){
	        //robot.driveBase.stop();
	}   //stopMode
	
	
	public void runPeriodic(double elapsedTime){
	}   //runPeriodic
	
	
//	public void runContinuous(double elapsedTime){
//			if (autoStrategy != null){
//			            autoStrategy.autoPeriodic(elapsedTime);
//			}
//	}   //runContinuous

}   //class Autonomous