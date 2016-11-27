package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by harry on 2016-11-26.
 */
@Autonomous(name="Auto6983", group="6983")
public class Auto6983 extends LinearOpMode{
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor rightLauncher;
    DcMotor leftLauncher;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("front_left");
        frontRight = hardwareMap.dcMotor.get("front_right");
        backLeft = hardwareMap.dcMotor.get("back_left");
        backRight = hardwareMap.dcMotor.get("back_right");

        rightLauncher = hardwareMap.dcMotor.get("launch_right");
        leftLauncher = hardwareMap.dcMotor.get("launch_left");

        leftLauncher.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        rightLauncher.setPower(0);
        leftLauncher.setPower(0);

        waitForStart();

        //drive forwards for 4 seconds
        frontLeft.setPower(-1);
        frontRight.setPower(1);
        backLeft.setPower(-1);
        backRight.setPower(1);
        long currentTime = System.currentTimeMillis();
        while (opModeIsActive() && System.currentTimeMillis() - currentTime < 4000) {
            idle();
        }
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        rightLauncher.setPower(1);
        leftLauncher.setPower(1);
        currentTime = System.currentTimeMillis();
        while (opModeIsActive() && System.currentTimeMillis() - currentTime < 4000) {
            idle();
        }
        rightLauncher.setPower(0);
        leftLauncher.setPower(0);

        //drive forwards for 4 more seconds
        frontLeft.setPower(-1);
        frontRight.setPower(1);
        backLeft.setPower(-1);
        backRight.setPower(1);
        currentTime = System.currentTimeMillis();
        while (opModeIsActive() && System.currentTimeMillis() - currentTime < 4000) {
            idle();
        }
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}
