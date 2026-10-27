package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.*;
import com.pedropathing.ivy.Command;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

@NextTeleop
public class shooter implements Mechanism {
    public NextMotor pollenShooter = new NextMotor("pollenShooter", anglePerCount);

    public NextMotor nectarShooter = new NextMotor("nectarShooter");

    //// Constructor that gets velocity constants
    public shooter() {
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

        tps = new AngularVelocity(rotationalVelocity * (ticksperrev/(2*(Math.PI))), Units.RadiansPerSecond);
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
        return instant(() -> pollenShooter.setThrottle(0.5));
    public void setVelocity(double vel) {
        pollenShooter.setVelocitySetpoint(new AngularVelocity(vel, Units.RadiansPerSecond));
    }

    /**
     * Creates a command to stop the shooter in testing
     * @return {@link Command} that sets shooter power to 0
     */
    public Command testStop() {
        return instant(() -> pollenShooter.setThrottle(0));


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
