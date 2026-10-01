package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.intake;
import org.firstinspires.ftc.teamcode.subsystems.lockingMechanism;

import org.firstinspires.ftc.teamcode.subsystems.shooter;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class robot implements NextRobot {
    shooter shooter = new shooter();
    intake intake = new intake();
    lockingMechanism locker = new lockingMechanism();
    public Follower follower;
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter, intake, locker);
    }

//    public Follower getFollower() {
////        if (follower == null) {
////            follower = Constants.createFollower()
////        }
//    }

}
