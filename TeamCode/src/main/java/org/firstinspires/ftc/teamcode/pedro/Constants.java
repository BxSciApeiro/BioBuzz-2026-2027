package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Localizer;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {

    public static MecanumConfig driveConfig = new MecanumConfig(
            c-> {
                c.frontLeftName.set("frontLeft");
                c.frontRightName.set("frontRight");
                c.backLeftName.set("backLeft");
                c.backRightName.set("backRight");
                c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
                c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
                c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
                c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);

            }
    );

    public static PinpointConfig localizerConfig = new PinpointConfig( c-> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
        c.xPodOffset.set(5.025694);
        c.yPodOffset.set(5.58243819);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    }
    );

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(-393.7333825851661);
                Controller secondaryTranslationalForward = Controller.proportional(-145.4739641154728);
                Controller primaryTranslationalLateral = Controller.proportional(0.24398104284661773);
                Controller secondaryTranslationalLateral = Controller.proportional(0.09014447603829284);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(1.2056497926452237));
                c.brake.set(Controller.proportionalFeedforward(1.02480232374844));

                c.headingFeedback.set(Controller.proportional(4.637688576641624));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.05834341428436349, 0.006659419035680444));

                c.linearBrakeCoefficients.set(Matrix.diag(0.688732565612808, 0.07026846547057572));
                c.quadraticBrakeCoefficients.set(Matrix.diag(-0.019386167340810716, 0.0010564101142121348));

                c.maxAchievableForwardVelocity.set(33.31166223844714);
                c.maxAchievableStrafeVelocity.set(49.51861239954309);
                c.naturalForwardDeceleration.set(85.06344298329797);
                c.naturalStrafeDeceleration.set(88.72697405154616);
            }
    );

    public static Follower create(HardwareMap h) {
        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, driveConfig),
                new Foresight(foresightConfig)

        );
    }



}