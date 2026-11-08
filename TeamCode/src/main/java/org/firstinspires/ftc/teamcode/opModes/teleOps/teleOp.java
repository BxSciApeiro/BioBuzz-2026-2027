package org.firstinspires.ftc.teamcode.opModes.teleOps;
import static com.pedropathing.ivy.commands.Commands.instant;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenkV;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.commands.Commands;

import org.firstinspires.ftc.teamcode.robot;
import org.firstinspires.ftc.teamcode.subsystems.Constants.slapDownConstants;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.drive.DriveCommands;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

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


        //// Transfer/Hopper system gamepad bindings
        gp2.leftBumper().toggleOnTrue(robot.transfer.turnOn());
        gp2.leftBumper().toggleOnFalse(robot.transfer.turnOff());

        //// Slap down mechanism gamepad bindings
        gp2.a().toggleOnTrue(robot.slapdown.GoUp());
        gp2.a().toggleOnFalse(robot.slapdown.GoDown());

        gp2.dpadLeft().toggleOnTrue(robot.testRGB.turnGreenOn());
        gp2.dpadLeft().toggleOnFalse(robot.testRGB.turnGreenOff());

        gp2.dpadRight().toggleOnTrue(robot.testRGB.turnRedOn());
        gp2.dpadRight().toggleOnFalse(robot.testRGB.turnRedOff());

        gp2.dpadUp().toggleOnTrue(robot.testRGB.turnYellowOn());
        gp2.dpadUp().toggleOnFalse(robot.testRGB.turnYellowOff());

        robot.pedro.follower().manual(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
        robot.pedro.follower().update();
        double distance = robot.pedro.follower().pose().y();
        robot.shooter.calculatePower(10);
    }
}
