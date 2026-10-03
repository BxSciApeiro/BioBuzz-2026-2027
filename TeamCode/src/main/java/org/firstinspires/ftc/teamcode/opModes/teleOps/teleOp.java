package org.firstinspires.ftc.teamcode.opModes.teleOps;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

@NextTeleop(name = "test")
public class teleOp extends NextOpMode {
    private final robot robot;

    public teleOp(robot robot ) {
        super (robot );
        this.robot = robot;
    }

    @Override
    public void start() {
        Trigger.Companion.getDefaultEventLoop().clear();

        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        CommandGamepad gp2 = new CommandGamepad(gamepad2);

        gp1.leftBumper().onTrue(robot.getIntake().runIntake());
        gp1.rightBumper().onTrue(robot.getIntake().runBackwards());

        gp1.b().onTrue(robot.getShooter().testShoot());
        gp1.b().onFalse(robot.getShooter().testStop());

        gp1.a().toggleOnFalse(robot.getLocker().runLockingServo());
        gp1.a().toggleOnFalse(robot.getLocker().runLockingServo());


    }

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
    }
}
