package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.intake;
import org.firstinspires.ftc.teamcode.subsystems.lockingMechanism;

import org.firstinspires.ftc.teamcode.subsystems.shooter;
import org.firstinspires.ftc.teamcode.subsystems.slapDown;
import org.firstinspires.ftc.teamcode.subsystems.transfer;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class robot implements NextRobot {
    shooter shooter = new shooter();
    intake intake = new intake();
    lockingMechanism locker = new lockingMechanism();

    transfer Transfer = new transfer();

    slapDown slapdown = new slapDown();

    Drivetrain drivetrain = new Drivetrain();

    public Follower follower;

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter, intake, locker, slapdown,Transfer, drivetrain );
    }

    public intake getIntake() {
        return intake;
    }
    public shooter getShooter() {
        return shooter;
    }
    public lockingMechanism getLocker() {
        return locker;
    }
    public transfer getTransfer(){return Transfer;}
    public slapDown getSlapdown(){return slapdown;}


    public Drivetrain getDrivetrain(){return drivetrain;}
//    public Follower getFollower() {
////        if (follower == null) {
////            follower = Constants.createFollower()
////        }
//    }

}
