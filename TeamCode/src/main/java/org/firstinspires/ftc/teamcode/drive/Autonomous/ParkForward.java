package org.firstinspires.ftc.teamcode.drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.drive.AutoBases.ParkingBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;

@Autonomous(group = "main")
public class ParkForward extends ParkingBase {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);
        drive.foundation(1);

        waitForStart();
        if (isStopRequested()) return;

        //delay start
        //sleep(5*1000);

        driveForward(drive,9);

        //mecanum right
        //mecanum(drive,-2);

        //mecanum left
        //mecanum(drive,3);
    }
}
