package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.Constants.lockingConstants.defaultPos;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.lockingConstants.extendedPos;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop
public class lockingMechanism implements Mechanism {
    private NextServo lockingServo = new NextServo("Locking Servo");

    /**
     * Creates a command that extends the rack and pinion
     * @return {@link Command} that sets the position to extend the rack and pinion
     */
    public Command runLockingServo(){
        return instant(() -> lockingServo.setPosition(extendedPos));
    }

    /**
     * Creates a command that retrieves the rack and pinion
     * @return {@link Command} that sets the position to retrieve the rack and pinion
     */
    public Command returnLockingServo(){
        return instant(() -> lockingServo.setPosition(defaultPos));
    }

}
