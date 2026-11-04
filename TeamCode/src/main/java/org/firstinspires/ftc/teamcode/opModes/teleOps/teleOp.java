package org.firstinspires.ftc.teamcode.opModes.teleOps;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenkV;

import com.pedropathing.ivy.commands.Commands;

import org.firstinspires.ftc.teamcode.robot;

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
        gp1.leftBumper().onTrue(robot.intake.runIntake());
        gp1.rightBumper().onTrue(robot.intake.runBackwards());

        //// Shooting mechanism gamepad Bindings
        gp1.b().onTrue(robot.shooter.testShoot());
        gp1.b().onFalse(robot.shooter.testStop());


        //// Transfer/Hopper system gamepad bindings
        gp2.a().toggleOnTrue(robot.transfer.turnOn());
        gp2.a().toggleOnFalse(robot.transfer.turnOff());

        //// Slap down mechanism gamepad bindings
        gp2.y().toggleOnTrue(robot.slapdown.GoUp());
        gp2.x().toggleOnTrue(robot.slapdown.GoDown());

        robot.pedro.follower().manual(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        /*
        Total mechanisms listed: 6/6
         */


    }

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
        robot.pedro.follower().update();
        double distance = robot.pedro.follower().pose().y();
        robot.shooter.calculatePower(10);
    }
}
