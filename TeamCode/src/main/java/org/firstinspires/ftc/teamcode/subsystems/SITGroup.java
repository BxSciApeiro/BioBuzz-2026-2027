package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;

import com.pedropathing.ivy.Command;

import dev.nextftc.robot.Mechanism;

public class SITGroup implements Mechanism {
    private final intake intake;
    private final shooter shooter;
    private final transfer transfer;

    public SITGroup(intake intake, shooter shooter, transfer transfer) {
        this.intake = intake;
        this.shooter = shooter;
        this.transfer = transfer;
    }
    public Command ShootSeq() {
        return sequential(
                shooter.shoot(),
                waitMs(1000),
                intake.runIntake(),
                transfer.turnOn()
        );
    }
    public Command StopShoot() {
        return sequential(
                shooter.stop(),
                intake.stopIntake(),
                transfer.turnOff()
        );
    }
}
