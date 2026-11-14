package org.firstinspires.ftc.teamcode.subsystems;


import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class aShooter implements Mechanism {
    private final NextMotor adjustableShooter = new NextMotor("nectarShooter");
    private final NextServo adjust = new NextServo("ServoAdjust");

    private final double pollenPos = 0.0, nectarPos = 1.0, ThrottleNone = 0.0, setNThrottle = 1.0, setPThrottle = 0.7;

    public Command adjustToPollen(){
        return instant(()-> adjust.setPosition(pollenPos));
    }
    public Command adjustToNectar(){
        return instant(()-> adjust.setPosition(nectarPos));
    }

    public Command shootNShooter(){
        return instant(()->adjustableShooter.setThrottle(setNThrottle));
    }
    public Command shootPShooter(){
        return instant(()-> adjustableShooter.setThrottle(setPThrottle));
    }
    public Command stopAdjustShooter(){
        return instant(()->adjustableShooter.setThrottle(ThrottleNone));
    }

}
