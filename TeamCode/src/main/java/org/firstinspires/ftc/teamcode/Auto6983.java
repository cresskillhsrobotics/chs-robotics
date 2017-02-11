package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by harry on 2016-11-26.
 */
@Autonomous(name="Auto6983", group="6983")
public class Auto6983 extends LinearOpMode{
    DcMotor rightLauncher;
    DcMotor leftLauncher;

    DcMotor string;

    Servo gate;

    ElapsedTime time;

    @Override
    public void runOpMode() throws InterruptedException {
        rightLauncher = hardwareMap.dcMotor.get("launch_right");
        leftLauncher = hardwareMap.dcMotor.get("launch_left");

        string = hardwareMap.dcMotor.get("string");

        rightLauncher.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();

        rightLauncher.setPower(0.5);
        leftLauncher.setPower(0.5);
        gate.setPosition(0.25);
        string.setPower(0.5);
        time.reset();
        while (opModeIsActive() && time.seconds() < 0.5) {
            idle();
        }
        string.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() < 5) {
            idle();
        }
        string.setPower(-0.5);
        time.reset();
        while (opModeIsActive() && time.seconds() < 0.5) {
            idle();
        }string.setPower(0.5);
        time.reset();
        while (opModeIsActive() && time.seconds() < 0.5) {
            idle();
        }
        string.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() < 5) {
            idle();
        }
        string.setPower(-0.5);
        time.reset();
        while (opModeIsActive() && time.seconds() < 0.5) {
            idle();
        }
        rightLauncher.setPower(0);
        leftLauncher.setPower(0);
    }
}
