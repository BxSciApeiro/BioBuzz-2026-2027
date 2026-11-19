package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static com.bylazar.telemetry.PanelsTelemetry.INSTANCE;
import static com.pedropathing.ivy.commands.Commands.instant;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarTarget;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.target;

import com.bylazar.telemetry.TelemetryManager;

import org.firstinspires.ftc.teamcode.robot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

public class testingAShooter extends NextOpMode {
    private final robot robot;
    public static TelemetryManager panelsT = INSTANCE.getTelemetry();


    public testingAShooter(robot robot ) {
        super (robot);
        Trigger.Companion.getDefaultEventLoop().clear();
        this.robot = robot ;}

    @Override
    public void start() {
        CommandGamepad gp1 = new CommandGamepad(gamepad1);
    }

    @Override
    public void periodic() {
        (instant(() -> robot.aShooter.setVelocity(nectarTarget))).schedule();
        robot.aShooter.setKp(nectarP);
        robot.aShooter.setKd(nectarD);
        robot.aShooter.setKv(nectarkV);
        panelsT.addData("shooter vel, ", robot.aShooter.getEncoderVel());
        panelsT.addData("target", target);
        panelsT.update();
        Telemetry.log("RUNNING");
        Telemetry.update();
    }
}
