package org.firstinspires.ftc.teamcode.subsystems.Constants;

import com.bylazar.configurables.annotations.Configurable;

import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.Angle;
import dev.nextftc.units.measuretypes.AngularVelocity;

@Configurable
public class shooterConstant {
    public static double pollenkV = 0.2;
    public static double nectarkV = 0.5;
    public static double g = 386.089; // gravational constant in inches
    public static double h = 61.5; //height of goal in inches
    public static double radius = 1.41732; // in inches
    public static double ticksperrev = 26;
    public static Angle anglePerCount = new Angle(4.13802852039, Units.Radians); // ticksperrev/2pi to get radians per tick
    public static AngularVelocity offVelocity = new AngularVelocity(0, Units.RadiansPerSecond);
    public static double pollenP = 0.001;
    public static double pollenD = 0;
    public static double target;
    public static AngularVelocity tps = new AngularVelocity(target, Units.RadiansPerSecond);

}
