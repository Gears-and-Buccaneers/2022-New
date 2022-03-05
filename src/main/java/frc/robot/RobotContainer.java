// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ClimberSubsytem;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.TransitSubsytem;

import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.ClimberCmd;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.TransitCmd;

import frc.robot.Constants.Controller;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  private final ClimberSubsytem m_climberSubsytem = new ClimberSubsytem();
  private final IntakeSubsytem m_IntakeSubsytem = new IntakeSubsytem();
  private final ShooterSubsytem m_ShooterSubsytem = new ShooterSubsytem();
  private final TransitSubsytem m_TransitSubsytem = new TransitSubsytem();

  private final Joystick m_stick = new Joystick(Controller.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_DriveSubsystem.setDefaultCommand(new ArcadeDriveCmd(m_DriveSubsystem));//, () -> m_stick.getY(), () -> m_stick.getX()));
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_stick, 4).whenHeld(new ClimberCmd(m_climberSubsytem, true));
    new JoystickButton(m_stick, 5).whenHeld(new ClimberCmd(m_climberSubsytem, false));

    new JoystickButton(m_stick, 1).whenHeld(new IntakeCmd(m_IntakeSubsytem));
    new JoystickButton(m_stick, 4).whenHeld(new ShooterCmd(m_ShooterSubsytem));
    new JoystickButton(m_stick, 2).whenHeld(new TransitCmd(m_TransitSubsytem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new DriveForwardCmd(m_DriveSubsystem);
  }
}
