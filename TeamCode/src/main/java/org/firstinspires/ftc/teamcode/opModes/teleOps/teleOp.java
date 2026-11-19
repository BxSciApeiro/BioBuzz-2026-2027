package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static java.lang.Math.atan2;

import org.firstinspires.ftc.teamcode.robot;
import org.firstinspires.ftc.teamcode.subsystems.COLORGroup;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;
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

        Math.atan2(yDiff, xDiff);
        return null;
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

        /// gamepad testing rgb light
        gp2.dpadLeft().toggleOnTrue(robot.getRGB().turnGreenOn());
        gp2.dpadLeft().toggleOnFalse(robot.getRGB().turnGreenOff());

        gp2.dpadRight().toggleOnTrue(robot.getRGB().turnRedOn());
        gp2.dpadRight().toggleOnFalse(robot.getRGB().turnRedOff());

        gp2.dpadUp().toggleOnTrue(robot.getRGB().turnYellowOn());
        gp2.dpadUp().toggleOnFalse(robot.getRGB().turnYellowOff());

        robot.pedro.follower().manual(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);



    }

    @Override
    public void periodic() {
        robot.COLORGroup.Display().schedule();
        Telemetry.update();
    }
}
