package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static com.pedropathing.ivy.commands.Commands.instant;
import static java.lang.Math.atan2;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.robot;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

import com.pedropathing.follower.ManualDrive;
import com.pedropathing.ivy.Command;

@SuppressWarnings("Class 'teleop' is never used")
@NextTeleop(name = "test")
public class teleOp extends NextOpMode {
    private final robot robot;

    public teleOp(robot robot ) {
        super(robot);
        this.robot = robot;
    }
    public Command autoAlign(){
        double yPos = robot.pedro.follower().pose().y(), xPos = robot.pedro.follower().pose().x();
        double xTarget = 0.0, yTarget = 0.0;

        if (yPos > 70.8){
            yTarget = 84.8;
        }else {
            yTarget = 56.8;
        }
        if (xPos > 70.8){
            xTarget = 84.8;
        } else {
            xTarget = 57.8;
        }
        double xDiff = xPos - xTarget;
        double yDiff = yPos - yTarget;
        double radians = Math.atan2(yDiff, xDiff);
        /* nRadians1 is supposed to stand for normalizedRadians1 and nRadians2
        stands for normalizedRadians2
        As of right now if I am correct I think nRadians2 is correct because a circle is 360 degrees
        so dividing it should be correct. I might be wrong because it should theoretically return
        180 or -180 because that would be the fastest way to turn the bot and not over 180 or below -180
        so dividing by 180 could also theoretically work? Not to sure -> Trial and error
         */
        double nRadians1 = radians/180;
        double nRadians2 = radians/360;
        return instant(()-> robot.pedro.follower().manual(nRadians2,nRadians2,nRadians2));

        ManualDrive.headingLock(
                robot.pedro.follower(),
                Constants.foresightConfig.headingFeedback,

             radians
        );
    }

    @Override
    public void start() {
        Trigger.Companion.getDefaultEventLoop().clear();

        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        CommandGamepad gp2 = new CommandGamepad(gamepad2);

        //// Intake mechanism gamepad Bindings
        gp1.leftTrigger().isBetween(0.70, 1).toggleOnTrue(robot.intake.runIntake());
        gp1.rightTrigger().isBetween(0.70, 1).toggleOnTrue(robot.intake.runBackwards());
        gp1.leftTrigger().isBetween(0.0, 0.69).toggleOnTrue(robot.intake.stopIntake());
        gp1.rightTrigger().isBetween(0.0, 0.69).toggleOnTrue(robot.intake.stopIntake());

        //// Shooting mechanism gamepad Bindings
        gp2.dpadLeft().toggleOnTrue(robot.aShooter.adjustToPollen());
        gp2.dpadRight().toggleOnTrue(robot.aShooter.adjustToNectar());
        gp2.dpadUp().toggleOnTrue(robot.aShooter.shootPShooter());
        gp2.dpadDown().toggleOnTrue(robot.aShooter.shootNShooter());
        gp2.leftBumper().toggleOnTrue(robot.aShooter.stopAdjustShooter());

        //// Transfer/Hopper system gamepad bindings
        gp2.leftBumper().toggleOnTrue(robot.transfer.turnOn());
        gp2.leftBumper().toggleOnFalse(robot.transfer.turnOff());
        gp1.dpadRight().toggleOnTrue(robot.aShooter.adjustToNectar());
        gp1.dpadLeft().toggleOnTrue(robot.aShooter.adjustToPollen());
        gp1.dpadUp().toggleOnTrue(robot.aShooter.shootNShooter());
        gp1.dpadDown().toggleOnTrue(robot.aShooter.stopAdjustShooter());
        gp2.leftBumper().toggleOnTrue(robot.aShooter.shootPShooter());

        //// Slap down mechanism gamepad bindings
        gp2.a().toggleOnTrue(robot.slapdown.GoUp());
        gp2.a().toggleOnFalse(robot.slapdown.GoDown());

        gp2.dpadLeft().whileTrue(robot.getRGB().turnGreenOn());
        gp2.dpadLeft().onFalse(robot.getRGB().turnGreenOff());

        gp2.dpadRight().whileTrue(robot.getRGB().turnRedOn());
        gp2.dpadRight().onFalse(robot.getRGB().turnRedOff());

        gp2.dpadUp().whileTrue(robot.getRGB().turnYellowOn());
        gp2.dpadUp().onFalse(robot.getRGB().turnYellowOff());

        robot.pedro.follower().manual(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }

    @Override
    public void periodic() {
        robot.COLORGroup.Display().schedule();
        Telemetry.log("green state, " , robot.getRGB().getGreenState());
        Telemetry.log("red state", robot.getRGB().getRedState());
        Telemetry.update();
    }
}
