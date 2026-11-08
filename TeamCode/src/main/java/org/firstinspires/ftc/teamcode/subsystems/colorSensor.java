package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.hardware.sensors.NextColorDistanceSensor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;

public class colorSensor implements Mechanism {
    NextColorDistanceSensor colorSensor = new NextColorDistanceSensor("colorSensor");

    @Override
    public void periodic() {
        colorSensor.update();
        Telemetry.log("color: ", colorSensor.getColor());
        Telemetry.log("debug: ", colorSensor.debug());
        Telemetry.update();
    }
}
