package org.firstinspires.ftc.teamcode.opModes.teleOps;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "Testing Shooter, U should reupload to test others")
public class testingShooter extends NextOpMode {
    private final robot robot;

    public testingShooter(robot robot ) { super (robot);
        this.robot = robot ;}

    @Override
    public void start() {
        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        gp1.b().onTrue(robot.shooter.shoot());
        gp1.a().onTrue(robot.shooter.stop());

    }

    @Override
    public void periodic() {
        Telemetry.log("RUNNING");
    }
}