
package org.usfirst.frc.team869.robot;

import org.usfirst.frc.team869.robot.commands.DriveLowSpeedCommand;
import org.usfirst.frc.team869.robot.commands.IntakeArticulateUpCommand;
import org.usfirst.frc.team869.robot.commands.IntakeBreakCommand;
import org.usfirst.frc.team869.robot.subsystems.ClimberAssistSubsystem;
import org.usfirst.frc.team869.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team869.robot.subsystems.DriveShiftSubsystem;
import org.usfirst.frc.team869.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team869.robot.subsystems.DualCameraSubsystem;
import org.usfirst.frc.team869.robot.subsystems.IntakeArticulationSubsystem;
import org.usfirst.frc.team869.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team869.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
    public static final DualCameraSubsystem         DUAL_CAMERA           = new DualCameraSubsystem("cam0", "cam2");
    
    private static OI oi;

    private Command      autonomousCommand;
    private Autonomous   autonomous;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        Robot.oi = new OI();
        this.autonomous = new Autonomous();
        Robot.DUAL_CAMERA.initializeCameras();
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
    	Robot.DRIVE_TRAIN.resetNavXYaw();
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
    	CLIMBER_SYSTEM.climbReset();
    	DRIVE_SHIFT_SYSTEM.resetShiftSystem();
    	INTAKE_ARTICULATION.resetArticulation();
    	
        if (autonomousCommand != null){ 
            autonomousCommand.cancel();
        }
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        System.out.println("CLIMB BUTTON1 State = " +  OI.OPERATOR_CONTROLLER.getRawButton(RobotMap.CLIMB_BUTTON_1)  +   
        		"CLIMB BUTTON2 State = " + OI.OPERATOR_CONTROLLER.getRawButton(RobotMap.CLIMB_BUTTON_2) + "\n" );
        System.out.println("Solenoid Extend State = " + Robot.CLIMBER_SYSTEM.climbExtend.get() + 
        		"    Solenoid Retract State = " + Robot.CLIMBER_SYSTEM.climbRetract.get() + "\n" );

        
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
