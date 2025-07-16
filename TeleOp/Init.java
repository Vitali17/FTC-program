package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Init {
    public DcMotor SliderMotorLeft, SliderMotorRight,
            backrightMotor, frontleftMotor, frontrightMotor,backleftMotor;
    public Servo SliderL, SliderR, ArmL, ArmR, LowArm,
            RotHighClaw, DirectionalLowClaw, LowClaw, HighClaw;

    public Init(@NonNull HardwareMap hardwareMao){
        backleftMotor = hardwareMap.get(DcMotor.class, "CH_motor0");
        backrightMotor = hardwareMap.get(DcMotor.class, "EH_motor1");
        frontleftMotor = hardwareMap.get(DcMotor.class, "CH_motor1");
        frontrightMotor = hardwareMap.get(DcMotor.class, "EH_motor2");
        SliderMotorLeft = hardwareMap.get(DcMotor.class, "CH_motor2");
        SliderMotorRight = hardwareMap.get(DcMotor.class, "EH_motor0");

        ArmR = hardwareMap.get(Servo.class, "CH_servo3");
        ArmL = hardwareMap.get(Servo.class, "CH_servo2");
        LowArm = hardwareMap.get(Servo.class, "EH_servo0");
        LowClaw = hardwareMap.get(Servo.class, "EH_servo2");
        SliderR = hardwareMap.get(Servo.class, "EH_servo3");
        SliderL = hardwareMap.get(Servo.class, "CH_servo0");
        HighClaw = hardwareMap.get(Servo.class, "CH_servo4");
        RotHighClaw = hardwareMap.get(Servo.class, "CH_servo1");
        DirectionalLowClaw = hardwareMap.get(Servo.class, "EH_servo1");

        backleftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backrightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontleftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontrightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SliderMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SliderMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SliderMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SliderMotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SliderMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SliderMotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backleftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backrightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontleftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontrightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        SliderR.setDirection(Servo.Direction.REVERSE);

    }

    public void Initialization(){
        ArmL.setPosition(0.9);
        ArmR.setPosition(0.1);
        LowArm.setPosition(0.71);
        SliderL.setPosition(1);
        SliderR.setPosition(0);
        LowClaw.setPosition(1);
        HighClaw.setPosition(0.5);
        RotHighClaw.setPosition(0.85);
        DirectionalLowClaw.setPosition(0.5);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

}
