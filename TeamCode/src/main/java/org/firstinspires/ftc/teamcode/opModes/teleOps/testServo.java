package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static com.pedropathing.ivy.commands.Commands.instant;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

@SuppressWarnings("Class 'teleop' is never used")
@NextTeleop(name = "testServo")
public class testServo extends NextOpMode {
    private final robot robot;

    public testServo(robot robot) {
        super(robot);
        this.robot = robot;
    }
    @Override
    public void periodic() {
    }
    @Override
    public void start() {

        Trigger.Companion.getDefaultEventLoop().clear();

        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        CommandGamepad gp2 = new CommandGamepad(gamepad2);
        double value_y = gp1.leftStickY().getValue();
        robot.aShooter.adjustHoodtoPollen(value_y);
        instant(() -> telemetry.addLine("Value: for Ashooter: " + value_y)); //convert to String
        robot.aShooter.adjustHoodtoNectar(0.0);
        double value_x = gp1.rightStickX().getValue();
        robot.slapdown.TestGoUp(0.0);
        instant(()-> telemetry.addLine("Value for SlapDown: " + value_x));
        robot.slapdown.TestGoDown(value_x);


    }
}