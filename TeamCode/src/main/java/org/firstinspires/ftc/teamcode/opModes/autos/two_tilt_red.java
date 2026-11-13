package org.firstinspires.ftc.teamcode.opModes.autos;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class two_tilt_red {
    public static class Paths {

        private final PoseFactory poseFactory = PoseFactory.degrees();

        private final Pose start = poseFactory.of(56, 8, 90);
        private final Pose path1 = poseFactory.of(56.8576, 27.6386, 90);
        private final Pose point2Start = poseFactory.of(56.8576, 27.6386, 160);
        private final Pose point2 = poseFactory.of(6.1798, 43.3867, 160);
        private final Pose point3Start = poseFactory.of(6.1798, 43.3867, 160);
        private final Pose point3 = poseFactory.of(21.7377, 37.4386, 90);
        private final Pose point4 = poseFactory.of(57.0197, 123.7043, 35.4015);
        private final Pose point4Control1 = poseFactory.of(19.482, 97.0261, 0);

        public Path path1() {
            return Paths.line(start, path1).linear(start, path1);
        }

        public Path path2() {
            return Paths.line(point2Start, point2).linear(point2Start, point2);
        }

        public Path path3() {
            return Paths.line(point3Start, point3).linear(point3Start, point3);
        }

        private static Path line(Pose point3Start, Pose point3) {
        };

        public Path path4() {
            return com.pedropathing.api.Paths.curve(point3, point4Control1, point4).tangent();
        }
    }

}
