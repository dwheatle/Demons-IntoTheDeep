package org.firstinspires.ftc.teamcode.OpModes_Development;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Cogintilities.Buttons.MomentaryButton;
import org.firstinspires.ftc.teamcode.Cogintilities.Buttons.ToggleButton;
import org.firstinspires.ftc.teamcode.RobotConfiguration.RobotConfig;

//@Disabled
@TeleOp(name="ButtonTesting", group="Development")
public class DevOpButtonTesting extends RobotConfig {

    MomentaryButton momButton;
    ToggleButton togButton;

    @Override
    public void runOpMode() throws InterruptedException {

        initializeRobot();

        momButton = new MomentaryButton(gamepad1.a, false);
        togButton = new ToggleButton(gamepad1.b, false);

        /* Uncomment to test inversion function */
//        momButton = new MomentaryButton(gamepad1.a, true);
//        togButton = new ToggleButton(gamepad1.b, true);

        waitForStart();

        while (opModeIsActive()) {

            updateButtons();

            telemetry.addData("Momentary Button Value:", momButton.state());
            telemetry.addData("Toggle Button Value:   ", togButton.state());
            telemetry.update();

            sleep(50);
        }
    }


    /**
     * Update all Button objects here to reduce clutter in the main loop
     */
    private void updateButtons() {
        momButton.update(gamepad1.a);
        togButton.update(gamepad1.b);
    }
}
