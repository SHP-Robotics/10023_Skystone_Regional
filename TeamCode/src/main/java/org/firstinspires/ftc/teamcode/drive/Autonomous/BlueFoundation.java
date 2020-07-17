package org.firstinspires.ftc.teamcode.drive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.drive.AutoBases.ParkingBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveBase;
import org.firstinspires.ftc.teamcode.drive.mecanum.SampleMecanumDriveREVOptimized;

@Autonomous(group = "main")
public class BlueFoundation extends ParkingBase {

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREVOptimized(hardwareMap);
        drive.foundation(1);

        waitForStart();
        if (isStopRequested()) return;

        //delay start
        //sleep(5*1000);

        //reverse to foundation
        driveToReverse(drive, -30,-10,10);
        driveForward(drive,-3);

        //lower servos
        foundation(drive,-1);
        sleep(500);

        //pull foundation forward
        driveForward(drive,35);

        //turn right to face loading zone
        turn(drive,165);
        drive.foundation(1);

        //mecanum right to wall
        mecanum(drive,-30);

        //park under bridge
        driveForward(drive,26);
    }
}
