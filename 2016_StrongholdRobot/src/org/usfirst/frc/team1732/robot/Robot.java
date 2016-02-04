package org.usfirst.frc.team1732.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	CANTalon left1;  CANTalon left2;  CANTalon left3;
	CANTalon right1; CANTalon right2; CANTalon right3;

	CANTalon intake1; CANTalon intake2; Solenoid intakeS;

	CANTalon catapult1; CANTalon catapult2; Solenoid catapultS;
	
	double left, right;
	boolean a;
	
	Joystick controller = new Joystick(0);

	long time;
	long startTime;

	public void robotInit() {
		// ports not set
		left1  = new CANTalon(11); left2  = new CANTalon(15); left3  = new CANTalon(14);
		right1 = new CANTalon(16); right2 = new CANTalon(17); right3 = new CANTalon(12);
		a = false;
		//catapult1 = new CANTalon(16); catapult2 = new CANTalon(17); catapultS = new Solenoid(20);

		//intake1 = new CANTalon(18); intake2 = new CANTalon(19); intakeS = new Solenoid(22);
		
	}
	
	public void autonomousInit() {
		startTime = System.currentTimeMillis();
	}

	public void autonomousPeriodic() {
		time = getTime(); // Time in milliseconds since start of autonomous
	}
	
    public void teleopPeriodic() {
			left = controller.getRawAxis(1);
			right = controller.getRawAxis(5);
			left = left * Math.abs(left);
			right = right * Math.abs(right);
			setMotors(-left, -right);
    }
    
	private void setMotors(double left, double right) {
		left1.set(left);
		left2.set(left);
		left3.set(left);
		right1.set(-right);
		right2.set(-right);
		right3.set(-right);
	}

	private void setCatapult(double one, double two) {
		catapult1.set(one * -1);
		catapult2.set(two);
	}

	private void setIntake(double one, double two) {
		intake1.set(one * -1);
		intake2.set(two);
	}
	
	public void testPeriodic() {
		if (a == false) a = controller.getRawButton(6);
		if (a) setMotors(-0.2, -0.2);
		if (controller.getRawButton(7)) a = false;
    	LiveWindow.run();
    }
	
	private long getTime() {return System.currentTimeMillis() - startTime;}
}