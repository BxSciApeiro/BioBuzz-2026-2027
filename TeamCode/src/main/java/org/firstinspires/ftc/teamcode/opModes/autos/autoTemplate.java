package org.firstinspires.ftc.teamcode.opModes.autos;

import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.ivy.Command;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.opmode.NextAutonomous;
import dev.nextftc.robot.opmode.NextOpMode;

@Disabled //Delete this when you make your code: this is just so te template is not loaded onto the robot
// this name is the one that will be displaced on our driver hub
// thus make sure your name is descriptive
@NextAutonomous(name = "Put name of auto here")

// you would replace "autoTemplate" with the name of your auto
// here it may be smarter to do something shorter, as this name isnt displayed
public class autoTemplate extends NextOpMode {
    private final robot robot;

    public autoTemplate(robot robot) {
        super (robot);
        this.robot = robot;
    }

    // Copy all poses from pedro pathing vizualizer
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(119.7767, 10.0339, 90);
    private final Pose path1 = poseFactory.of(83.6027, 23.2156, 90);
    private final Pose point2 = poseFactory.of(117.8338, 37.0067, 90);
    private final Pose point3Start = poseFactory.of(117.8338, 37.0067, 0);
    private final Pose point3 = poseFactory.of(120.0999, 9.7869, 2990);
    private final Pose point4Start = poseFactory.of(120.0999, 9.7869, 0);
    private final Pose point4 = poseFactory.of(78.9293, 12.5195, 180);
    private final Pose point5Start = poseFactory.of(78.9293, 12.5195, 0);
    private final Pose point5 = poseFactory.of(78.4292, 34.1679, 90);
    private final Pose point6Start = poseFactory.of(78.4292, 34.1679, 90);
    private final Pose point6 = poseFactory.of(118.6202, 94.6457, 90);
    private final Pose point6Control1 = poseFactory.of(126.9723, 8.6799, 0);
    private final Pose point7Start = poseFactory.of(118.6202, 94.6457, 0);
    private final Pose point7 = poseFactory.of(82.5175, 118.1104, 270);
    private final Pose point7Control1 = poseFactory.of(111.4657, 119.6788, 0);
    private final Pose point8 = poseFactory.of(47.048, 139.0143, -30.513);
    private final Pose point9Start = poseFactory.of(47.048, 139.0143, 0);
    private final Pose point9 = poseFactory.of(82.2853, 118.5233, 90);
    private final Pose point10 = poseFactory.of(130.7867, 33.6929, 93.9071);
    private final Pose point10Control1 = poseFactory.of(124.9195, 119.5996, 0);

    public Path path1() {
        return Paths.line(start, path1).constant(path1);
    }

    public Path path2() {
        return Paths.line(path1, point2).constant(point2);
    }

    public Path path3() {
        return Paths.line(point3Start, point3).linear(point3Start, point3);
    }

    public Path path4() {
        return Paths.line(point4Start, point4).linear(point4Start, point4);
    }

    public Path path5() {
        return Paths.line(point5Start, point5).linear(point5Start, point5);
    }

    public Path path6() {
        return Paths.curve(point6Start, point6Control1, point6).linear(point6Start, point6);
    }

    public Path path7() {
        return Paths.curve(point7Start, point7Control1, point7).linear(point7Start, point7);
    }

    public Path path8() {
        return Paths.line(point7, point8).reverseTangent();
    }

    public Path path9() {
        return Paths.line(point9Start, point9).linear(point9Start, point9);
    }

    public Path path10() {
        return Paths.curve(point9, point10Control1, point10).reverseTangent();
    }


    @Override
    public void start() {

        // If interested, someone may also consider creating a file with all
        // commands that are repeated in auto. Ex) in a new file create a shoot command
        // that turns on the shooter, turns on the transfer, waits, and then turns it off.

        // Create auto commands. Here, sequential is used which runs each command one after another
        // The opposite of this would be parallel, which runs each command simultaneously
        Command auto = sequential(
                follow(robot.pedro.follower(), path1()), //use follow command to make the robot follow the path you made
                robot.shooter.shoot(), //use our commands we made to shoot/intake/transfer
                waitMs(1000), //util commands like wait and instants are also provided
                parallel(
                        robot.intake.runIntake(),
                        robot.transfer.turnOn()
                ),
                waitMs(1000), //util commands like wait and instants are also provided
                parallel(
                        robot.intake.stopIntake(),
                        robot.transfer.turnOff(),
                        robot.shooter.stop()
                ),
                follow(robot.pedro.follower(), path2()),
                follow(robot.pedro.follower(), path3()),
                follow(robot.pedro.follower(), path4()),
                follow(robot.pedro.follower(), path5()),
                follow(robot.pedro.follower(), path6()),
                follow(robot.pedro.follower(), path7()),
                follow(robot.pedro.follower(), path8()),
                robot.shooter.shoot(), //use our commands we made to shoot/intake/transfer
                waitMs(1000), //util commands like wait and instants are also provided
                parallel(
                        robot.intake.runIntake(),
                        robot.transfer.turnOn()
                ),
                waitMs(1000), //util commands like wait and instants are also provided
                parallel(
                        robot.intake.stopIntake(),
                        robot.transfer.turnOff(),
                        robot.shooter.stop()
                ),
                follow(robot.pedro.follower(), path9()),
                follow(robot.pedro.follower(), path10())
        );

        // Note if you are using a method from one of our classes that is NOT already a command you must do this:
        // instant(() -> robot.shooter.setPowerOff()
        // This will turn the given method into a runnable command
        auto.schedule();
    }


}
