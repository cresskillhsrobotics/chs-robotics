package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jacob Gorman
 */

@TeleOp(name="StandardTeleOp", group="6983")
public class TeleOp6983 extends OpMode {

    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;

    DcMotor m1;
    DcMotor m2;

    Servo s1;
    Servo s2;

    double          s1Position    = 0;
    double          s2Position    = 0;
    final double    S1_SPEED      = 0.01 ;
    final double    S2_SPEED      = 0.01 ;

    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("front_l");
        fr = hardwareMap.dcMotor.get("front_r");
        bl = hardwareMap.dcMotor.get("back_l");
        br = hardwareMap.dcMotor.get("back_r");

        m1 = hardwareMap.dcMotor.get("motor_one");
        m2 = hardwareMap.dcMotor.get("motor_two");

        s1 = hardwareMap.servo.get("servo_one");
        s2 = hardwareMap.servo.get("servo_two");

        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
        m1.setPower(0);
        m2.setPower(0);

        s1.setPosition(0);
        s2.setPosition(0);
    }

    @Override
    public void loop() {

        if(gamepad1.left_stick_y > 0.25 || gamepad1.left_stick_x > 0.25 || gamepad1.left_stick_y < -0.25 || gamepad1.left_stick_x < -0.25) {
            fr.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
            fl.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
            br.setPower((-gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
            bl.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x)/2);
        }
        if(gamepad1.right_stick_x > 0.25 || gamepad1.right_stick_x < -0.25) {
            fr.setPower((-gamepad1.right_stick_x)/2);
            fl.setPower((-gamepad1.right_stick_x)/2);
            br.setPower((gamepad1.right_stick_x)/2);
            bl.setPower((gamepad1.right_stick_x)/2);
        }

        if (gamepad2.x)
            s1Position += S1_SPEED;
        else if (gamepad2.y)
            s1Position -= S1_SPEED;

        if (gamepad2.a)
            s2Position += S2_SPEED;
        else if (gamepad2.b)
            s2Position -= S2_SPEED;

        if(gamepad1.right_bumper) {
            m1.setPower(0.5);
        } else if(gamepad1.left_bumper) {
            m1.setPower(-0.5);
        } else {
            m1.setPower(0);
        }

        if(gamepad2.right_bumper) {
            m2.setPower(0.5);
        } else if(gamepad2.left_bumper) {
            m2.setPower(-0.5);
        } else {
            m2.setPower(0);
        }

        s1.setPosition(s1Position);
        s2.setPosition(s2Position);



    }
}
