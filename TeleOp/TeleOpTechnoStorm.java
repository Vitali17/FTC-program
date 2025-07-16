package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp")
public class TeleOpTechnoStorm extends OpMode {

    MecanumDrive drive;
    SliderD SliderHorizontal;
    ClewD ClewDown;
    SliderU SliderUp;
    Init Start;

    @Override
    public void init() {

        drive = new MecanumDrive(hardwareMap);
        SliderHorizontal = new SliderD(hardwareMap);
        ClewDown = new ClewD(hardwareMap);
        SliderUp = new SliderU(hardwareMap);
        Start = new Init(hardwareMap);

        Start.Initialization();
    }

    @Override
    public void loop() {
        drive.drive(gamepad1.right_stick_x, -gamepad1.left_stick_x, -gamepad1.left_stick_y,
                gamepad1.right_trigger > 0 ? 3.5 : 1);

        if(gamepad2.dpad_up) SliderHorizontal.setActionServos();
        if(gamepad2.dpad_down) SliderHorizontal.setBasketPosition();

        if(gamepad2.left_trigger>0) ClewDown.automateGripper();
        if(gamepad2.right_trigger>0) ClewDown.GripperOpen();

        if(gamepad2.cross) ClewDown.Gripper90();
        if(gamepad2.triangle) ClewDown.Gripper0();
        if(gamepad2.circle) ClewDown.Gripper45();

        if(gamepad2.left_bumper) SliderUp.automateTransfer();
        if(gamepad2.right_bumper) SliderUp.ResetSlider();
        if(gamepad1.circle) SliderUp.automateclimb();
    }
}
