package org.firstinspires.ftc.teamcode.OpModes_Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.RobotConfiguration.RobotConfig;

@Disabled
@Autonomous(name="AutoTeamColorDescriptor", group="Autonomous")
public class AutoTeamColorDescriptor extends RobotConfig {

    @Override
    public void runOpMode() throws InterruptedException {

        /*
           First line of code should set the team color. This is needed for April Tags, TFOD object
           files or any other game element that is unique to the Red or Blue Alliance.
         */
        setAlliance(AllianceColor.RED); /* OR */ setAlliance(AllianceColor.BLUE);
        initializeRobot();

        waitForStart();

        while (opModeIsActive()) {

        }
    }
}
