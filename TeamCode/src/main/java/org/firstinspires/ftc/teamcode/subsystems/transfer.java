package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.subsystems.Constants.transferConstants;

import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop
public class transfer implements Mechanism {
    private final NextCRServo geckoWheels = new NextCRServo("GeckoWheels");

    /**
     * Turn on transfer mechanism (hopper)
     * @return Command
     */
    public Command turnOn(){
        return instant(() -> geckoWheels.setPower(transferConstants.MaxThrottle));
    }

    /**
     * Turn off transfer mechanism (hopper)
     * @return Command
     */
    public Command turnOff(){
        return instant(() -> geckoWheels.setPower(transferConstants.turnOff));

    }

    /**
     * Turn on transfer mechanism (run it backwards)
     * @return Command
     */
    public Command MoveBackwards(){
        return instant(() -> geckoWheels.setPower(-(transferConstants.MaxThrottle)));
    }


}
