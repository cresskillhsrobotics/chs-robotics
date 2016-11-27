package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jacob Gorman
 */

@TeleOp(name="Teleop6983", group="6983")
public class TeleOp6983 extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor rightLauncher;
    DcMotor leftLauncher;

    DcMotor conveyor;
    DcMotor zipTie;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("front_left");
        frontRight = hardwareMap.dcMotor.get("front_right");
        backLeft = hardwareMap.dcMotor.get("back_left");
        backRight = hardwareMap.dcMotor.get("back_right");

        zipTie = hardwareMap.dcMotor.get("zip");
        conveyor = hardwareMap.dcMotor.get("conveyor");

        rightLauncher = hardwareMap.dcMotor.get("launch_right");
        leftLauncher = hardwareMap.dcMotor.get("launch_left");

        leftLauncher.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        rightLauncher.setPower(0);
        leftLauncher.setPower(0);

        zipTie.setPower(0);
        conveyor.setPower(0);
    }

    @Override
    public void loop() {
        //TO SLOW DOWN INCREASE THE "2" to "3" In the next 8 statements etc (decimals work *e.g. 2.5)

        if(gamepad1.left_stick_y > 0.25 || gamepad1.left_stick_x > 0.25 || gamepad1.left_stick_y < -0.25 || gamepad1.left_stick_x < -0.25) {
            frontRight.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
            frontLeft.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
            backRight.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
            backLeft.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
        } else if(gamepad1.right_stick_y > 0.25 || gamepad1.right_stick_y < -0.25) {
            frontRight.setPower((gamepad1.right_stick_y)/2);
            frontLeft.setPower(-(gamepad1.right_stick_y)/2);
            backRight.setPower((gamepad1.right_stick_y)/2);
            backLeft.setPower(-(gamepad1.right_stick_y)/2);
        } else {
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
        }
        if(gamepad1.right_trigger > 0.5) {
            rightLauncher.setPower(1);
            leftLauncher.setPower(1);
        } else if(gamepad1.left_trigger > 0.5) {
            rightLauncher.setPower(-1);
            leftLauncher.setPower(-1);
        } else {
            rightLauncher.setPower(0);
            leftLauncher.setPower(0);
        }
        if (gamepad1.a) {
            zipTie.setPower(1);
        } else if(gamepad1.b) {
            zipTie.setPower(-1);
        } else {
            zipTie.setPower(0);
        }
        if (gamepad1.x) {
            conveyor.setPower(1);
        } else if(gamepad1.y) {
            conveyor.setPower(-1);
        } else {
            conveyor.setPower(0);
        }
    }
}