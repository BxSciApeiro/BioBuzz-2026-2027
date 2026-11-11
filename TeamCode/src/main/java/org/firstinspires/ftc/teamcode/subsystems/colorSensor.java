package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.hardware.sensors.NextColorDistanceSensor;
import dev.nextftc.hardware.sensors.colors.NextColor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;

public class colorSensor implements Mechanism {
    NextColorDistanceSensor colorSensor = new NextColorDistanceSensor("colorSensor");
    NextColor previousColor;
    int counter;
    @Override
    public void periodic() {
//        NextColor currentColor = colorSensor.getColor();
//        if (previousColor != currentColor) {
//            counter = counter+1;
//            previousColor = currentColor;
//        }
        colorSensor.update();

        Telemetry.log("color: ", colorSensor.getColor());
        Telemetry.log("debug: ", colorSensor.debug());
    }
}
