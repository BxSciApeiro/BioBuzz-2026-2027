package org.firstinspires.ftc.teamcode.opModes.autos;


import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.commands.Commands.waitUntil;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.ivy.Command;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.robot;
import org.firstinspires.ftc.teamcode.subsystems.SITGroup;

import dev.nextftc.robot.opmode.NextAutonomous;
import dev.nextftc.robot.opmode.NextOpMode;
@NextAutonomous(name = "Testing Lime light")

// you would replace "autoTemplate" with the name of your auto
// here it may be smarter to do something shorter, as this name isnt displayed
public class testLimeLight extends NextOpMode {
    private final robot robot;

    private static final ElapsedTime timer = new ElapsedTime();

    public boolean TTiming, TDistance;

    public testLimeLight (robot robot) {
        super (robot);
        this.robot = robot;

        boolean TTiming = timer.seconds() <= 5, TDistance = robot.limeLight.fartherThan();
        this.TTiming =TTiming;
        this.TDistance = TDistance;

    }


    // Copy all poses from pedro pathing vizualizer


    @Override
    public void start() {
        timer.reset();
        Command auto;
        // If interested, someone may also consider creating a file with all
        // commands that are repeated in auto. Ex) in a new file create a shoot command
        // that turns on the shooter, turns on the transfer, waits, and then turns it off.
        // Create auto commands. Here, sequential is used which runs each command one after another
        // The opposite of this would be parallel, which runs each command simultaneously
        if (TTiming && TDistance) {
            auto = sequential(
                    robot.SITGroup.ShootNStop()
            );
        } else if (!TTiming && TDistance){
            auto = sequential(
                    instant(() ->telemetry.addLine("Time Ran Out"))
            );
        } else if (TTiming && !TDistance){
            auto = sequential(
                    instant(() ->telemetry.addLine("GO GO GO!"))
            );
        } else {
            auto = sequential(
                   instant(() ->telemetry.addLine("Time Ran Out and Distance was not Reached!"))
            );
        }

        // Note if you are using a method from one of our classes that is NOT already a command you must do this:
        // instant(() -> robot.shooter.setPowerOff()
        // This will turn the given method into a runnable command
        auto.schedule();
    }
    @Override
    public void periodic(){
        TTiming = timer.seconds() <= 5;
        TDistance = robot.limeLight.fartherThan();
    }


}