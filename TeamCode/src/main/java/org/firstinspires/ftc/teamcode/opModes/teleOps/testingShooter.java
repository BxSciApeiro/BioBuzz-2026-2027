package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static com.bylazar.telemetry.PanelsTelemetry.INSTANCE;
import static com.pedropathing.ivy.commands.Commands.instant;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.target;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.tps;

import com.bylazar.telemetry.TelemetryManager;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.BulkReadHook;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

@NextTeleop(name = "Testing Shooter, U should reupload to test others")
public class testingShooter extends NextOpMode {
    private final robot robot;
    public static TelemetryManager panelsT = INSTANCE.getTelemetry();


    public testingShooter(robot robot ) { super (robot, BulkReadHook.INSTANCE);
        this.robot = robot ;}

    @Override
    public void start() {
        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        gp1.square().toggleOnTrue(instant(() -> robot.shooter.setVelocity(target)));
        gp1.square().toggleOnFalse(instant(() -> robot.shooter.setVelocity(0)));
    }

    @Override
    public void periodic() {
        panelsT.addData("shooter vel, ", robot.shooter.getEncoderVel());
        panelsT.addData("target", target);
        panelsT.update();
        Telemetry.log("RUNNING");
    }
}