package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.openftc.easyopencv.*;


@TeleOp(name = "Basic: OpenCV", group="???")
public class Basic_OpenCV extends OpMode
{
    @Override
    public void init() {
        telemetry.addData("Status", "Running");
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                // Start streaming camera here.
                camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {
                // lol no work like rishi muscles
                System.out.println("Camera - Not working");
            }
        });


    }

    @Override
    public void loop() {
        
    }
}