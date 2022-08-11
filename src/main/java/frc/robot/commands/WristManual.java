package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;

public class WristManual extends IndefiniteCommand
{
    public WristManual()
    {
        addRequirements(Wrist.getInstance());
    }

    public void execute()
    { 
        if(OI.getInstance().getDriver().getUpDPadButton().get())
            Wrist.getInstance().setPercentageOutput(0.7);
        else
            Wrist.getInstance().setPercentageOutput(-0.7);
    }

    public void end(boolean interrupted)
    {
        Wrist.getInstance().setPercentageOutput(0);
    }
}
