package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.groups.Groups.parallel;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import dev.nextftc.hardware.sensors.NextDigitalSensor;
import dev.nextftc.robot.Mechanism;

public class testRGB implements Mechanism {

    private DigitalChannel redLED;
    private DigitalChannel greenLED;

    public testRGB(HardwareMap hwmap) {
        redLED = hwmap.get(DigitalChannel.class, "red");
        greenLED = hwmap.get(DigitalChannel.class, "green");

        redLED.setMode(DigitalChannel.Mode.OUTPUT);
        greenLED.setMode(DigitalChannel.Mode.OUTPUT);
    }
    public Command turnRedOn() {
        return instant(() -> redLED.setState(true));
    }

    public Command turnRedOff() {
        return instant(() -> redLED.setState(false));
    }

    public Command turnGreenOn() {
        return instant(() -> greenLED.setState(true));
    }

    public Command turnGreenOff() {
        return instant(() -> greenLED.setState(false));
    }

    public Command turnYellowOn() {
        return parallel(
                turnGreenOn(),
                turnRedOn()
        );
    }

    public Command turnYellowOff() {
        return parallel(
                turnGreenOff(),
                turnRedOff()
        );
    }
}
