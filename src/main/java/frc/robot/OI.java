package frc.robot;

import frc.robot.commands.ToggleExtender;
import frc.robot.commands.ToggleFlower;
import frc.robot.commands.ToggleIntake;
import frc.robot.subsystems.Intake;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    private static OI instance;
    private static final int DRIVER_ID = 0;
    private XboxGamepad driver;

    private OI()
    {
        driver = new XboxGamepad(DRIVER_ID);
        initBindings();
    }

    private void initBindings()
    {
        driver.getButtonA().whenPressed(new ToggleIntake());
        driver.getButtonB().whenPressed(new ToggleFlower());
        driver.getButtonX().whenPressed(new ToggleExtender());
    }

    public XboxGamepad getDriver()
    {
        return driver;
    }

    public static OI getInstance()
    {
        if(instance == null)
            instance = new OI();
        return instance;
    }
}
