package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.RGB;
import org.firstinspires.ftc.teamcode.subsystems.SITGroup;
import org.firstinspires.ftc.teamcode.subsystems.aShooter;
import org.firstinspires.ftc.teamcode.subsystems.colorSensor;
import org.firstinspires.ftc.teamcode.subsystems.intake;
import org.firstinspires.ftc.teamcode.subsystems.limeLightPlsWork;
import org.firstinspires.ftc.teamcode.subsystems.pShooter;
import org.firstinspires.ftc.teamcode.subsystems.slapDown;
import org.firstinspires.ftc.teamcode.subsystems.transfer;

import java.util.Set;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;
import dev.nextftc.v2.pedro.PedroMechanism;

public class robot implements NextRobot {
    //// Add the mechanisms that MAKE the robot
    public slapDown slapdown = new slapDown();
    public pShooter pShooter = new pShooter();
    public intake intake = new intake();
    public transfer transfer = new transfer();
    public PedroMechanism pedro = new PedroMechanism(Constants::create);
    public colorSensor sensor = new colorSensor();
    public RGB rgb;
    public aShooter aShooter = new aShooter();
    public limeLightPlsWork limeLight = new limeLightPlsWork();

    public RGB getRGB() {
        if (rgb == null) {
            rgb = new RGB(RobotController.hardwareMap());
        }
        return rgb;
    }
    public SITGroup SITGroup = new SITGroup(intake, pShooter, transfer, slapdown);
    /**
     * Creates a method that returns a set of all the mechanisms on our robot
     * @return {@link Set<Mechanism>} with all the subsystems on our bot
     */
    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(pShooter, aShooter, intake, transfer, slapdown, limeLight );
    }

}
