package org.usfirst.frc.team1732.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot{
	AnalogInput halleffect;
	int halleffectPort = 0;
	public Robot() {
		halleffect = new AnalogInput(halleffectPort);
	}
	public void autonomous(){
		
	}
	public void operatorControl(){
		if(halleffect.getVoltage() >= 2){ //No Magnet if ~3.736 v DC
			SmartDashboard.putString("Tote hue min", "No Magnet Detectedgit");
		}
		else if(halleffect.getVoltage() < 2){ //Magnet if ~0.203 v DC
			SmartDashboard.putString("Tote hue min", "Magnet Detected");
		}
	}
	public void test(){
		
	}
}
