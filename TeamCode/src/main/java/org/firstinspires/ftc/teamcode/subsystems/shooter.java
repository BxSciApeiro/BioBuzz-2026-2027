package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.*;
import com.pedropathing.ivy.Command;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

public class shooter implements Mechanism {
    public NextMotor pollenShooter = new NextMotor("pollenShooter", anglePerCount);

    public NextMotor nectarShooter = new NextMotor("nectarShooter");

    public shooter() {
        pollenShooter.getVelocityConstants().withV(pollenkV).withP(pollenP).withD(pollenD);
        nectarShooter.getVelocityConstants().withV(nectarkV);
    }

    public void calculatePower(double distance) {
        double voy = Math.sqrt(2*g*h); //inches/s
        double vox = (distance*g)/(Math.sqrt(2*g*h)); // inches /s

        double rotationalVelocity = (Math.sqrt(Math.pow(voy,2)+Math.pow(vox, 2)))/radius; //theta/s

        tps = new AngularVelocity(rotationalVelocity * (ticksperrev/(2*(Math.PI))), Units.RadiansPerSecond);
    }

    public Command shoot() {
        return instant(() -> pollenShooter.setVelocitySetpoint(tps));
    }

    public Command stop() {
        return instant(() -> pollenShooter.setVelocitySetpoint(offVelocity));
    }

    public void setVelocity(double vel) {
        pollenShooter.setVelocitySetpoint(new AngularVelocity(vel, Units.RadiansPerSecond));
    }


    public double getEncoderVel() {
        return pollenShooter.getEncoderVelocity().getMagnitude();
    }

    @Override
    public void periodic() {
        pollenShooter.getVelocityConstants().setKV(pollenkV);
        pollenShooter.getVelocityConstants().setKP(pollenP);
        pollenShooter.getVelocityConstants().setKD(pollenD);
        pollenShooter.update();
        Telemetry.log("shooter vel", pollenShooter.getEncoderVelocity());
        Telemetry.log("tps", tps.getMagnitude());
        Telemetry.update();
    }

}
