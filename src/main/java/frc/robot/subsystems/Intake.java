package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    private boolean intaking;
    private static Intake instance;
    private DoubleSolenoid piston;
    private static final int FORWARD_ID = 0;
    private static final int BACKWARD_ID = 0;
    private HSTalon motor;
    private static final int MOTOR_ID = 0;
    private static final boolean MOTOR_INVERTED = false;

    private Intake()
    {
        motor = new HSTalon(MOTOR_ID);
        motor.setInverted(MOTOR_INVERTED);
        piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_ID, BACKWARD_ID);
        intaking = false;
    }

    public HSTalon getMotor()
    {
        return motor;
    }

    public void setPercentageOutput(double output)
    {
        motor.set(ControlMode.PercentOutput, output);
        intaking = output >= 0.1;
    }

    public void toggleState()
    {
        if(piston.get() == Value.kOff || piston.get() == Value.kForward)
            piston.set(Value.kReverse);
        else
            piston.set(Value.kForward);
    }

    public boolean isIntaking()
    {
        return intaking;
    }

    public static Intake getInstance()
    {
        if(instance == null)
            instance = new Intake();
        return instance;
    }
}
