package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.subsystems.Constants.transferConstants;

import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

@TeleOp
public class transfer implements Mechanism {
    private final NextCRServo geckoWheels = new NextCRServo("GeckoWheels");
    public Command turnOn(){
        return instant(() -> geckoWheels.setPower(transferConstants.MaxThrottle));
    }
    public Command turnOff(){
        return instant(() -> geckoWheels.setPower(transferConstants.turnOff));

    }
    public Command turnBack(){
        return instant(() -> geckoWheels.setPower(-(transferConstants.MaxThrottle)));
    }


}
