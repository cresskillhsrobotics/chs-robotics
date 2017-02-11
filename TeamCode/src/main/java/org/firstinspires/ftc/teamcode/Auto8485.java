package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by harry on 2016-10-30.
 */

@Autonomous(name="Auto8485_Red", group="8485")
public class Auto8485 extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor catapult;

    ElapsedTime time = new ElapsedTime();

    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("front_l");
        frontRight = hardwareMap.dcMotor.get("front_r");
        backLeft = hardwareMap.dcMotor.get("back_l");
        backRight = hardwareMap.dcMotor.get("back_r");

        catapult = hardwareMap.dcMotor.get("ctpult");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        //SHOOTER TEST
        catapult.setPower(.5);
        time.reset();
        while(opModeIsActive() && time.seconds() < 2.30) {//calibrated
            idle();
        }
        catapult.setPower(0);


        /*time.reset();
        while(opModeIsActive() && time.seconds() < 5) {
            idle();
        }
        //DRIVING FORWARDS TEST
        //speed - 0.51 ft/s
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(1);
        backRight.setPower(1);
        time.reset();
        while(opModeIsActive() && time.seconds() < 10) {
            idle();
        }
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        time.reset();
        while(opModeIsActive() && time.seconds() < 10) {
            idle();
        }

        //DRIVING TURNING TEST
        //1.26 s = 90 degrees
        frontLeft.setPower(1);
        backLeft.setPower(1);
        frontRight.setPower(-1);
        backRight.setPower(-1);
        time.reset();
        while(opModeIsActive() && time.seconds() < 10) {
            idle();
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);*/
    }
}
