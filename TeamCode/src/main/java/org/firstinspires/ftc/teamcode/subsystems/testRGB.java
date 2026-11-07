package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import dev.nextftc.hardware.sensors.NextDigitalSensor;
import dev.nextftc.robot.Mechanism;

public class testRGB implements Mechanism {

    private NextDigitalSensor redLED = new NextDigitalSensor("red ");
    private DigitalChannel greenLED;

    public testRGB(HardwareMap hwmap) {
        redLED = hwmap.get(DigitalChannel.class, "red");
        greenLED = hwmap.get(DigitalChannel.class, "green");

        redLED.setMode(DigitalChannel.Mode.OUTPUT);
        greenLED.setMode(DigitalChannel.Mode.OUTPUT);
    }
    public Command turnRedOn() {
        redLED.setState(true);
    }

    public Command turnRedOff() {
        redLED.setState(false);
    }

    public Command turnGreenOn() {
        greenLED.setState(true);
        return null;
    }

    public Command turnGreenOff() {
        greenLED.setState(false);
    }
}
