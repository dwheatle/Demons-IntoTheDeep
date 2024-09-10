package org.firstinspires.ftc.teamcode.SubSytems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class MecanumDriveBasic {

    private final DcMotorEx leftFront, leftRear, rightFront, rightRear;
    private double drive, strafe, turn;

    /**************** Drive Constants ****************/
    private final double DEGRADED_DRIVE_LIMIT  = 0.55;
    private final double DEGRADED_STRAFE_LIMIT = 0.45;
    private final double DEGRADED_TURN_LIMIT   = 0.35;
    /*************************************************/

    private double driveAuthority, strafeAuthority, turnAuthority;

    /**
     * CONSTRUCTOR
     * @param leftFront
     * @param leftRear
     * @param rightFront
     * @param rightRear
     */
    public MecanumDriveBasic(DcMotorEx leftFront, DcMotorEx leftRear, DcMotorEx rightFront, DcMotorEx rightRear) {
int x = 0;
        this.leftFront  = leftFront;
        this.leftRear   = leftRear;
        this.rightFront = rightFront;
        this.rightRear  = rightRear;

        /** Assign Motor Directions **/
        this.leftFront.setDirection(DcMotorEx.Direction.FORWARD);
        this.rightFront.setDirection(DcMotorEx.Direction.REVERSE);
        this.leftRear.setDirection(DcMotorEx.Direction.FORWARD);
        this.rightRear.setDirection(DcMotorEx.Direction.REVERSE);

        /** Initialize Motor Power to 0 **/
        setMotorPower(0,0,0,0);
        drive = strafe = turn = 0;
    }

    /**
     * Drive robot using mecanum drive wheels
     * @param driveCmd
     * @param strafeCmd
     * @param turnCmd
     * @param degradedMode
     */
    public void mecanumDrive(double driveCmd, double strafeCmd, double turnCmd, boolean degradedMode) {

        if(!degradedMode) {
            drive = driveCmd;
            strafe = strafeCmd;
            turn = turnCmd;
        } else {
            drive = driveCmd * DEGRADED_DRIVE_LIMIT;
            strafe = strafeCmd * DEGRADED_STRAFE_LIMIT;
            turn = turnCmd * DEGRADED_TURN_LIMIT;
        }

        double denominator = Math.max(Math.abs(driveCmd) + Math.abs(strafeCmd) + Math.abs(turnCmd), 1);
        double frontLeftPower  = (drive + strafe + turn) / denominator;
        double backLeftPower   = (drive - strafe + turn) / denominator;
        double frontRightPower = (drive - strafe - turn) / denominator;
        double backRightPower  = (drive + strafe - turn) / denominator;

        setMotorPower(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }

    /**
     * Sets power to the four drive motors
     * @param lfPower
     * @param rfPower
     * @param lrPower
     * @param rrPower
     */
    private void setMotorPower(double lfPower,double rfPower, double lrPower, double rrPower) {
        leftFront.setPower(lfPower);
        rightFront.setPower(rfPower);
        leftRear.setPower(lrPower);
        rightRear.setPower(rrPower);
    }


    /** Setters and Getters **/
    public double getDriveCmd() { return drive;  }
    public double getTurnCmd()  { return turn;   }
    public double getStrafe()   { return strafe; }
    public double getLFpos()    { return leftFront.getCurrentPosition(); }
    public double geLRpos()     { return leftRear.getCurrentPosition(); }
    public double geRFpos()     { return rightFront.getCurrentPosition(); }
    public double geRRpos()     { return rightRear.getCurrentPosition(); }
    public double getLFpower()  { return leftFront.getPower(); }
    public double getLRpower()  { return leftRear.getPower(); }
    public double getRFpower()  { return rightFront.getPower(); }
    public double getRRpower()  { return rightRear.getPower(); }
}
