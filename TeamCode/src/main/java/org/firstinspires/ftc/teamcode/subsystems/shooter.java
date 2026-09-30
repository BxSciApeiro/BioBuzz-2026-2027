package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.g;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.h;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.nectarkV;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.offVelocity;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.pollenkV;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.radius;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.ticksperrev;
import static org.firstinspires.ftc.teamcode.subsystems.shooterConstant.tps;
import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;
import kotlin.Unit;

public class shooter implements Mechanism {
    public NextMotor pollenShooter = new NextMotor("pollenShooter");

    public NextMotor nectarShooter = new NextMotor("nectarShooter");

    public shooter() {
        pollenShooter.getVelocityConstants().withV(pollenkV);
        nectarShooter.getVelocityConstants().withV(nectarkV);
    }

    public void calculatePower(double distance) {
        double voy = Math.sqrt(2*g*h);
        double vox = (distance*g)/(Math.sqrt(2*g*h));

        double rotationalVelocity = Math.sqrt(Math.pow(voy,2)+Math.pow(vox, 2))*radius; //theta/s

        tps = new AngularVelocity(rotationalVelocity * (ticksperrev/(2*(Math.PI))), Units.RadiansPerSecond);
    }

    public Command shoot() {
        return instant(() -> pollenShooter.setVelocitySetpoint(tps));
    }

    public Command stop() {
        return instant(() -> pollenShooter.setVelocitySetpoint(offVelocity));
    }

}
