package org.firstinspires.ftc.teamcode.subsystems;


import static org.firstinspires.ftc.teamcode.subsystems.Constants.IntakeConstants.maxPower;
import static org.firstinspires.ftc.teamcode.subsystems.Constants.IntakeConstants.noPower;


import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;
@NextTeleop
public class intake implements Mechanism {
    private final NextMotor intakeMotor = new NextMotor(RobotController.controlHub(), 0);

    /**
     * Creates a command that sets the intake motor forwards
     * @return {@link Command} that sets the throttle to a variable
     */
    public Command runIntake(){
        return instant(() -> intakeMotor.setThrottle(maxPower));
    }

    /**
     * Creates a command that sets that runs the intake motor backwards
     * @return {@link Command} that sets the throttle to a variable inversed
     */
    public Command runBackwards(){
        return instant(() -> intakeMotor.setThrottle(-maxPower));
    }

    /**
     * Creates a command that stops the intake motor
     * @return {@link Command} that sets the throttle to 0
     */
    public Command stopIntake(){
        return instant(() -> intakeMotor.setThrottle(noPower));
    }
}
