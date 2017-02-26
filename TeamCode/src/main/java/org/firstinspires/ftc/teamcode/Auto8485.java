package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by harry on 2016-10-30.
 */

@Autonomous(name="Auto8485_Beacon", group="8485")
public class Auto8485 extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    DcMotor belt;

    DcMotor shooterLeft;
    DcMotor shooterRight;

    Servo leftServo;
    Servo rightServo;

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

        rightServo = hardwareMap.servo.get("srv_2");
        leftServo = hardwareMap.servo.get("srv_1");

        colorSensor.enableLed(false);

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        rightServo.setPosition(0);
        leftServo.setPosition(0);

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

        frontLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backLeft.setPower(0.0);
        backRight.setPower(0.0);

        //wait for a second
        while(time.seconds() < 10) {}

        //do color sensor/beacon pushing
        if(colorSensor.red() > colorSensor.blue()) {
            //red light
            moveServo(leftServo);
        } else if(colorSensor.red() > 2) {
            //blue light
            moveServo(rightServo);
        }

        telemetry.addData("red", colorSensor.red());
        telemetry.addData("blue", colorSensor.blue());
        telemetry.update();
    }

    public void moveServo(Servo sv) {
        for(int i = 0; i < 200; i++) {
            sv.setPosition(sv.getPosition()+0.01);
            try {
                Thread.sleep(10);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 200; i++) {
            sv.setPosition(sv.getPosition()-0.01);
            try {
                Thread.sleep(10);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
