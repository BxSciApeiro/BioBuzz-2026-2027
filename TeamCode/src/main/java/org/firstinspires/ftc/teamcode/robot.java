package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.claw;
import org.firstinspires.ftc.teamcode.subsystems.shooter;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class robot implements NextRobot {
    public shooter shooter = new shooter();

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter);
    }
}
