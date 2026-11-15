package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.*;
import com.pedropathing.ivy.Command;

import dev.nextftc.control.util.InterpolatingMap;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

@NextTeleop
public class pShooter implements Mechanism {
    public NextMotor pollenShooter = new NextMotor("pollenShooter", anglePerCount);

    //// Constructor that gets velocity constants
    public pShooter() {
        pollenShooter.getVelocityConstants().withV(pollenkV).withP(pollenP).withD(pollenD);
    }

    /**
     * Shoots Pollen Shooter
     * @return shooting command
     */
    public Command shoot() {
        return instant(() -> pollenShooter.setVelocitySetpoint(tps));
    }

    /**
     * Stops Pollen Shooter from shooting
     * @return stops Shooter command
     */
    public Command stop() {
        return instant(() -> pollenShooter.setVelocitySetpoint(offVelocity));
    }

    /**
     * A command for testing the shooter
     * @return test shooting command
     */
    public Command testShoot() {
        return instant(() -> pollenShooter.setThrottle(0.75));
    }

    public void setVelocity(double vel) {
        pollenShooter.setVelocitySetpoint(new AngularVelocity(vel, Units.RadiansPerSecond));
    }

    /**
     * Creates a command to stop the shooter in testing
     * @return {@link Command} that sets shooter power to 0
     */
    public Command testStop() {
            return instant(() -> pollenShooter.setThrottle(0));
    }

    public double getEncoderVel() {
        return pollenShooter.getEncoderVelocity().getMagnitude();
    }

    public void setKv(double val) {
        pollenShooter.getVelocityConstants().setKV(val);

    }
    public void setKp (double val) {
        pollenShooter.getVelocityConstants().setKP(val);
    }

    public void setKd(double val) {
        pollenShooter.getVelocityConstants().setKD(val);
    }

    @Override
    public void periodic() {
        pollenShooter.update();
        Telemetry.log("shooter vel", pollenShooter.getEncoderVelocity());
        Telemetry.log("tps", tps.getMagnitude());
    }

}
