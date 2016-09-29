package org.firstinspires.ftc.robotcontroller.external.samples;

/**
 * Created by Jacob on 9/29/2016.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class AHATest extends OpMode {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public AHATest() {
    }

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.right_bumper) {
            rightMotor.setPower(10);
        } else if(gamepad1.right_stick_button){
            rightMotor.setPower(-10);
        } else {
            leftMotor.setPower(0);
        }
        if(gamepad1.left_bumper) {
            leftMotor.setPower(10);
        } else if(gamepad1.left_stick_button){
            leftMotor.setPower(-10);
        } else {
            leftMotor.setPower(0);
        }
    }
}
