package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a K9 robot.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left motor"
 * Motor channel:  Right drive motor:        "right motor"
 * Servo channel:  Servo to raise/lower arm: "arm"
 * Servo channel:  Servo to open/close claw: "claw"
 *
 * Note: the configuration of the servos is such that:
 *   As the arm servo approaches 0, the arm position moves up (away from the floor).
 *   As the claw servo approaches 0, the claw opens up (drops the game element).
 */
public class Hardware6983
{
    /* Public OpMode members. */


    public DcMotor frontLeft = null;
    public  DcMotor frontRight= null;
    public  DcMotor backLeft= null;
    public  DcMotor backRight= null;
    public  DcMotor rightLauncher = null;
    public  DcMotor leftLauncher = null;
    public DcMotor string = null;

    public Servo gate = null;

    public final static double GATE_HOME = 0.2;

    public final static double GATE_MIN_RANGE  = 0.20;
    public final static double GATE_MAX_RANGE  = 0.90;


    /* Local OpMode members. */
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware6983() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors

        frontLeft = hwMap.dcMotor.get("front_l");
        frontRight = hwMap.dcMotor.get("front_r");
        backLeft = hwMap.dcMotor.get("back_l");
        backRight = hwMap.dcMotor.get("back_r");
        string = hwMap.dcMotor.get("string");

        rightLauncher = hwMap.dcMotor.get("launch_right");
        leftLauncher = hwMap.dcMotor.get("launch_left");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        rightLauncher.setDirection(DcMotor.Direction.REVERSE);



        rightLauncher.setPower(0);
        leftLauncher.setPower(0);
        string.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    string.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightLauncher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftLauncher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Define and initialize ALL installed servos.
        gate = hwMap.servo.get("gate");

        gate.setPosition(GATE_HOME);

    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs)  throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
