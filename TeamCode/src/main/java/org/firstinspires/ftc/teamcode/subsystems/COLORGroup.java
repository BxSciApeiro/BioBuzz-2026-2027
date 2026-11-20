package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.groups.Groups.sequential;

import static org.firstinspires.ftc.onbotjava.OnBotJavaWebInterfaceManager.instance;

import com.pedropathing.ivy.Command;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;

public class COLORGroup implements Mechanism {
    private final colorSensor colorsensor;
    private final aShooter aShooter;

    public COLORGroup( colorSensor colorsensor, aShooter aShooter) {
            this.colorsensor = colorsensor;
            this.aShooter = aShooter;
    }
    public Command DetectRed(){
            return aShooter.adjustHoodtoNectar();
    }
    public Command DetectYellow(){
        return aShooter.adjustHoodtoPollen();
    }


    public Command Display(){
        if(colorsensor.redDetected(colorsensor.getHue())){
            return DetectRed();
        }
        if(colorsensor.yellowDetected(colorsensor.getHue())){
            return DetectYellow();
        }
        return null;
    }

}
