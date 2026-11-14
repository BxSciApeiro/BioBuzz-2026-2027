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

@NextAutonomous(name = "Put name of auto here")

public class AutoRRBB extends NextOpMode {
    private final robot robot;

    public AutoRRBB (robot robot) {
        super (robot);
        this.robot = robot;
    }
    public final fiveTiltRedG fiveTiltRedGarden = new fiveTiltRedG();
    public final fiveTiltRedL fiveTiltRedLoading = new fiveTiltRedL();
    public final fiveTiltBlueG fiveTiltBlueGarden = new fiveTiltBlueG();
    public final fiveTiltBlueL fiveTiltBlueLoading = new fiveTiltBlueL();

    public Command tiltRedGarden(){
        return sequential(
                follow(robot.pedro.follower(), fiveTiltRedGarden.path1()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path2()),
                robot.SITGroup.TakeNGo(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path3()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path4()),
                robot.SITGroup.TakeNGo(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path5()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path6()),
                robot.intake.runIntake(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path7()),
                robot.intake.stopIntake(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path8()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path9()),
                robot.intake.runIntake(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path10()),
                robot.intake.stopIntake(),
                follow(robot.pedro.follower(), fiveTiltRedGarden.path11()),
                robot.SITGroup.ShootNStop()
        );
    }
    public Command tiltBlueGarden(){
        return sequential(
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path1()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path2()),
                robot.SITGroup.TakeNGo(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path3()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path4()),
                robot.SITGroup.TakeNGo(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path5()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path6()),
                robot.intake.runIntake(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path7()),
                robot.intake.stopIntake(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path8()),
                robot.SITGroup.ShootNStop(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path9()),
                robot.intake.runIntake(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path10()),
                robot.intake.stopIntake(),
                follow(robot.pedro.follower(), fiveTiltBlueGarden.path11()),
                robot.SITGroup.ShootNStop()
        );
    }
    public Command tiltRedLoading(){
        return sequential(

        );
    }
    public Command tiltBlueLoading(){
        return sequential(

        );
    }
    @Override
    public void start() {
        ////IMPORTANT
        /*
         * Use whichever Command when we are using whichever side
         */
        //tiltRedGarden().schedule();
        //tiltBlueGarden().schedule();
        //tiltRedLoading().schedule();
        //tiltBlueLoading().schedule();
    }


}