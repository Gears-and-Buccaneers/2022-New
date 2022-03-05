package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


// stuff for the motors
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants.SubsytemConstants;

public class ShooterSubsytem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_VictorSPX main1 = new WPI_VictorSPX(SubsytemConstants.kShooterMotorOne);
  private final WPI_VictorSPX main2 = new WPI_VictorSPX(SubsytemConstants.kShooterMotorTwo);

  public ShooterSubsytem() {
    main1.configFactoryDefault();
    main2.configFactoryDefault();

    main1.enableVoltageCompensation(true);
    main1.setNeutralMode(NeutralMode.Coast); // this is importatin
    main2.enableVoltageCompensation(true);
    main2.setNeutralMode(NeutralMode.Coast); // this is importatin
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Run(double val1,double val2){
    main1.set(ControlMode.PercentOutput, val1);
    main2.set(ControlMode.PercentOutput, val2);
  }
}