
package org.usfirst.frc.team869.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team869.robot.subsystems.*;
import org.usfirst.frc.team869.robot.autonomous.CrossDefense;
import org.usfirst.frc.team869.robot.autonomous.ReachDefense;
import org.usfirst.frc.team869.robot.commands.*;
import org.usfirst.frc.team869.robot.controls.AutonomousSelectorButton;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static final DriveTrainSubsystem         DRIVE_TRAIN           = new DriveTrainSubsystem();
    public static final DriveShiftSubsystem         DRIVE_SHIFT_SYSTEM    = new DriveShiftSubsystem();
    public static final IntakeSubsystem             INTAKE_SYSTEM         = new IntakeSubsystem();
    public static final ShooterSubsystem            SHOOTER_SYSTEM        = new ShooterSubsystem();
    public static final IntakeArticulationSubsystem INTAKE_ARTICULATION   = new IntakeArticulationSubsystem();
    public static final ClimberSubsystem            CLIMBER_SYSTEM        = new ClimberSubsystem();
    public static final ClimberAssistSubsystem      CLIMBER_ASSIST_SYSTEM = new ClimberAssistSubsystem();
    
//    public static final VisionSubsystem             VISION_SYSTEM         = new VisionSubsystem(); //Was commented
    /*Added This*/
    public static final DualCameraSubsystem			DUAL_CAMERA			  = new DualCameraSubsystem("cam0", "cam1");
    /*Added This*/
    
    private static OI oi;

    private Command      autonomousCommand;
    //private CameraServer server; //Was commented
    private Autonomous   autonomous;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        Robot.oi = new OI();
        this.autonomous = new Autonomous();
        /*remove this
        Robot.CLIMBER_SYSTEM.climbLockOn();
        CameraServer server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        */
        /*Added This*/
        DUAL_CAMERA.initializeCameras();
        /*Added This*/
    }
    
    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit(){
    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
        new IntakeBreakCommand().start();
        new IntakeArticulateUpCommand().start();
        new DriveLowSpeedCommand().start();
        
            autonomous.startMode();
        if (autonomousCommand != null){
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
        if (autonomousCommand != null){ 
            autonomousCommand.cancel();
        }
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    /**
     * @return the oi
     */
    public static OI getOi() {
        return oi;
    }
}
