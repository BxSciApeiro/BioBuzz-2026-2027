package org.firstinspires.ftc.teamcode.opModes.autos;

import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
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

    public autoTemplate (robot robot) {
        super (robot);
        this.robot = robot;
    }

    // Copy all poses from pedro pathing vizualizer
    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(58.1419, 10.6774, 90);
    private final Pose path1 = poseFactory.of(58.3284, 51.7854, 180);
    private final Pose point2Start = poseFactory.of(58.3284, 51.7854, 90);
    private final Pose point2 = poseFactory.of(58.1622, 87.5037, 90);

    public Path path1() {
        return Paths.line(start, path1).linear(start, path1);
    }

    public Path path2() {
        return Paths.line(point2Start, point2).linear(point2Start, point2);
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
                robot.slapdown.GoDown(),
                waitMs(1000), //util commands like wait and instants are also provided
                robot.shooter.stop(),
                follow(robot.pedro.follower(), path2())
        );

        // Note if you are using a method from one of our classes that is NOT already a command you must do this:
        // instant(() -> robot.shooter.setPowerOff()
        // This will turn the given method into a runnable command
        auto.schedule();
    }


}
