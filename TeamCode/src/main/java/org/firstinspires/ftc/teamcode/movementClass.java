package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareDevice.*;



public class movementClass {
    private DcMotor forwardLeft = null;
    private DcMotor backwardLeft = null;
    private DcMotor forwardRight = null;
    private DcMotor backwardRight = null;

    HardwareMap hwMap = null;

    private void PST (Exception e) {
        e.printStackTrace();
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException e) {
            PST(e);
        }
    }

    public void init(HardwareMap aHM) {
        hwMap = aHM;

        forwardLeft  = hwMap.get(DcMotor.class, "fl");
        backwardLeft = hwMap.get(DcMotor.class, "bl");
        forwardRight = hwMap.get(DcMotor.class, "fr");
        backwardRight = hwMap.get(DcMotor.class, "br");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        forwardLeft.setDirection(DcMotor.Direction.FORWARD);
        forwardRight.setDirection(DcMotor.Direction.REVERSE);
        backwardLeft.setDirection(DcMotor.Direction.FORWARD);
        backwardRight.setDirection(DcMotor.Direction.REVERSE);
    }

    public void forward(double magnitude, long ms) {
        try {
            forwardLeft.setPower(magnitude);
            forwardRight.setPower(magnitude);
            backwardLeft.setPower(magnitude);
            backwardRight.setPower(magnitude);
            Thread.sleep(ms);
        } catch(InterruptedException e) {
            PST(e);
        }
    }
    public void backward(double magnitude, long ms) {
        forwardLeft.setPower(-magnitude);
        forwardRight.setPower(-magnitude);
        backwardLeft.setPower(-magnitude);
        backwardRight.setPower(-magnitude);
        sleep(ms);
    }
    public void left(double magnitude, long ms) {
        forwardLeft.setPower(-magnitude);
        forwardRight.setPower(magnitude);
        backwardLeft.setPower(magnitude);
        backwardRight.setPower(-magnitude);
        sleep(ms);
    }
    public void right(double magnitude, long ms) {
        forwardLeft.setPower(magnitude);
        forwardRight.setPower(-magnitude);
        backwardLeft.setPower(-magnitude);
        backwardRight.setPower(magnitude);
        sleep(ms);
    }
    public void forwardLeft(double magnitude, long ms) {
        forwardRight.setPower(magnitude);
        forwardLeft.setPower(0);
        backwardLeft.setPower(magnitude);
        backwardRight.setPower(0);
        sleep(ms);
    }
    public void forwardRight(double magnitude, long ms) {
        forwardLeft.setPower(magnitude);
        forwardRight.setPower(0);
        backwardRight.setPower(magnitude);
        backwardLeft.setPower(0);
        sleep(ms);
    }
    public void backwardLeft(double magnitude, long ms) {
        forwardLeft.setPower(-magnitude);
        forwardRight.setPower(0);
        backwardLeft.setPower(0);
        backwardRight.setPower(-magnitude);
        sleep(ms);
    }
    public void backwardRight(double magnitude, long ms) {
        forwardRight.setPower(-magnitude);
        forwardLeft.setPower(0);
        backwardRight.setPower(0);
        backwardLeft.setPower(-magnitude);
        sleep(ms);
    }
    public void turnLeft(double magnitude, long ms) {
        forwardLeft.setPower(-magnitude);
        forwardRight.setPower(magnitude);
        backwardLeft.setPower(-magnitude);
        backwardRight.setPower(magnitude);
        sleep(ms);
    }
    public void turnRight(double magnitude, long ms) {
        forwardLeft.setPower(magnitude);
        forwardRight.setPower(-magnitude);
        backwardLeft.setPower(magnitude);
        backwardRight.setPower(-magnitude);
        sleep(ms);
    }
}