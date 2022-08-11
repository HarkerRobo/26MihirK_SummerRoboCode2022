package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;
    private DoubleSolenoid flower;
    private DoubleSolenoid extender;
    private static final int FLOWER_FORWARD_ID = 0;
    private static final int FLOWER_BACKWARD_ID = 0;
    private static final int EXTENDER_FORWARD_ID = 0;
    private static final int EXTENDER_BACKWARD_ID = 0;


    private HatchLatcher()
    {
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FLOWER_FORWARD_ID, FLOWER_BACKWARD_ID);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, EXTENDER_FORWARD_ID, EXTENDER_BACKWARD_ID);
    }

    public void toggleFlower()
    {
        if(flower.get() == Value.kOff || flower.get() == Value.kForward)
            flower.set(Value.kReverse);
        else
            flower.set(Value.kForward);
    }

    public void toggleExtender()
    {
        if(extender.get() == Value.kOff || extender.get() == Value.kForward)
            extender.set(Value.kReverse);
        else
            extender.set(Value.kForward);
    }

    public static HatchLatcher getInstance()
    {
        if(instance == null)
            instance = new HatchLatcher();
        return instance;
    }
}
