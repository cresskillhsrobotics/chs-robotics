/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto6983-new", group="6983")

public class Auto6983_new extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware6983   robot           = new Hardware6983();              // Use a K9'shardware
    ElapsedTime time;

    @Override
    public void runOpMode() throws InterruptedException {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //turn launcher on
            robot.rightLauncher.setPower(1);
            robot.leftLauncher.setPower(1);

            //initalize gate
            robot.gate.setPosition(0.5);

            //bring platform up
            robot.string.setPower(0.5);
            robot.waitForTick(250);
            robot.string.setPower(0);

            // wait a half second
            robot.waitForTick(500);

            //bring platform down
            robot.string.setPower(-.5);
            robot.waitForTick(250);
            robot.string.setPower(0);

            // move servo out of way
            robot.gate.setPosition(30);
            //bring platform up

            robot.string.setPower(0.5);
            robot.waitForTick(250);
            robot.string.setPower(0);


            //stop



            robot.string.setPower(0);

            robot.rightLauncher.setPower(0);
            robot.leftLauncher.setPower(0);

            robot.waitForTick(29000);

            // Send telemetry message to signify robot running
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}
