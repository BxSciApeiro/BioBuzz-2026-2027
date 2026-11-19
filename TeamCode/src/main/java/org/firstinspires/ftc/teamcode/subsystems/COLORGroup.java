package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.groups.Groups.sequential;

import static org.firstinspires.ftc.onbotjava.OnBotJavaWebInterfaceManager.instance;

import com.pedropathing.ivy.Command;

import dev.nextftc.robot.Mechanism;

public class COLORGroup implements Mechanism {
    private final RGB rgb;
    private final colorSensor colorsensor;
    private final aShooter aShooter;

    public COLORGroup(RGB rgb, colorSensor colorsensor, aShooter aShooter) {
            this.rgb = rgb;
            this.colorsensor = colorsensor;
            this.aShooter = aShooter;
    }
    public Command DetectRed(){
            return sequential(
                    rgb.turnRedOn(),
                    rgb.turnGreenOff(),
                    aShooter.adjustHoodtoNectar()
            );
    }
    public Command DetectYellow(){
        return sequential(
                rgb.turnGreenOn(),
                rgb.turnRedOff(),
                aShooter.adjustHoodtoPollen()
        );
    }
    public Command def(){
        return sequential(
                rgb.turnGreenOff(),
                rgb.turnRedOff()
        );
    }
    public Command Display(){
        if(colorsensor.redDetected(colorsensor.getHue())){
            return DetectRed();
        }
        if(colorsensor.yellowDetected(colorsensor.getHue())){
            return DetectYellow();
        }
        return def();
    }

}
