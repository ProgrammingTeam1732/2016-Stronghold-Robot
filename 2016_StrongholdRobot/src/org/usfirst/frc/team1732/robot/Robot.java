package org.usfirst.frc.team1732.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	CANTalon left1;  CANTalon left2;  CANTalon left3;
	CANTalon right1; CANTalon right2; CANTalon right3;

	CANTalon intake1; CANTalon intake2; Solenoid intakeS;

	CANTalon catapult1; CANTalon catapult2; Solenoid catapultS;

	Solenoid shifting;
	
	AnalogInput halleffect;

	long time;
	long startTime;

	public void robotInit() {
		// ports not set
		left1  = new CANTalon(10); left2  = new CANTalon(11); left3  = new CANTalon(12);
		right1 = new CANTalon(13); right2 = new CANTalon(14); right3 = new CANTalon(15);

		catapult1 = new CANTalon(16); catapult2 = new CANTalon(17); catapultS = new Solenoid(20);

		intake1 = new CANTalon(18); intake2 = new CANTalon(19); intakeS = new Solenoid(22);

		shifting = new Solenoid(21);
		
		halleffect = new AnalogInput(0);
		SmartDashboard.putBoolean("magnet?", false);
	}
	
	public void autonomousInit() {
		startTime = System.currentTimeMillis();
	}

	public void autonomousPeriodic() {
		time = getTime(); // Time in milliseconds since start of autonomous
	}
	
    public void teleopPeriodic() {
    	if(halleffect.getVoltage() >= 2) SmartDashboard.putBoolean("magnet?", false); //No Magnet if ~3.736 v DC
		if(halleffect.getVoltage() < 2) SmartDashboard.putBoolean("magenet?", true); //Magnet if ~0.203 v DC
    }
    
	private void setMotor(double left, double right) {
		left1.set(left * -1);
		left2.set(left * -1);
		left3.set(left * -1);
		right1.set(right);
		right2.set(right);
		right3.set(right);
	}

	private void setCatapult(double one, double two) {
		catapult1.set(one * -1);
		catapult2.set(two);
	}

	private void setIntake(double one, double two) {
		intake1.set(one * -1);
		intake2.set(two);
	}
	
	private long getTime() {return System.currentTimeMillis() - startTime;}

}