package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.subsystems.intake;
import org.firstinspires.ftc.teamcode.subsystems.shooter;
import org.firstinspires.ftc.teamcode.subsystems.slapDown;
import org.firstinspires.ftc.teamcode.subsystems.transfer;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class robot implements NextRobot {
    public shooter shooter = new shooter();
    public intake intake = new intake();
    public Follower follower;
    public transfer transfer = new transfer();
    public slapDown slapdown = new slapDown();

    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter, intake, transfer, slapdown);
    }

//    public Follower getFollower() {
////        if (follower == null) {
////            follower = Constants.createFollower()
////        }
//    }

}
