package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SliderU {

    private DcMotor SliderMotorLeft,SliderMotorRight;
    private  Servo  ArmL, ArmR, LowArm, RotHighClaw, LowClaw, HighClaw;
    StepTimer TransferTime = new StepTimer();
    StepTimer ResetTime = new StepTimer();
    StepTimer Automateclimb = new StepTimer();

    public SliderU(@NonNull HardwareMap hardwareMap){
        SliderMotorLeft = hardwareMap.get(DcMotor.class, "CH_motor2");
        SliderMotorRight = hardwareMap.get(DcMotor.class, "EH_motor0");
        ArmR = hardwareMap.get(Servo.class, "CH_servo3");
        ArmL = hardwareMap.get(Servo.class, "CH_servo2");
        LowArm = hardwareMap.get(Servo.class, "EH_servo0");
        LowClaw = hardwareMap.get(Servo.class, "EH_servo2");
        HighClaw = hardwareMap.get(Servo.class, "CH_servo4");
        RotHighClaw = hardwareMap.get(Servo.class, "CH_servo1");

        SliderMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SliderMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SliderMotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SliderMotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void automateTransfer() {
        telemetry.addData("AutomateTransfer", TransferTime.getStep());
        telemetry.update();
        switch (TransferTime.getStep()) {
            case 0:
                TransferTime.start();
            case 1:
                //Daca e prea jos se scade ARML si se creste ARMR
                ArmR.setPosition(0.02);
                ArmL.setPosition(0.98);
                TransferTime.nextStep();
                break;
            case 2:
                if (TransferTime.waitStep(100)) {
                    HighClaw.setPosition(0.35);
                    TransferTime.nextStep();
                }
                break;
            case 3:
                if (TransferTime.waitStep(100)) {
                    LowClaw.setPosition(1);
                    TransferTime.nextStep();
                }
                break;
            case 4:
                if(TransferTime.waitStep(100)){
                    SliderMotorLeft.setTargetPosition(-2550);
                    SliderMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    SliderMotorLeft.setPower(1);

                    SliderMotorRight.setTargetPosition(2550);
                    SliderMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    SliderMotorRight.setPower(1);

                    TransferTime.nextStep();
                }
                break;
            case 5:
                if(TransferTime.waitStep(500)){
                    ArmR.setPosition(0.45);
                    ArmL.setPosition(0.55);
                    RotHighClaw.setPosition(0.4);

                    TransferTime.reset();
                }
                break;
        }
    }

    public void ResetSlider() {
        telemetry.addData("SliderResetStep", ResetTime.getStep());
        telemetry.update();
        switch (ResetTime.getStep()){
            case 0:
                ResetTime.start();
                break;
            case 1:
                HighClaw.setPosition(0.5);
                ResetTime.nextStep();
                break;
            case 2:
                if(ResetTime.waitStep(10)){
                    ArmL.setPosition(0.9);
                    ArmR.setPosition(0.1);
                    RotHighClaw.setPosition(0.85);

                    ResetTime.nextStep();
                }
                break;
            case 3:
                if(ResetTime.waitStep(10)){
                    SliderMotorLeft.setTargetPosition(0);
                    SliderMotorRight.setTargetPosition(0);

                    SliderMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    SliderMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    SliderMotorLeft.setPower(1);
                    SliderMotorRight.setPower(1);

                    ResetTime.start();
                }
                break;
        }
    }

    public void automateclimb() {
        telemetry.addData("AutomateClimbStep", Automateclimb.getStep());
        telemetry.update();
        switch (Automateclimb.getStep()) {
            case 0:
                Automateclimb.start();
            case 1:
                SliderMotorLeft.setTargetPosition(-2850);
                SliderMotorRight.setTargetPosition(2850);

                SliderMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                SliderMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                SliderMotorLeft.setPower(1);
                SliderMotorRight.setPower(1);

                Automateclimb.nextStep();
                break;
            case 2:
                if (Automateclimb.waitStep(50)) {
                    SliderMotorLeft.setTargetPosition(-1750);
                    SliderMotorRight.setTargetPosition(1750);

                    SliderMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    SliderMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    SliderMotorLeft.setPower(1);
                    SliderMotorRight.setPower(1);
                    Automateclimb.nextStep();
                }
                break;
            case 3:
                if (Automateclimb.waitStep(500)) {
                    SliderMotorLeft.setTargetPosition(-2050);
                    SliderMotorRight.setTargetPosition(2050);

                    SliderMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    SliderMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    SliderMotorLeft.setPower(1);
                    SliderMotorRight.setPower(1);

                    Automateclimb.nextStep();
                }
                break;
            case 4:
                if (Automateclimb.waitStep(500)) {
                    SliderMotorLeft.setTargetPosition(0);
                    SliderMotorRight.setTargetPosition(0);

                    SliderMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    SliderMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    SliderMotorLeft.setPower(1);
                    SliderMotorRight.setPower(1);

                    Automateclimb.reset();
                }
                break;
        }
    }
    }
