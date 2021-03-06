package org.firstinspires.ftc.teamcode;

// Importing the needed packages for code

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="Basic: Test Iterative OpMode", group="Iterative Opmode")
@Disabled
public class BasicOpMode_Iterative extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontMotor = null;
    private DcMotor rightFrontMotor = null;
    private DcMotor leftBackMotor = null;
    private DcMotor rightBackMotor = null;

    // Sets variables to 0, to reset them before they are used
    double leftTrigger = 0;
    double rightTrigger = 0;
    double left_stick_x = 0;
    double left_stick_y = 0;
    double right_stick_x = 0;
    double right_stick_y = 0;
    boolean dpad_right;
    boolean dpad_left;
    boolean dpad_up;
    boolean dpad_down;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables

        leftFrontMotor  = hardwareMap.get(DcMotor.class, "lfm");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rfm");
        leftBackMotor  = hardwareMap.get(DcMotor.class, "lbm");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rbm");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");

    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    void moveRegular(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    void moveLeft(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    void moveRight(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }
    
       void moveLeftStrafe(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    void moveRightStrafe(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }
    void moveRCornerStrafeForward(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }
    void moveLCornerStrafeForward(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        leftFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }
    void moveLCornerStrafeBackward(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }
    void moveRCornerStrafeBackward(double power) {
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        leftFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }
        /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        // Assigns the values to the variables that are needed

        rightTrigger = gamepad1.right_trigger;
        leftTrigger = -gamepad1.left_trigger;
        left_stick_x = gamepad1.left_stick_x;
        left_stick_y = gamepad1.left_stick_y;
        right_stick_x = gamepad1.right_stick_x;
        right_stick_y = gamepad1.right_stick_y;
        dpad_left = gamepad1.dpad_left;
        dpad_right = gamepad1.dpad_right;
        dpad_up = gamepad1.dpad_up;
        dpad_down = gamepad1.dpad_down;

        double power = rightTrigger+leftTrigger;
        
        // Setting up Null Zone for the robot
         if (power < 0.05 & power > -0.05) {
             power = 0;
         }

         if (left_stick_x < 0.05 & left_stick_x > -0.05) {
             left_stick_x = 0;
         }

        // allows robot to move fowards and backwards
        if (left_stick_x == 0) {
            moveRegular(power);
        } else if (left_stick_x < 0) {
            moveLeft(power);
        } else if (left_stick_x > 0) {
            moveRight(power);
        if ( (dpad_right = true) & (dpad_up = true) ) {
            moveRCornerStrafeForward(power);
        }

        if ( (dpad_right = true) & (dpad_up = true) ) {
            moveLCornerStrafeForward(power);
        }

        if ( (dpad_right = true) & (dpad_up = true) ) {
            moveLCornerStrafeBackward(power);
        }

        if ( (dpad_right = true) & (dpad_up = true) ) {
            moveRCornerStrafeBackward(power);
        }

        if (dpad_right = true) {
             moveRightStrafe(power);
        }

        if (dpad_left = true) {
             moveLCornerStrafeForward(power);
        }
        

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "power (%.2f)", power);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */

    public void stop() {
         }
        }
}
