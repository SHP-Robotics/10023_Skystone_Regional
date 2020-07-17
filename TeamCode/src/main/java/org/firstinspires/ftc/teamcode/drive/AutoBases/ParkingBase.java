package org.firstinspires.ftc.teamcode.drive.AutoBases;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;

public class ParkingBase extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);
        drive.foundation(1);

        waitForStart();
        if (isStopRequested()) return;
    }

    //+x is forward, +y is left, +angle (degrees) is left
    public void driveTo(SampleMecanumDriveBase drive, float x, float y, float angle) {
        drive.followTrajectorySync(
                drive.trajectoryBuilder()
                        .splineTo(new Pose2d(x, y, Math.toRadians(angle)))
                        .build()
        );
    }

    //+x is forward, +y is left, +angle (degrees) is left
    public void driveToReverse(SampleMecanumDriveBase drive, float x, float y, float angle) {
        drive.followTrajectorySync(
                drive.trajectoryBuilder()
                        .reverse()
                        .splineTo(new Pose2d(x, y, Math.toRadians(angle)))
                        .build()
        );
    }

    //+distance for forward, -distance for reverse
    public void driveForward(SampleMecanumDriveBase drive, float distance) {
        if (distance >= 0)
            drive.followTrajectorySync(drive.trajectoryBuilder().forward(distance).build());
        else
            drive.followTrajectorySync(drive.trajectoryBuilder().reverse().forward(-distance).build());
    }

    //+angle for left, -angle for right
    public void turn(SampleMecanumDriveBase drive, float angle) {
        drive.turnSync(Math.toRadians(angle));
    }

    //+distance for left, -distance for right
    public void mecanum(SampleMecanumDriveBase drive, float distance) {
        if (distance >= 0)
            drive.followTrajectorySync(drive.trajectoryBuilder().strafeLeft(distance).build());
        else
            drive.followTrajectorySync(drive.trajectoryBuilder().strafeRight(-distance).build());
    }

    public void foundation(SampleMecanumDriveBase drive, int dir) {
        drive.foundation(dir);
    }
}