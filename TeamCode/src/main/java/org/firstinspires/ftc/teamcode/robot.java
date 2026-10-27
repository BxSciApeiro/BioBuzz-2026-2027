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
    //// Add the mechanisms that MAKE the robot
    shooter shooter = new shooter();
    intake intake = new intake();
    lockingMechanism locker = new lockingMechanism();

    transfer Transfer = new transfer();

    slapDown slapdown = new slapDown();

    Drivetrain drivetrain = new Drivetrain();

    public Follower follower;
    public transfer transfer = new transfer();
    public slapDown slapdown = new slapDown();

    /**
     * Creates a method that returns a set of all the mechanisms on our robot
     * @return {@link Set<Mechanism>} with all the subsystems on our bot
     */
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter, intake, locker, slapdown,Transfer, drivetrain );
    }

    //// Allow other classes (most definitely TeleOp) to access the mechanisms/robot and use the robot.
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
