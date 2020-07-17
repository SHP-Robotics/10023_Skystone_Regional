package org.firstinspires.ftc.teamcode.drive.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;

@TeleOp
public class MainTeleOp extends OpMode {
    public DcMotor leftBack, rightBack, leftFront, rightFront, leftIntake, rightIntake, leftOut, rightOut;
    public Servo foundationLeft, foundationRight;

    @Override
    public void init() {
        initMotors();
        initServos();
        gamepad1.setJoystickDeadzone(0.1f);
    }

    private DcMotor initMotor(String motor) {
        return hardwareMap.get(DcMotor.class, motor);
    }

    private void initMotors() {
        leftBack= initMotor("leftBackDriveMotor");
        rightBack= initMotor("rightBackDriveMotor");
        leftFront= initMotor("leftFrontDriveMotor");
        rightFront= initMotor("rightFrontDriveMotor");

        leftIntake= initMotor("leftIntakeMotor");
        rightIntake= initMotor("rightIntakeMotor");
        leftOut = initMotor("leftOutMotor");
        rightOut = initMotor("rightOutMotor");
    }

    private Servo initServo(String servo) {
        return hardwareMap.get(Servo.class, servo);
    }

    private void initServos() {
        foundationLeft = initServo("foundationLeft");
        foundationLeft.setPosition(DriveConstants.FOUNDATION_LEFT_UP);
        foundationRight = initServo("foundationRight");
        foundationRight.setPosition(DriveConstants.FOUNDATION_RIGHT_UP);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        //drive train
        tankanum_drive(gamepad1.left_stick_y, gamepad1.right_stick_y, gamepad1.right_stick_x);

        //intake
        if (gamepad1.right_trigger > 0.1)
            intake(-gamepad1.right_trigger);
        else if (gamepad1.left_trigger > 0.1)
            intake(gamepad1.left_trigger);
        else
            intake(0);

        //foundation
        if (gamepad1.a) {
            foundationLeft.setPosition(DriveConstants.FOUNDATION_LEFT_DOWN);
            foundationRight.setPosition(DriveConstants.FOUNDATION_RIGHT_DOWN);
        } else if (gamepad1.b) {
            foundationLeft.setPosition(DriveConstants.FOUNDATION_LEFT_UP);
            foundationRight.setPosition(DriveConstants.FOUNDATION_RIGHT_UP);
        }
    }

    public void intake(double power) {
        double speed = Range.clip(power, -DriveConstants.MAX_INTAKE_TELEOP, DriveConstants.MAX_INTAKE_TELEOP);
        leftIntake.setPower(speed);
        rightIntake.setPower(-speed);
        leftOut.setPower(speed);
        rightOut.setPower(-speed);
    }

    public void tankanum_drive(double leftPwr, double rightPwr, double lateralpwr) {
        rightPwr *= -1;

        double leftFrontPower = Range.clip(leftPwr - lateralpwr, -1.0, 1.0);
        double leftBackPower = Range.clip(leftPwr + lateralpwr, -1.0, 1.0);
        double rightFrontPower = Range.clip(rightPwr - lateralpwr, -1.0, 1.0);
        double rightBackPower = Range.clip(rightPwr + lateralpwr, -1.0, 1.0);

        leftFront.setPower(leftFrontPower);
        leftBack.setPower(leftBackPower);
        rightFront.setPower(rightFrontPower);
        rightBack.setPower(rightBackPower);
    }
}