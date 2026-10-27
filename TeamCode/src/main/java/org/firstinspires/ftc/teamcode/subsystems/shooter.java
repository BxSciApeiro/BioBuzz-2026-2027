package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.g;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.h;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.nectarkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.offVelocity;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.pollenkV;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.radius;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.ticksperrev;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.shooterConstant.tps;
import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextAutonomous;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

@NextTeleop
public class shooter implements Mechanism {
    public NextMotor pollenShooter = new NextMotor("pollenShooter");

    public NextMotor nectarShooter = new NextMotor("nectarShooter");

    //// Constructor that gets velocity constants
    public shooter() {
        pollenShooter.getVelocityConstants().withV(pollenkV);
        nectarShooter.getVelocityConstants().withV(nectarkV);
    }

    /**
     * Calculates ticks per second (probably calculates power)
     * @param distance
     */
    public void calculatePower(double distance) {
        double voy = Math.sqrt(2*g*h);
        double vox = (distance*g)/(Math.sqrt(2*g*h));

        double rotationalVelocity = Math.sqrt(Math.pow(voy,2)+Math.pow(vox, 2))*radius; //theta/s

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
    }

    /**
     * Creates a command to stop the shooter in testing
     * @return {@link Command} that sets shooter power to 0
     */
    public Command testStop() {
        return instant(() -> pollenShooter.setThrottle(0));
    }

}
