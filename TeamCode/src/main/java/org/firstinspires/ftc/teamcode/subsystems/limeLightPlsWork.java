package org.firstinspires.ftc.teamcode.subsystems;

import static dev.nextftc.units.Units.Inches;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import dev.nextftc.hardware.webcams.NextLimelight;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.units.measuretypes.Distance;

public class limeLightPlsWork implements Mechanism {
    private final NextLimelight limelight = new NextLimelight("limeLight");

    Distance distance = limelight.getDistance(Inches, 7);

    public boolean fartherThan(){
        return distance != null && distance.getMagnitude() >= 10.0;
    }

}
