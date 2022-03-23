// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kLeftParent = 0;
        public static final int kLeftChild = 1;
        public static final int kRightParent = 2;
        public static final int kRightChild = 3;
        public static final int SPEED = 50;

        public static final int kVoltageCompLevel = 11;     // this is what the old code has this value as
        public static final double kRampCoefficient = 0.1;  // this is also in the code so i am transfering it. i dont kknow if we need it but i am putting it in anyway

        public static final double kDriveCoefficient = 0.8; // you can also try .6 and .3 for turning
        public static final double kTurnCoefficient = 0.6; // this shoud slow the turing of the bot more than the speed. this is how we can tune the speed
        public static final double kXLimiter = 3; // you can play with this number. this sould do the same thing as the lagg aray but better.
        public static final double kYLimiter = 3; 

        public static final double kAutonomousTime = 3.0; // autonomous time

    }
    public static final class SubsytemConstants {
        // Climber stuff --------
        public static final int kClimberMotor = 10; // need to chech this
        public static final double kClimberSpeed = 0.25; // change for speed of the Climber
        public static final int kClimberMotor1 = 11; // need to chech this
        public static final double kClimberSpeed1 = kClimberSpeed; // change for speed of the Climber

        // Intake Stuff --------
        public static final int kIntakeMotor = 5; // need to chech this
        public static final double kIntakeSpeed = 0.5; // change for speed of the Intake

        // Transit Stuff --------
        public static final int kTransitMotor = 4; // need to chech this
        public static final double kTransitSpeed = -1; // change for speed of the Transit
        
        // Shooter Stuff --------
        public static final int kShooterMotorOne = 7; // need to chech this
        public static final int kShooterMotorTwo = 6; // need to chech this
        public static final double kShooterSpeedOne = -.85; // change for speed of the Shooter
        public static final double kShooterSpeedTwo = -kShooterSpeedOne+.125; // change for speed of the Shooter
    }
    

    public static final class Controller {
        public static final int kDriverControllerPort = 0; // this is the port were the controler is conected.
        public static final int kjoysticCofetien = 2; // it must be larger
        public static final int kArrayLength = 100; // this will affect the lagg of the joystic.
        //public static final int ControllerType = -- need to think how to do this one. i am not going to do this now.
    }
}
