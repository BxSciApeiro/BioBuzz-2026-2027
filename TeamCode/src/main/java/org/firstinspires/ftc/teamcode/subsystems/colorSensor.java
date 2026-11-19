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

    public float getHue() {
        return colorSensor.getHue();
    }

    public boolean redDetected(float hue) {
        double r = Math.abs(hue - 20);
        if(r <= 4){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean yellowDetected(float hue) {
        double y = Math.abs(hue- 100);
        if(y <= 3){
            return true;
        }
        else{
            return false;
        }
    }
}
