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

    DcMotor zipTie;
    DcMotor tankTread;

    DcMotor shooter;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("front_l");
        frontRight = hardwareMap.dcMotor.get("front_r");
        backLeft = hardwareMap.dcMotor.get("back_l");
        backRight = hardwareMap.dcMotor.get("back_r");

        zipTie = hardwareMap.dcMotor.get("zip_tie");
        tankTread = hardwareMap.dcMotor.get("tread");

        shooter = hardwareMap.dcMotor.get("shoot");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        //zipTie.setDirection(DcMotor.Direction.REVERSE);
        //tankTread.setDirection(DcMotor.Direction.REVERSE);
        //shooter.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        zipTie.setPower(0);
        tankTread.setPower(0);
        shooter.setPower(0);
    }

    @Override
    public void loop() {
        double left = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;

        frontLeft.setPower(left);
        backLeft.setPower(left);
        frontRight.setPower(right);
        backRight.setPower(right);

        if(gamepad1.a) {
            zipTie.setPower(0.5);
        } else if(gamepad1.y) {
            zipTie.setPower(-0.5);
        } else {
            zipTie.setPower(0);
        }

        if(gamepad1.right_bumper) {
            tankTread.setPower(0.5);
        } else if(gamepad1.right_trigger != 0) {
            tankTread.setPower(-0.5);
        } else {
            tankTread.setPower(0);
        }

        if(gamepad1.left_bumper) {
            shooter.setPower(1);
        } else if(gamepad1.right_trigger != 0) {
            shooter.setPower(-1);
        } else {
            shooter.setPower(0);
        }
    }
}
