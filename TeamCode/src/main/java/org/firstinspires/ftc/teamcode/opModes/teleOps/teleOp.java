package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.commands.Commands;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.robot;
import dev.nextftc.robot.drive.DriveCommands;


import dev.nextftc.robot.Telemetry;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

@NextTeleop(name = "test")
public class teleOp extends NextOpMode {
    private final robot robot;
    private Follower follower;
    public teleOp(robot robot ) {
        super(robot);
        this.robot = robot;
    }

    @Override
    public void start() {
        follower = Constants.create(hardwareMap);

        Trigger.Companion.getDefaultEventLoop().clear();

        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        CommandGamepad gp2 = new CommandGamepad(gamepad2);

        gp1.leftBumper().onTrue(robot.getIntake().runIntake());
        gp1.rightBumper().onTrue(robot.getIntake().runBackwards());

        gp1.b().onTrue(robot.getShooter().testShoot());
        gp1.b().onFalse(robot.getShooter().testStop());

        gp1.a().toggleOnFalse(robot.getLocker().runLockingServo());
        gp1.a().toggleOnFalse(robot.getLocker().runLockingServo());

        gp2.a().toggleOnTrue(robot.getTransfer().turnOn());
        gp2.a().toggleOnFalse(robot.getTransfer().turnOff());

        gp2.y().toggleOnTrue(robot.getSlapdown().GoUp());
        gp2.x().toggleOnTrue(robot.getSlapdown().GoDown());

        robot.getDrivetrain().startDrive(gamepad1);

        DriveCommands.mecanumDriveFieldCentric(
                robot.getDrivetrain().frontLeft,
                robot.getDrivetrain().frontRight,
                robot.getDrivetrain().backLeft,
                robot.getDrivetrain().backRight,
                gamepad1,
                () -> follower.getPose().getHeading()
        ).schedule();

        gp2.leftBumper().whileTrue(
                Commands.infinite(() -> DriveCommands.setScalar(0.4))
                        .setEnd(end -> DriveCommands.setScalar(1.0))
        );



    }

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
    }
}
