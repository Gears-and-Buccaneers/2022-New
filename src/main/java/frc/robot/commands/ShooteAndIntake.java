// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.TransitSubsytem;
import frc.robot.Constants.SubsytemConstants;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class ShooteAndIntake extends CommandBase {
  
  private final ShooterSubsytem m_shooter;
  private final TransitSubsytem m_transit;
  private final Timer m_timer= new Timer();
  private boolean m_derection = true;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @param derection The is used to say the derection the motor will move. false is down
   * 
   */
  public ShooteAndIntake(ShooterSubsytem shooter, TransitSubsytem transit) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = shooter;
    m_transit = transit;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.Run(SubsytemConstants.kShooterSpeedOne, SubsytemConstants.kShooterSpeedTwo);
    if (m_timer.get() <= 2.0) {
      m_transit.Run(100);
    }
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.Run(0, 0); 
    m_transit.Run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_timer.get() <= 3.0) {
      return false;    
    } else { 
      return true;
    }
  }
}
