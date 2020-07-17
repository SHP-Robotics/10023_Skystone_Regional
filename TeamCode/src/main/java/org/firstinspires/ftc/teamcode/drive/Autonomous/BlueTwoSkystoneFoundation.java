package org.firstinspires.ftc.teamcode.drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.drive.AutoBases.OpenCVDetectorRed;
import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;

@Autonomous(group = "main")
public class BlueTwoSkystoneFoundation extends OpenCVDetectorRed {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);
        drive.foundation(1);

        super.runOpMode(); //runs OpenCV program and sets position to 1 (left), 2 (middle), or 3 (right)
        if (isStopRequested()) return;

        telemetry.addData("Skystone Position: ", position);

        //right position (1 & 4)
        if (position == 1) {
            //intake first skystone (position 1)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,40,-45,-40); //36,-49,-45
            //sleep(100);
            driveForward(drive,5);
            drive.intake(0);

            //reverse away from blocks
            driveToReverse(drive,30,-7,-100); //28,-7,-100

            //drive to foundation
            driveToReverse(drive,81,87,-245); //84,96,245

            //reverse to foundation
            driveForward(drive,-5);

            //lower servos, place skystone
            drive.foundation(-1);
            drive.intake(1);
            sleep(1000);

            //pull foundation forward and turn left to face loading zone
            driveForward(drive,35);
            turn(drive,195); //200
            drive.foundation(1);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,12,40,-95); //10/15, -40, 100

            //intake second skystone (position 4)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,52,12,0); //47/50, 10/16, 0
            drive.intake(0);

            //drive to center of skybridge
            driveToReverse(drive,22,25,-100); //28,25,-100

            //place second skystone
            driveToReverse(drive,18,90,-90);
            drive.intake(1);
            sleep(1500);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,18,55,-90);
        }
        //middle position (2 & 5)
        else if (position == 2) {
            //intake first skystone (position 2)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,42,-30,-45); //42,36,-45
            driveForward(drive,2);
            drive.intake(0);

            //reverse away from blocks
            driveToReverse(drive,32,4,-100); //27,-9

            //drive to foundation
            driveToReverse(drive,81,85,-250); //88, -85, 260

            //reverse to foundation
            driveForward(drive,-5);

            //lower servos, place skystone
            drive.foundation(-1);
            drive.intake(1);
            sleep(1000);

            //pull foundation forward and turn left to face loading zone
            driveForward(drive,35);
            turn(drive,170); //190
            drive.foundation(1);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,15,40,-100);

            //intake second skystone (position 5)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,51,20,0); //47,17,0
            drive.intake(0);

            //drive to center of skybridge
            driveToReverse(drive,24,30,-100);

            //place second skystone
            driveToReverse(drive,20,90,-90);
            drive.intake(1);
            sleep(1500);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,19,55,-90);
        }
        //left position (3 & 6)
        else if (position == 3) {
            //intake first skystone (position 3)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,44,-20,-50); //42,-20/-13,45
            driveForward(drive,4);
            //sleep(500);
            drive.intake(0);

            //reverse away from blocks
            driveToReverse(drive,35,18,-90); //35,19,-100

            //drive to foundation
            driveToReverse(drive,81,82,-245); //92,-85,260

            //reverse to foundation
            driveForward(drive,-5);

            //lower servos, place skystone
            drive.foundation(-1);
            drive.intake(1);
            sleep(1000);

            //pull foundation forward and turn left to face loading zone
            driveForward(drive,35);
            turn(drive,180);
            drive.foundation(1);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,15,42,-100); //15,45

            //intake second skystone (position 6)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,46,25,-40); //38,22,-40
            driveForward(drive,3);
            drive.intake(0);

            //drive to center of skybridge
            driveToReverse(drive,22,40,-100);

            //place second skystone
            driveToReverse(drive,20,90,-90);
            drive.intake(1);
            sleep(1500);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,19,55,-90);
        }
    }
}