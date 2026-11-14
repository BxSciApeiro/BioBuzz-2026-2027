package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;

import com.pedropathing.ivy.Command;

import dev.nextftc.robot.Mechanism;

public class SITGroup implements Mechanism {
    private final intake intake;
    private final shooter shooter;
    private final transfer transfer;

    private final slapDown slapDown;

    public SITGroup(intake intake, shooter shooter, transfer transfer, slapDown slapDown) {
        this.intake = intake;
        this.shooter = shooter;
        this.transfer = transfer;
        this.slapDown = slapDown;
    }
    public Command ShootSeq() {
        return sequential(
                shooter.shoot(),
                waitMs(1000),
                intake.runIntake(),
                transfer.turnOn(),
                waitMs(1000)
        );
    }
    public Command StopShoot() {
        return sequential(
                shooter.stop(),
                intake.stopIntake(),
                transfer.turnOff()
        );
    }
    public Command ShootNStop(){
        return sequential(
                this.ShootSeq(),
                this.StopShoot()
        );
    }
    public Command takeFromFlower(){
        return sequential(
                slapDown.GoDown(),
                intake.runIntake(),
                waitMs(1000)
        );
    }
    public Command ReverseTakeFromFlower(){
        return sequential(
                slapDown.GoUp(),
                intake.stopIntake()
        );
    }
    public Command TakeNGo(){
        return sequential(
                takeFromFlower(),
                ReverseTakeFromFlower()
        );
    }
}
