package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by harry on 2017-02-20.
 */

@Autonomous(name="Wheeee", group="8485")
public class Fun extends LinearOpMode {

    ColorSensor colorSensor;

    public void runOpMode() throws InterruptedException {
        colorSensor = hardwareMap.colorSensor.get("clr");
        colorSensor.enableLed(false);

        waitForStart();

        while(true) {
            telemetry.addData("Red", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue", colorSensor.blue());

            telemetry.update();
        }
    }
}
