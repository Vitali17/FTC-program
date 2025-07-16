package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SliderD {
    private final StepTimer sliderActionTime = new StepTimer();
    private final StepTimer sliderBasketTime = new StepTimer();

    private final Servo sliderL, sliderR, lowArm, directionalLowClaw, lowClaw;
    private static final double SLIDER_LEFT_OUT = 0.72;
    private static final double SLIDER_RIGHT_OUT = 0.28;
    private static final double SLIDER_LEFT_IN = 1.0;
    private static final double SLIDER_RIGHT_IN = 0.0;

    private static final double LOW_ARM_DOWN = 0.12;
    private static final double LOW_ARM_UP = 0.71;

    private static final double LOW_CLAW_OPEN = 1.0;
    private static final double DIRECTIONAL_CLAW_CENTER = 0.5;

    public SliderD(@NonNull HardwareMap hardwareMap) {
        sliderR = hardwareMap.get(Servo.class, "EH_servo3");
        sliderL = hardwareMap.get(Servo.class, "CH_servo0");
        lowArm = hardwareMap.get(Servo.class, "EH_servo0");
        lowClaw = hardwareMap.get(Servo.class, "EH_servo2");
        directionalLowClaw = hardwareMap.get(Servo.class, "EH_servo1");
    }

    // Deschidere slider jos
    public void setActionServos() {
        switch (sliderActionTime.getStep()) {
            case 0:
                sliderActionTime.start();
                break;

            case 1:
                sliderL.setPosition(SLIDER_LEFT_OUT);
                sliderR.setPosition(SLIDER_RIGHT_OUT);
                sliderActionTime.nextStep();
                break;

            case 2:
                if (sliderActionTime.waitStep(20)) {
                    lowArm.setPosition(LOW_ARM_DOWN);
                    lowClaw.setPosition(LOW_CLAW_OPEN);
                    sliderActionTime.reset();
                }
                break;
        }
    }

    // Închidere slider jos (retragere)
    public void setBasketPosition() {
        switch (sliderBasketTime.getStep()) {
            case 0:
                sliderBasketTime.start();
                break;

            case 1:
                lowArm.setPosition(LOW_ARM_UP);
                directionalLowClaw.setPosition(DIRECTIONAL_CLAW_CENTER);
                sliderBasketTime.nextStep();
                break;

            case 2:
                if (sliderBasketTime.waitStep(150)) {
                    sliderL.setPosition(SLIDER_LEFT_IN);
                    sliderR.setPosition(SLIDER_RIGHT_IN);
                    sliderBasketTime.reset();
                }
                break;
        }
    }
}
