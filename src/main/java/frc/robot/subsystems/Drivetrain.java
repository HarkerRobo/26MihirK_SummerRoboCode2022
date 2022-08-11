package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase{
    private static Drivetrain instance;
    private HSTalon leftMaster; 
    private HSTalon rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;
    private static final int LEFT_MASTER_ID = 0;
    private static final int RIGHT_MASTER_ID = 0;
    private static final int LEFT_FOLLOWER_ID = 0;
    private static final int RIGHT_FOLLOWER_ID = 0;
    private static final boolean LEFT_MASTER_INVERTED = false;
    private static final boolean RIGHT_MASTER_INVERTED = false;
    private static final boolean LEFT_FOLLOWER_INVERTED = false;
    private static final boolean RIGHT_FOLLOWER_INVERTED = false;


    private Drivetrain()
    {
        leftMaster = new HSTalon(LEFT_MASTER_ID);
        rightMaster = new HSTalon(RIGHT_MASTER_ID);
        leftFollower = new VictorSPX(LEFT_FOLLOWER_ID);
        rightFollower = new VictorSPX(RIGHT_FOLLOWER_ID);
        leftMaster.setInverted(LEFT_MASTER_INVERTED);
        rightMaster.setInverted(RIGHT_MASTER_INVERTED);
        leftFollower.setInverted(LEFT_FOLLOWER_INVERTED);
        rightFollower.setInverted(RIGHT_FOLLOWER_INVERTED);
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
    }

    public void setArcadeDrive(double speed, double turn)
    {
        leftMaster.set(ControlMode.PercentOutput, speed+turn);
        rightMaster.set(ControlMode.PercentOutput, speed-turn);       
    }

    public static Drivetrain getInstance()
    {
        if(instance == null)
            instance = new Drivetrain();
        return instance;
    }
}
