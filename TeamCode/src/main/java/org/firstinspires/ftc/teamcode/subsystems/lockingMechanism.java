package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.lockingConstants.defaultPos;
import static org.firstinspires.ftc.teamcode.subsystems.lockingConstants.extendedPos;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop
public class lockingMechanism implements Mechanism {
    private NextServo lockingServo = new NextServo(RobotController.controlHub(), 0);

    public Command runLockingServo(){
        return instant(() -> lockingServo.setPosition(extendedPos));
    }

    public Command returnLockingServo(){
        return instant(() -> lockingServo.setPosition(defaultPos));
    }

}
