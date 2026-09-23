package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class claw implements Mechanism {
    NextServo claw = new NextServo("claw");

    @Override
    public void periodic() {
        claw.setPosition(1);
    }
}
