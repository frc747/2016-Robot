package org.usfirst.frc.team869.robot.commands;

import org.usfirst.frc.team869.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VisionToggleCommand extends Command {

    public VisionToggleCommand() {
        //requires(Robot.DUAL_CAMERA);
    }

    protected void initialize() {
    }

    protected void execute() {
        //Robot.DUAL_CAMERA.switchCameras();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
