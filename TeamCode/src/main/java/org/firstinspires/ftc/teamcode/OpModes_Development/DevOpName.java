package org.firstinspires.ftc.teamcode.OpModes_Development;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotConfiguration.RobotConfig;

// @Config      /* if RoadRunner is installed, this enables all public variables to be available on the dashboard */
@Disabled
@TeleOp(name="devOpName", group="Development")
public class DevOpName extends RobotConfig {


    @Override
    public void runOpMode() throws InterruptedException {
        initializeRobot();

        waitForStart();

        while (opModeIsActive()) {

        }
    }

}
