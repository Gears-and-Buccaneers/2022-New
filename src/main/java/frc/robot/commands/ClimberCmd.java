// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsytem;
import frc.robot.Constants.SubsytemConstants;

/** An example command that uses an example subsystem. */
public class ClimberCmd extends CommandBase {
  
  private final ClimberSubsytem m_ClimberMotor;
  private boolean m_derection = false;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @param derection The is used to say the derection the motor will move. false is down
   * 
   */
  public ClimberCmd(ClimberSubsytem ClimberMotor, boolean derection) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_ClimberMotor = ClimberMotor;
    m_derection = derection;
    addRequirements(ClimberMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_derection) {
      m_ClimberMotor.Run(SubsytemConstants.kClimberSpeed, SubsytemConstants.kClimberSpeed1);
    } else if (!m_derection){
      m_ClimberMotor.Run(-SubsytemConstants.kClimberSpeed, -SubsytemConstants.kClimberSpeed1);
    } else {
      m_ClimberMotor.Run(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ClimberMotor.Run(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
