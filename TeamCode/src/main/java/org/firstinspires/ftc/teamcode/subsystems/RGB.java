package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.groups.Groups.parallel;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.LED;

import dev.nextftc.robot.Mechanism;

public class RGB implements Mechanism {

    private LED redLED;
    private LED greenLED;

    public RGB(HardwareMap hwmap) {
        redLED = hwmap.get(LED.class, "red");
        greenLED = hwmap.get(LED.class, "green");
    }
    public Command turnRedOn() {
        return instant(() -> redLED.on());
    }

    public Command turnRedOff() {
        return instant(() -> redLED.off());
    }

    public Command turnGreenOn() {
        return instant(() -> greenLED.on());
    }

    public Command turnGreenOff() {
        return instant(() -> greenLED.off());
    }

    public Command turnYellowOn() {
        return instant(() -> {
            greenLED.on();
            redLED.on();
        });
         /**       }
                turnGreenOn(),
                turnRedOn()
        );
        */
    }

    public Command turnYellowOff() {
        return parallel(
                turnGreenOff(),
                turnRedOff()
        );
    }

    public boolean getGreenState() {
        return greenLED.isLightOn();
    }

    public boolean getRedState() {
        return redLED.isLightOn();
    }
}
