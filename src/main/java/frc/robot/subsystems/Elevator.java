package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance;
    private HSTalon master; 
    private HSTalon follower1;
    private VictorSPX follower2;
    private VictorSPX follower3;
    private static final int MASTER_ID = 0;
    private static final int FOLLOWER1_ID = 0;
    private static final int FOLLOWER2_ID = 0;
    private static final int FOLLOWER3_ID = 0;
    private static final boolean MASTER_INVERTED = false;
    private static final boolean FOLLOWER1_INVERTED = false;
    private static final boolean FOLLOWER2_INVERTED = false;
    private static final boolean FOLLOWER3_INVERTED = false;

    private Elevator()
    {
        master = new HSTalon(MASTER_ID);
        follower1 = new HSTalon(FOLLOWER1_ID);
        follower2 = new VictorSPX(FOLLOWER2_ID);
        follower3 = new VictorSPX(FOLLOWER3_ID);
        master.setInverted(MASTER_INVERTED);
        follower1.setInverted(FOLLOWER1_INVERTED);
        follower2.setInverted(FOLLOWER2_INVERTED);
        follower3.setInverted(FOLLOWER3_INVERTED);
        follower1.follow(master);
        follower2.follow(master);
        follower3.follow(master);
    }

    public void setPercentageOutput(double output)
    {
        master.set(ControlMode.PercentOutput, output);
    }

    public static Elevator getInstance()
    {
        if(instance == null)
            instance = new Elevator();
        return instance;
    }
}
