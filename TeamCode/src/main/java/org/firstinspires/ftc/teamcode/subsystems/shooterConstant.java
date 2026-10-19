package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

public class shooterConstant {
    public static double pollenkV = 0.5;
    public static double nectarkV = 0.5;
    public static double g = 386.089; // gravational constant in inches
    public static double h = 61.5; //height of goal in inches
    public static double radius = 1.41732; // in inches
    public static double ticksperrev;
    public static AngularVelocity tps;
    public static AngularVelocity offVelocity = new AngularVelocity(0, Units.RadiansPerSecond);
}
