package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class ArcadeDriveManual extends IndefiniteCommand
{
    public ArcadeDriveManual()
    {
        addRequirements(Drivetrain.getInstance());
    }

    public void execute()
    {
        Drivetrain.getInstance().setArcadeDrive(OI.getInstance().getDriver().getLeftY(), OI.getInstance().getDriver().getLeftX());   
    }

    public void end(boolean interrupted)
    {
        Drivetrain.getInstance().setArcadeDrive(0, 0);
    }
}