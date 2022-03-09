package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


// stuff for the motors
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants.SubsytemConstants;

public class ClimberSubsytem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_TalonFX main0 = new WPI_TalonFX(SubsytemConstants.kClimberMotor);
  private final WPI_TalonFX main1 = new WPI_TalonFX(SubsytemConstants.kClimberMotor1);

  public ClimberSubsytem() {
    main0.configFactoryDefault();

    main0.enableVoltageCompensation(true);
    main0.setNeutralMode(NeutralMode.Brake); // this is importatin
    main1.configFactoryDefault();

    main1.enableVoltageCompensation(true);
    main1.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Run(double val, double val2){
    main1.set(ControlMode.PercentOutput, val);
    main0.set(ControlMode.PercentOutput, val2);
  }
}
