package org.usfirst.frc.team1732.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	CANTalon left1;
	CANTalon left2;
	CANTalon left3;
	CANTalon right1;
	CANTalon right2;
	CANTalon right3;
	
	CANTalon intake1;
	CANTalon intake2;
	
	CANTalon catapult1;
	CANTalon catapult2;
	
	Solenoid catapult;
	
	Solenoid shifting;
	
	Solenoid intake;

	
	long time;
	long startTime;
	
	
	
    public void robotInit() { //ports not set
    	left1 = new CANTalon(10); 
    	left2 = new CANTalon(11);
    	left3 = new CANTalon(12);
    	right1 = new CANTalon(13);
    	right2 = new CANTalon(14);
    	right3 = new CANTalon(15);
    	
    	catapult1 = new CANTalon(16);
    	ctapult2 = new CANTalon(17);
    	
    	intake1 = new CANTalon(18);
    	intake1 = new CANTalon(19);
    	
    	catapult = new Solenoid(20);
    	
    	shifting = new Solenoid(21);
    	
    	intake = new Solenoid(22);
    }

    public void autonomousPeriodic() {
    	time = getTime(); //Simple drive test auton
    	//Not Made yet
    }
    
    public void autonomousInit(){
    	startTime = System.currentTimeMillis() - startTime;
    }
    
    
    private long getTime() {
    	return 0;
    }
    
    private void setMotor(double left, double right) {
    	left1.set(left * -1);
    	left2.set(left * -1);
    	left3.set(left * -1);
    	right1.set(right);
    	right2.set(right);
    	right3.set(right);
    }
    
    private void setCatapult(double 1, double 2){
    	catapult1.set(1 * -1);
    	catapult2.set(2);
    }
    
    private void setIntake(double 1, double 2){
    	intake1.set(1 * -1);
    	intake2.set(2);
    }
    
    
}
