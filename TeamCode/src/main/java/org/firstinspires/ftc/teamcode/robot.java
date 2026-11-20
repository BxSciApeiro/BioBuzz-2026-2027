package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.COLORGroup;
import org.firstinspires.ftc.teamcode.subsystems.RGB;
import org.firstinspires.ftc.teamcode.subsystems.SITGroup;
import org.firstinspires.ftc.teamcode.subsystems.aShooter;
import org.firstinspires.ftc.teamcode.subsystems.colorSensor;
import org.firstinspires.ftc.teamcode.subsystems.intake;
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
    public colorSensor colorSensor = new colorSensor();
    public RGB RGB;
    public aShooter aShooter = new aShooter();

    public RGB getRGB() {
        if (RGB == null) {
            RGB = new RGB(RobotController.hardwareMap());
        }
        return RGB;
    }
    public SITGroup SITGroup = new SITGroup(intake, pShooter, transfer, slapdown);
//
    public COLORGroup COLORGroup = new COLORGroup(colorSensor, aShooter);
    /**
     * Creates a method that returns a set of all the mechanisms on our robot
     * @return {@link Set<Mechanism>} with all the subsystems on our bot
     */
    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(pShooter, aShooter, intake, transfer, slapdown, colorSensor);
    }

}
