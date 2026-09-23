package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.claw;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class robot implements NextRobot {
    claw claw = new claw();

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(claw);
    }
}
