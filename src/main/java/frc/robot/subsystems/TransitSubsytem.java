package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


// stuff for the motors
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants.SubsytemConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TransitSubsytem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_VictorSPX main1 = new WPI_VictorSPX(SubsytemConstants.kTransitMotor);

  public TransitSubsytem() {
    main1.configFactoryDefault();

    main1.enableVoltageCompensation(true);
    main1.setNeutralMode(NeutralMode.Brake); // this is importatin
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Run(double val){
    main1.set(ControlMode.PercentOutput, val);
    SmartDashboard.putNumber("Transit Derecton", val*100);
  }
}
