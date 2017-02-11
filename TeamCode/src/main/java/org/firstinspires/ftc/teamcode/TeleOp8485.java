package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by harry on 2016-10-29.
 */

@TeleOp(name="TeleOp8485", group="8485")
public class TeleOp8485 extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor shooterLeft;
    DcMotor shooterRight;

    DcMotor catapult;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("front_l");
        frontRight = hardwareMap.dcMotor.get("front_r");
        backLeft = hardwareMap.dcMotor.get("back_l");
        backRight = hardwareMap.dcMotor.get("back_r");

        shooterLeft = hardwareMap.dcMotor.get("shooter_left");
        shooterRight = hardwareMap.dcMotor.get("shooter_right");

        catapult = hardwareMap.dcMotor.get("ctpult");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        shooterLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double leftVert = -gamepad1.left_stick_y;
        double leftHorz = gamepad1.left_stick_x;
        double rightVert = -gamepad1.right_stick_y;
        double rightHorz = gamepad1.right_stick_x;

        if(Math.abs(leftVert) > Math.abs(leftHorz)) {
            //drive forwards/backwards for left wheels
            frontLeft.setPower(leftVert);
            backLeft.setPower(leftVert);
        } else if(Math.abs(leftHorz) > Math.abs(leftVert)) {
            //drive left/right for left wheels
            frontLeft.setPower(leftHorz);
            backLeft.setPower(-leftHorz);
        } else if(leftHorz == 0 && leftVert == 0) {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        if(Math.abs(rightVert) > Math.abs(rightHorz)) {
            //drive forwards/backwards for right wheels
            frontRight.setPower(rightVert);
            backRight.setPower(rightVert);
        } else if(Math.abs(rightHorz) > Math.abs(rightVert)) {
            //drive left/right for right wheels
            frontRight.setPower(-rightHorz);
            backRight.setPower(rightHorz);
        } else if(rightHorz == 0 && rightVert == 0) {
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        if(gamepad1.a) {
            shooterLeft.setPower(-.5);
            shooterRight.setPower(.5);
        } else if(gamepad1.b) {
            shooterLeft.setPower(.5);
            shooterRight.setPower(-.5);
        } else {
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
        }

        if(gamepad1.right_bumper) {
            catapult.setPower(0.50);
        } else if(gamepad1.right_trigger != 0) {
            catapult.setPower(-1.00);
        } else {
            catapult.setPower(0);
        }

    }
}
