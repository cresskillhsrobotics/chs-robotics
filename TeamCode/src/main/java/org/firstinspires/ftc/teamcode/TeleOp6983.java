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

    Servo s1;
    Servo s2;

    double          s1Position    = 0;
    double          s2Position    = 0;
    final double    S1_SPEED      = 0.01 ;
    final double    S2_SPEED      = 0.01 ;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("front_left");
        frontRight = hardwareMap.dcMotor.get("front_right");
        backLeft = hardwareMap.dcMotor.get("back_left");
        backRight = hardwareMap.dcMotor.get("back_right");


        rightLauncher = hardwareMap.dcMotor.get("launch_right");
        leftLauncher = hardwareMap.dcMotor.get("launch_left");

        s1 = hardwareMap.servo.get("servo_one");
        s2 = hardwareMap.servo.get("servo_two");

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        rightLauncher.setPower(0);
        leftLauncher.setPower(0);
    }

    @Override
    public void loop() {
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
    }
}