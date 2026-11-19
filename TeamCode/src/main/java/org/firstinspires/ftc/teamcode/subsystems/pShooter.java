package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.*;
import com.pedropathing.ivy.Command;

import java.util.Map;
import java.util.TreeMap;

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

    public NextMotor nectarShooter = new NextMotor("nectarShooter");

    //// Constructor that gets velocity constants
    public pShooter() {
        pollenShooter.getVelocityConstants().withV(pollenkV).withP(pollenP).withD(pollenD);
        nectarShooter.getVelocityConstants().withV(nectarkV);
    }

    /**
     * Calculates ticks per second (probably calculates power)
     * @param distance
     */
    public void calculatePower(double distance) {
        double voy = Math.sqrt(2*g*h); //inches/s
        double vox = (distance*g)/(Math.sqrt(2*g*h)); // inches /s

        double rotationalVelocity = (Math.sqrt(Math.pow(voy,2)+Math.pow(vox, 2)))/radius; //theta/s

        tps = new AngularVelocity(rotationalVelocity, Units.RadiansPerSecond);
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

    public void setVelocity(double vel) {
        pollenShooter.setVelocitySetpoint(new AngularVelocity(vel, Units.RadiansPerSecond));
    }

    /**
     * Creates a command to stop the shooter in testing
     * @return {@link Command} that sets shooter power to 0
     */

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
        //7150 target
//        pollenShooter.getVelocityConstants().setKV(pollenkV);
//        pollenShooter.getVelocityConstants().setKP(pollenP);
//        pollenShooter.getVelocityConstants().setKD(pollenD);
        pollenShooter.update();

        //Here I should make interpolate RPM constantly feed into a double
        // then, make the gamepad an instant
//        Telemetry.log("Interpolated RPM w distance 10, should ouput -25", interpolateRPM(10));
//        Telemetry.log("Interpolated TOF w distance 10, should ouput 24.85", interpolateTOF(10));

    }

    public double interpolateRPM(double distance) {
        InterpolatingMap<Double> RPMinterpolator = InterpolatingMap.linear();
        RPMinterpolator.put(0.0, 100.0);
        RPMinterpolator.put(4.0, 50.0);
        RPMinterpolator.put(11.0, 10.0);
        return RPMinterpolator.get(distance);
    }

    public double interpolateTOF(double distance) {
        InterpolatingMap<Double> TOFInterpolator = InterpolatingMap.linear();
        TOFInterpolator.put(0.0, 0.1);
        TOFInterpolator.put(4.0, 10.0);
        TOFInterpolator.put(11.0, 100.0);
        return TOFInterpolator.get(distance);
    }

}
