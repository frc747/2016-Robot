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
        
        public static final double SPEED           = -.25,
                                   DISTANCE        = 50.5;
    }
    
    public final class CrossDefense{
        
        private CrossDefense(){
        }
        
        public static final double TRAVEL_SPEED    = 1,
                                   TRAVEL_DISTANCE = -170,
                                   TRAVEL_SPEED_2    = -.5,
                                   TRAVEL_DISTANCE_2 = -30,
                                   ROTATE_SPEED    = .5;
                                   
        public static final int    ROTATE_ANGLE    = 180;
    }
    public final class CrossRockwall{
        
        private CrossRockwall(){
        }
        
        public static final double TRAVEL_SPEED    		= .75,
        					       TRAVEL_SPEED_2  		= -.5,
                                   TRAVEL_DISTANCE 		= -170,
                                   TRAVEL_DISTANCE_2 	= -30,
                                   ROTATE_SPEED    		= .5;
                                   
        public static final int    ROTATE_ANGLE    		= 180;
    }
    
    public final class CrossRamparts{
        
        private CrossRamparts(){}
        
        public static final double SPEED_LEFT      = 1,
                                   SPEED_RIGHT     = .5,
                                   SPEED_EQUAL     = 1,
                                   SPEED_EQUAL_2   = -1,
                                   APPROACH_GOAL   = -30,
                                   REACH_RAMPARTS  = -60,
                                   CROSS_RAMPARTS  = -110;
   
        public static final int    ROTATE_ANGLE    = 180;
                                    
    }
    
    public final class CrossWackyBridges{
    	
    	private CrossWackyBridges(){}
    								//TODO verify distance and speed values
    	public static final double  SPEED          = -.5,
    								INCH_TO_BRIDGE = 60,
    								INCH_OVER_BRIDGE = 120;
    	
    }
}