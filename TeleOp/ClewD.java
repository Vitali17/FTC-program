package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClewD {
    private Servo LowArm, DirectionalLowClaw, LowClaw;

    private static final double LOW_ARM_DOWN = 0.12;
    private static final double LOW_ARM_ACTION = 0.02;
    private static final double LOW_CLAW_CLOSE = 0.7;
    private static final double LOW_CLAW_OPEN = 1;
    private static final double LOW_GRIPPER_0 = 0.5;
    private static final double LOW_GRIPPER_45 = 0.7;
    private static final double LOW_GRIPPER_90 = 0.86;

    private StepTimer ClewTime = new StepTimer();
    public ClewD(@NonNull HardwareMap hardwareMap){
        DirectionalLowClaw = hardwareMap.get(Servo.class, "EH_servo1");
        LowClaw = hardwareMap.get(Servo.class, "EH_servo2");
        LowArm = hardwareMap.get(Servo.class, "EH_servo0");
    }

    //Apucare automata Sample
    public void automateGripper() {
        switch (ClewTime.getStep()) {
            case 0:
                ClewTime.start();
            case 1:
                LowArm.setPosition(LOW_ARM_ACTION);
                ClewTime.nextStep();
                break;
            case 2:
                if (ClewTime.waitStep(200)) {
                    LowClaw.setPosition(LOW_CLAW_CLOSE);
                    ClewTime.nextStep();
                }
                break;
            case 3:
                if (ClewTime.waitStep(200)) {
                    LowArm.setPosition(LOW_ARM_DOWN);
                    ClewTime.reset();
                }
                break;
        }
    }

    //Descgidere ghiara jos
    public void GripperOpen(){
        LowArm.setPosition(LOW_CLAW_OPEN);
    }
    //Rotire ghiara
    public void Gripper90(){
        DirectionalLowClaw.setPosition(LOW_GRIPPER_90);
    }
    public void Gripper0(){
        DirectionalLowClaw.setPosition(LOW_GRIPPER_0);
    }
    public void Gripper45(){
        DirectionalLowClaw.setPosition(LOW_GRIPPER_45);
    }
}
