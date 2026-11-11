package org.firstinspires.ftc.teamcode.opModes.teleOps;

import static com.bylazar.telemetry.PanelsTelemetry.INSTANCE;
import static com.pedropathing.ivy.commands.Commands.instant;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.target;
import com.bylazar.telemetry.TelemetryManager;
import org.firstinspires.ftc.teamcode.robot;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;


@NextTeleop(name = "Testing Shooter, U should reupload to test others")
public class testingShooter extends NextOpMode {
    private final robot robot;
    public static TelemetryManager panelsT = INSTANCE.getTelemetry();


    public testingShooter(robot robot ) {
        super (robot);
        Trigger.Companion.getDefaultEventLoop().clear();
        this.robot = robot ;}

    @Override
    public void start() {
        CommandGamepad gp1 = new CommandGamepad(gamepad1);
        gp1.b().onTrue(instant(() -> robot.shooter.setVelocity(target)));
    }

    @Override
    public void periodic() {
        robot.shooter.setKp(pollenP);
        robot.shooter.setKd(pollenD);
        robot.shooter.setKv(pollenkV);
        panelsT.addData("shooter vel, ", robot.shooter.getEncoderVel());
        panelsT.addData("target", target);
        panelsT.update();
        Telemetry.log("RUNNING");
    }
}