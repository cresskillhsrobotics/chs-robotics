package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by harry on 2016-10-30.
 */

@Autonomous(name="Auto8485_Straight", group="8485")
public class Auto8485 extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor belt;

    DcMotor shooterLeft;
    DcMotor shooterRight;

    ColorSensor colorSensor;

    ElapsedTime time = new ElapsedTime();

    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("front_l");
        frontRight = hardwareMap.dcMotor.get("front_r");
        backLeft = hardwareMap.dcMotor.get("back_l");
        backRight = hardwareMap.dcMotor.get("back_r");

        belt = hardwareMap.dcMotor.get("belt");

        shooterLeft = hardwareMap.dcMotor.get("shooter_l");
        shooterRight = hardwareMap.dcMotor.get("shooter_r");

        colorSensor = hardwareMap.colorSensor.get("clr");

        boolean LEDState = false;

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        time.reset();

        shooterLeft.setPower(.6);
        shooterRight.setPower(-.6);
        belt.setPower(1);

        while(time.seconds() < 4) {}//4 seconds - shoots

        shooterLeft.setPower(0);
        shooterRight.setPower(0);
        belt.setPower(0);


        frontLeft.setPower(-.7);
        frontRight.setPower(-.7);
        backLeft.setPower(-.7);
        backRight.setPower(-.7);

        while(time.seconds() < 6) {}// 2 seconds - move backwards

        frontLeft.setPower(.7);
        frontRight.setPower(-.7);
        backLeft.setPower(.7);
        backRight.setPower(-.7);

        while(time.seconds() < 6.35) {} // .35 seconds turn right

        frontLeft.setPower(-.5);
        frontRight.setPower(-.5);
        backLeft.setPower(-.5);
        backRight.setPower(-.5);

        while(time.seconds() < 8.2) {} // 1.95 seconds move backward

        frontLeft.setPower(-.7);
        frontRight.setPower(.7);
        backLeft.setPower(-.7);
        backRight.setPower(.7);

        while(time.seconds() < 9) {} // .8  seconds turn left
        //robot is in line for beacon now

        colorSensor.enableLed(LEDState);
        float hsvValue[] = {0, 0, 0};
        Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValue);
        telemetry.addData("2 Clear", colorSensor.alpha());
        telemetry.addData("3 Red", colorSensor.red());
        telemetry.addData("4 Green", colorSensor.green());
        telemetry.addData("5 Blue", colorSensor.blue());
        telemetry.addData("6 Hue", hsvValue[0]);


    }
}
