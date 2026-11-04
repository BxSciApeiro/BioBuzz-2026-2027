package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

import dev.nextftc.robot.drive.DriveCommands;
import dev.nextftc.robot.opmode.NextTeleop;


@NextTeleop
public class Drivetrain implements Mechanism {
    //Pretty much all done by pedro-pathing (Commentator did not read)
    public final NextMotor frontLeft = new NextMotor("frontLeft");
    public final NextMotor frontRight = new NextMotor("frontRight");
    public final NextMotor backLeft = new NextMotor("backLeft");
    public final NextMotor backRight = new NextMotor("backRight");

    @Override
    public void periodic() {
        frontLeft.setDirection(NextMotor.Direction.REVERSE);
        backLeft.setDirection(NextMotor.Direction.REVERSE);
    }

    public void startDrive(Gamepad gamepad) {
        DriveCommands.mecanumDrive(frontLeft, frontRight, backLeft, backRight, gamepad).schedule();
    }
}