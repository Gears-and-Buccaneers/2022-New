package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

//import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.math.filter.SlewRateLimiter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.Controller;

/** An example command that uses an example subsystem. */
public class ArcadeDriveCmd extends CommandBase {
  private final DriveSubsystem m_driveTrain;

  //private final Supplier<Double> speedFunction, turnFunction;
  
  private final Joystick m_stick = new Joystick(Controller.kDriverControllerPort);
  private SlewRateLimiter xLimiter = new SlewRateLimiter(3);
  private SlewRateLimiter yLimiter = new SlewRateLimiter(3);
  // private final  pastJoystics = new[];

  // this is somehting taht is prety cool
  
  /*
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDriveCmd(DriveSubsystem driveTrain ) {//,
    //Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    // this.speedFunction = speedFunction;
    // this.turnFunction = turnFunction;
    m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }
  double[] intArray = new double[Controller.kArrayLength];
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //for (int j = 0; j < intArray.length; j++)
      //intArray[j] = 0 ;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // double realSpeed = speedFunction.get();
    // double turnFunction = speedFunction.get();
    
    //m_driveTrain.arcadeDrive(LagArray(m_stick.getRawAxis(1), Controller.kArrayLength)*DriveConstants.kDriveCoefficient, m_stick.getRawAxis(0)*DriveConstants.kTurnCoefficient);
    m_driveTrain.arcadeDrive(
      xLimiter.calculate(m_stick.getRawAxis(1))*DriveConstants.kDriveCoefficient, 
      yLimiter.calculate(m_stick.getRawAxis(0))*DriveConstants.kTurnCoefficient
      );

      //LagArray(m_stick.getY(), Controller.kArrayLength)*DriveConstants.kDriveCoefficient, m_stick.getY()*DriveConstants.kTurnCoefficient);
    
  }

  

  // public double LagArray(double joysick, int arrayLength) {

  //   for (int i = 0; i < arrayLength-1; i++) {
  //     intArray[i+1] = intArray[i];
  //   }
  //   intArray[0] = joysick;
  //   return (sum(intArray)/Controller.kArrayLength);
  // }

  // public static double sum(double[] arr) {
  //   // getting sum of array values
  //   double sum = 0;
    
  //   for (int i = 0; i < arr.length; i++)
  //     sum += arr[i];
    
  //   return sum;
  // }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
