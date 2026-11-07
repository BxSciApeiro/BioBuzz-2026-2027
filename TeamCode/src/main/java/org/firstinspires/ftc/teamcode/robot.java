package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.intake;
import org.firstinspires.ftc.teamcode.subsystems.shooter;
import org.firstinspires.ftc.teamcode.subsystems.slapDown;
import org.firstinspires.ftc.teamcode.subsystems.testRGB;
import org.firstinspires.ftc.teamcode.subsystems.transfer;

import java.util.Set;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;
import dev.nextftc.v2.pedro.PedroMechanism;

public class robot implements NextRobot {
    //// Add the mechanisms that MAKE the robot
    public slapDown slapdown = new slapDown();
    public shooter shooter = new shooter();
    public intake intake = new intake();
    public transfer transfer = new transfer();
    public testRGB testRGB = new testRGB()
    public PedroMechanism pedro = new PedroMechanism(Constants::create);

    /**
     * Creates a method that returns a set of all the mechanisms on our robot
     * @return {@link Set<Mechanism>} with all the subsystems on our bot
     */
    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(shooter);
    }
//    public Follower getFollower() {
////        if (follower == null) {
////            follower = Constants.createFollower()
////        }
//    }

}
