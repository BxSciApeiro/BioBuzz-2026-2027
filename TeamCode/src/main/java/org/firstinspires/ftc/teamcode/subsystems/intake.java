package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.instant;

import static org.firstinspires.ftc.teamcode.subsystems.IntakeConstants.maxPower;
import static org.firstinspires.ftc.teamcode.subsystems.IntakeConstants.noPower;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;

import org.firstinspires.ftc.teamcode.subsystems.IntakeConstants;
@NextTeleop
public class intake implements Mechanism {
    private NextMotor intakeMotor = new NextMotor(RobotController.controlHub(), 0);

    public Command runIntake(){
        return instant(() -> intakeMotor.setThrottle(maxPower));
    }
    public Command runBackwards(){
        return instant(() -> intakeMotor.setThrottle(-maxPower));
    }
    public Command stopIntake(){
        return instant(() -> intakeMotor.setThrottle(noPower));
    }
}
