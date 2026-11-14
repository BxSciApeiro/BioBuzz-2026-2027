package org.firstinspires.ftc.teamcode.opModes.teleOps;

import org.firstinspires.ftc.teamcode.robot;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

@SuppressWarnings("Class 'teleop' is never used")
@NextTeleop(name = "test")
public class teleOp extends NextOpMode {
    private final robot robot;

    public teleOp(robot robot ) {
        super(robot);
        this.robot = robot;
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
        gp1.rightBumper().onTrue(robot.shooter.testShoot());
        gp1.rightBumper().onFalse(robot.shooter.testStop());
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

        gp2.dpadLeft().toggleOnTrue(robot.rgb.turnGreenOn());
        gp2.dpadLeft().toggleOnFalse(robot.rgb.turnGreenOff());

        gp2.dpadRight().toggleOnTrue(robot.rgb.turnRedOn());
        gp2.dpadRight().toggleOnFalse(robot.rgb.turnRedOff());

        gp2.dpadUp().toggleOnTrue(robot.rgb.turnYellowOn());
        gp2.dpadUp().toggleOnFalse(robot.rgb.turnYellowOff());

        robot.pedro.follower().manual(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }

    @Override
    public void periodic() {
        Telemetry.update();
    }
}
