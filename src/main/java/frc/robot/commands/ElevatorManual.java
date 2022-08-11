package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;

public class ElevatorManual extends IndefiniteCommand
{
    public ElevatorManual()
    {
        addRequirements(Elevator.getInstance());
    }

    public void execute()
    { 
        Elevator.getInstance().setPercentageOutput(Math.max(OI.getInstance().getDriver().getRightY(), 0.1));
    }

    public void end(boolean interrupted)
    {
        Elevator.getInstance().setPercentageOutput(0);
    }
}
