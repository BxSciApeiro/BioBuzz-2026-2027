package org.firstinspires.ftc.teamcode.opModes.teleOps;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop(name = "test")
public class teleOp extends NextOpMode {
    public teleOp(robot robot ) { super (robot );}

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
    }
}
