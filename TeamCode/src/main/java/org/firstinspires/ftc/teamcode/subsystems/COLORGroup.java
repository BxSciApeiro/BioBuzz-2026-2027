package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.robot.Mechanism;

public class COLORGroup implements Mechanism {
    private final colorSensor colorsensor;
    private final aShooter aShooter;

    public COLORGroup( colorSensor colorsensor, aShooter aShooter) {
            this.colorsensor = colorsensor;
            this.aShooter = aShooter;
    }

    public boolean isRedDetected() {
        return colorsensor.redDetected(colorsensor.getHue());
    }




    public void Display(){
        if(colorsensor.redDetected(colorsensor.getHue())){
            //aShooter.adjustHoodtoNectar().schedule();
        } else if (colorsensor.yellowDetected(colorsensor.getHue())){
            //aShooter.adjustHoodtoPollen().schedule();
        } else {
            aShooter.adjusttoZero().schedule();
        }
    }

}
