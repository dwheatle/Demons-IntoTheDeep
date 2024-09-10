package org.firstinspires.ftc.teamcode.OpModes_Development;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Cogintilities.VisionProcessors.AprilTagProcessorObject;
import org.firstinspires.ftc.teamcode.RobotConfiguration.RobotConfig;

// @Config      /* if RoadRunner is installed, this enables all public variables to be available on the dashboard */
// @Disabled
@TeleOp(name="devOpVisionArchitecture", group="Development")
public class DevOpVisionArchitecture extends RobotConfig {

    /* Simple opMode to test the vision architecture. It will look for April Tags and
       display the number of tags in view.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        initializeRobot();

        AprilTagProcessorObject atags = new AprilTagProcessorObject();
        vision.buildVisionPortal(atags.getProcessor());

        waitForStart();

        while (opModeIsActive()) {
            atags.scanForAprilTags();
            telemetry.addData("Tags in View", atags.aprilTagsDetectedCount());
            telemetry.update();
            sleep(250);
        }
    }
}
