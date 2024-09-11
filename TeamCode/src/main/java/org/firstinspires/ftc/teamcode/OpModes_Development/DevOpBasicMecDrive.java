package org.firstinspires.ftc.teamcode.OpModes_Development;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Cogintilities.Buttons.ToggleButton;
import org.firstinspires.ftc.teamcode.RobotConfiguration.RobotConfig;

//@Config      /* if RoadRunner is installed, this enables all public variables to be available on the dashboard */
//@Disabled
@TeleOp(name="BasicMecDrive", group="Development")
public class DevOpBasicMecDrive extends RobotConfig {

    @Override
    public void runOpMode() throws InterruptedException {

        initializeRobot();
        ToggleButton degradeDriveButton = new ToggleButton(false, false);

        waitForStart();

        while (opModeIsActive()) {
            degradeDriveButton.update(gamepad1.left_bumper);

            drive.mecanumDrive( -gamepad1.left_stick_y,
                                 gamepad1.left_stick_x,
                                 gamepad1.right_stick_x,
                                 degradeDriveButton.state());

            telemetry.addData("Drive Authority: ", degradeDriveButton.state() ? "Degraded" : "Normal");
            telemetry.update();

            sleep(30);
        }
    }
}
