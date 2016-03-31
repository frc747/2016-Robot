package org.usfirst.frc.team869.robot;

/**
 * Distances are in inches
 * Rotations are in degrees
 * Times are in seconds
 * Speed values are in motor %
 */
public final class AutonomousConfig {
    
    private AutonomousConfig() {
    } 
    
    //TODO Determine Values for these classes
    public final class SpyBox{
        
        private SpyBox(){
        }
        
        public static final int FIRST_DISTANCE  = 100, 
                                SECOND_DISTANCE = 100,
                                ROTATION        = -10;
        
        public static final double SHOOTER_STOP = 10,
                                   INTAKE_START = 1.5,
                                   INTAKE_STOP  = 10,
                                   DRIVE_SPEED  = 0.5;
    }
    
    public final class ReachDefenses{
        
        private ReachDefenses(){
        }
        
        public static final double SPEED    = -.25,
                                   DISTANCE = 50.5;  
    }
    
    public final class CrossDefense{
        
        private CrossDefense(){
        }
        
        public static final double SPEED    = 1,
                                   DISTANCE = -170;
    }
    
    public final class CrossRamparts{
        
    	private CrossRamparts(){
        }
        
        public static final double SPEED_LEFT    = 1,
        						   SPEED_RIGHT	 = 1,
                                   REACH_RAMPARTS = -60,
        						   CROSS_RAMPARTS = -110;
        							
    }
}