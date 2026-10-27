package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

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
        super(robot);
        this.robot = robot;
    }

    @Override
    public void start() {
        Trigger.Companion.getDefaultEventLoop().clear();

        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        CommandGamepad gp2 = new CommandGamepad(gamepad2);

        gp1.leftBumper().onTrue(robot.getIntake().runIntake());
        gp1.rightBumper().onTrue(robot.getIntake().runBackwards());


        gp1.a().toggleOnFalse(robot.getLocker().runLockingServo());
        gp1.a().toggleOnFalse(robot.getLocker().runLockingServo());

        gp2.a().toggleOnTrue(robot.getTransfer().turnOn());
        gp2.a().toggleOnFalse(robot.getTransfer().turnOff());

        gp2.y().toggleOnTrue(robot.getSlapdown().GoUp());
        gp2.x().toggleOnTrue(robot.getSlapdown().GoDown());




    }

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
    }
}
