package org.firstinspires.ftc.teamcode.subsystems;



import org.firstinspires.ftc.teamcode.subsystems.Constants.slapDownConstants;
import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop
public class slapDown implements Mechanism {
    private final NextServo slapDown = new NextServo("SlapDown");
    public Command GoUp(){
        return instant(() -> slapDown.setPosition(slapDownConstants.TopPos));
    }
    public Command GoDown(){
        return instant(()-> slapDown.setPosition(slapDownConstants.BottomPos));
    }
}
