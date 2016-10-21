package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.concurrent.TimeUnit;
/**
 * Created by Jacob on 10/21/2016.
 */

public class AHATest2 extends OpMode {
    public DcMotor motor;

    public AHATest2() {
    }

    @Override
    public void init() {
        motor = hardwareMap.dcMotor.get("motor");
    }

    @Override
    public void loop() {
        motor.setPower(50);
        TimeUnit.SECONDS.sleep(3);
        motor.setPower(-50);
        TimeUnit.SECONDS.sleep(3);
        motor.setPower(0);
        TimeUnit.SECONDS.sleep(3);
    }
}
