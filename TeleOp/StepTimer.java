package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.util.ElapsedTime;

public class StepTimer {
    private int step = 0;
    private double stepStartTime;
    private final ElapsedTime timer = new ElapsedTime();

    public void start() {
        step = 1;
        stepStartTime = timer.milliseconds();
    }

    public boolean waitStep(long durationMs) {
        return timer.milliseconds() - stepStartTime > durationMs;
    }

    public void nextStep() {
        step++;
        stepStartTime = timer.milliseconds();
    }

    public int getStep() {
        return step;
    }

    public boolean isBusy() {
        return step > 0;
    }

    public void reset() {
        step = 0;
    }
}