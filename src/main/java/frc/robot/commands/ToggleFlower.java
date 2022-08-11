package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleFlower extends InstantCommand{
    public void initialize()
    {
        HatchLatcher.getInstance().toggleFlower();
    }
}
