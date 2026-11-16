package org.firstinspires.ftc.teamcode.subsystems;


import static com.pedropathing.ivy.groups.Groups.parallel;

import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarTPS;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.offVelocity;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenD;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenP;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.tps;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class aShooter implements Mechanism {
    public enum PIDType {
        POLLEN,
        NECTAR
    }
    private final NextMotor adjustableShooter = new NextMotor("nectarShooter");
    private final NextServo adjust = new NextServo("ServoAdjust");

    private final double pollenPos = 0.0, nectarPos = 1.0, ThrottleNone = 0.0, setNThrottle = 1.0, setPThrottle = 0.7;

    public void setPID (PIDType pidtype) {
        switch(pidtype) {
            case POLLEN:
                adjustableShooter.getVelocityConstants().setKP(pollenP);
                adjustableShooter.getVelocityConstants().setKD(pollenD);
                adjustableShooter.getVelocityConstants().setKV(pollenkV);
                break;
            case NECTAR:
                adjustableShooter.getVelocityConstants().setKV(nectarkV);
                adjustableShooter.getVelocityConstants().setKP(nectarP);
                adjustableShooter.getVelocityConstants().setKD(nectarD);
        }
    }
    public Command adjustToPollen(){
        return parallel(
                instant(() -> setPID(PIDType.POLLEN)),
                instant(()-> adjust.setPosition(pollenPos))
        );
    }
    public Command adjustToNectar(){
        return parallel(
                instant(() -> setPID(PIDType.NECTAR)),
                instant(()-> adjust.setPosition(nectarPos))
        );
    }

    public Command shootNShooter(){
        return instant(()->adjustableShooter.setVelocitySetpoint(nectarTPS));
    }
    public Command shootPShooter(){
        return instant(()-> adjustableShooter.setVelocitySetpoint(tps));
    }
    public Command stopAdjustShooter(){
        return instant(()->adjustableShooter.setVelocitySetpoint(offVelocity));
    }

}
