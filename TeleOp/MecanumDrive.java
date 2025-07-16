package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    private DcMotor backleftMotor, backrightMotor, frontleftMotor, frontrightMotor;

    public MecanumDrive(@NonNull HardwareMap hardwareMap) {
        backleftMotor = hardwareMap.get(DcMotor.class, "CH_motor0");
        backrightMotor = hardwareMap.get(DcMotor.class, "EH_motor1");
        frontleftMotor = hardwareMap.get(DcMotor.class, "CH_motor1");
        frontrightMotor = hardwareMap.get(DcMotor.class, "EH_motor2");

        backleftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backrightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontleftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontrightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backleftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backrightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontleftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontrightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void drive(double forward, double strafe, double rotate, double speed) {
        backleftMotor.setPower((forward + strafe + rotate) / speed);
        backrightMotor.setPower((forward + strafe - rotate) / speed);
        frontleftMotor.setPower((forward - strafe + rotate) / speed);
        frontrightMotor.setPower((forward - strafe - rotate) / speed);
    }
}