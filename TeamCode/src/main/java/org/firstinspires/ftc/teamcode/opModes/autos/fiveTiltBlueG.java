package org.firstinspires.ftc.teamcode.opModes.autos;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class fiveTiltBlueG {
    private  PoseFactory poseFactory = PoseFactory.degrees();
    public fiveTiltBlueG(){

        poseFactory = poseFactory.mirrorX(72).mirrorY(72);
    }

    private final Pose start = poseFactory.of(30.75, 7.75, 90);
    private final Pose path1 = poseFactory.of(58.75, 22.75, 90);
    ////Shoot here
    private final Pose point2Start = poseFactory.of(58.75, 22.75, 90);
    private final Pose point2 = poseFactory.of(10.75, 46.75, 180);
    ////Reload from Here (flower)
    private final Pose point3Start = poseFactory.of(10.75, 46.75, 180);
    private final Pose point3 = poseFactory.of(58.75, 106.75, 270);

    private final Pose point3Control1 = poseFactory.of(22.75, 106.75, 0);
    /////Shoot here again
    private final Pose point4Start = poseFactory.of(58.75, 106.75, 270);
    private final Pose point4 = poseFactory.of(46.75, 130.75, 90);
    ////reload from Here (flower)
    private final Pose point5Start = poseFactory.of(46.75, 130.75, 90);
    private final Pose point5 = poseFactory.of(58.75, 22.75, 90);
    private final Pose point5Control1 = poseFactory.of(0, 70.75, 0);

    ////Shoot here again
    private final Pose point6Start = poseFactory.of(58.75, 22.75, 90);
    private final Pose point6 = poseFactory.of(22.75, 22.75, 0);
    ////Start intake
    private final Pose point7Start = poseFactory.of(22.75, 22.75, 0);
    private final Pose point7 = poseFactory.of(70.75, 22.75, 0);
    ////Stop intake
    private final Pose point8 = poseFactory.of(58.75, 106.75, -90);
    private final Pose point8Control1 = poseFactory.of(58.75, 10.75, 0);
    //// Shoot here again
    private final Pose point9Start = poseFactory.of(58.75, 106.75, 270);
    private final Pose point9 = poseFactory.of(22.75, 106.75, 0);
    ////Start intake
    private final Pose point10Start = poseFactory.of(22.75, 106.75, 0);
    private final Pose point10 = poseFactory.of(70.75, 106.75, 0);
    //// Stop intake
    private final Pose point11Start = poseFactory.of(70.75, 106.75, 0);
    private final Pose point11 = poseFactory.of(58.75, 22.75, 90);
    private final Pose point11Control1 = poseFactory.of(58.75, 46.75, 0);
    /////Shoot here again
    public Path path1() {
        return Paths.line(start, path1).linear(start, path1);
    }

    public Path path2() {
        return Paths.line(point2Start, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.curve(point3Start, point3Control1, point3).linear(point3Start, point3);
    }

    public Path path4() {
        return Paths.line(point4Start, point4).linear(point4Start, point4);
    }

    public Path path5() {
        return Paths.curve(point5Start, point5Control1, point5).linear(point5Start, point5);
    }

    public Path path6() {
        return Paths.line(point6Start, point6).linear(point6Start, point6);
    }

    public Path path7() {
        return Paths.line(point7Start, point7).linear(point7Start, point7);
    }

    public Path path8() {
        return Paths.curve(point7, point8Control1, point8).reverseTangent();
    }

    public Path path9() {
        return Paths.line(point9Start, point9).linear(point9Start, point9);
    }

    public Path path10() {
        return Paths.line(point10Start, point10).linear(point10Start, point10);
    }

    public Path path11() {
        return Paths.curve(point11Start, point11Control1, point11).linear(point11Start, point11);
    }
}
