package org.firstinspires.ftc.teamcode.drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.drive.AutoBases.OpenCVDetectorBlue;
import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;

@Autonomous(group = "main")
public class RedTwoSkystoneFoundation extends OpenCVDetectorBlue {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);
        drive.foundation(1);

        super.runOpMode(); //runs OpenCV program and sets position to 1 (left), 2 (middle), or 3 (right)
        if (isStopRequested()) return;

        telemetry.addData("Skystone Position: ", position);

        //left position (1 & 4)
        if (position == 1) {
            //intake first skystone (position 1)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,36,49,45); //36,49,45
            driveForward(drive,4);
            drive.intake(0);

            //reverse away from blocks
            driveToReverse(drive,28,7,100); //25,10,100

            //drive to foundation
            driveToReverse(drive,80,-96,245); //84,-96,245

            //reverse to foundation
            driveForward(drive,-4);

            //lower servos, place skystone
            drive.foundation(-1);
            drive.intake(1);
            sleep(1000);

            //pull foundation forward and turn right to face loading zone
            driveForward(drive,36);
            turn(drive,-200); //-200
            drive.foundation(1);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,5,-40,100); //10, -40, 100

            //intake second skystone (position 4)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,45,-10,0); //47,-8, 0
            drive.intake(0);

            //drive to center of skybridge
            driveToReverse(drive,20,-25,100); //22,-25,100

            //place second skystone
            driveToReverse(drive,23,-90,90);
            drive.intake(1);
            sleep(1500);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,12,-55,90);
        }
        //middle position (2 & 5)
        else if (position == 2) {
            //intake first skystone (position 2)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,42,36,45); //36,49,45
            drive.intake(0);

            //reverse away from blocks
            driveToReverse(drive,31,-4,100); //27,-9

            //drive to foundation
            driveToReverse(drive,85,-90,250); //88, -85, 260

            //reverse to foundation
            driveForward(drive,-3);

            //lower servos, place skystone
            drive.foundation(-1);
            drive.intake(1);
            sleep(1000);

            //pull foundation forward and turn right to face loading zone
            driveForward(drive,35);
            turn(drive,-190);
            drive.foundation(1);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,5,-40,100);

            //intake second skystone (position 5)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,47,-17,0); //55,-9,0
            drive.intake(0);

            //drive to center of skybridge
            driveToReverse(drive,17,-30,100);

            //place second skystone
            driveToReverse(drive,20,-90,90);
            drive.intake(1);
            sleep(1500);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,12,-55,90);
        }
        //right position (3 & 6)
        else if (position == 3) {
            //intake first skystone (position 3)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,42,20,45); //36,49,45
            drive.intake(0);

            //reverse away from blocks
            driveToReverse(drive,35,-19,100); //31

            //drive to foundation
            driveToReverse(drive,78,-82,250); //92,-85,260

            //reverse to foundation
            driveForward(drive,-5);

            //lower servos, place skystone
            drive.foundation(-1);
            drive.intake(1);
            sleep(1000);

            //pull foundation forward and turn right to face loading zone
            driveForward(drive,35);
            turn(drive,-190);
            drive.foundation(1);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,8,-45,100);

            //intake second skystone (position 6)
            drive.intake(DriveConstants.MAX_INTAKE);
            driveTo(drive,38,-22,40); //55,-30/21,0
            drive.intake(0);

            //drive to center of skybridge
            driveToReverse(drive,14,-40,100);

            //place second skystone
            driveToReverse(drive,15,-90,90);
            drive.intake(1);
            sleep(1500);
            drive.intake(0);

            //drive to center of skybridge
            driveTo(drive,13,-55,90);
        }
    }
}