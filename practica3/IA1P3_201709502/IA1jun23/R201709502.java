package IA1jun23;
import robocode.*;
import java.awt.Color;
import java.util.Random;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.util.Random;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
//
/**
 * R201709502 - a robot by Anggelo Santiago Son Mux
 */
public class R201709502 extends AdvancedRobot
{
	boolean der = true;
	boolean chocafrente = false;
	boolean chocalado = false;
	double movmax;
	
	public void run() {
		setBodyColor(new Color(91, 130, 250));
		setGunColor(new Color(223, 159, 53));
		setRadarColor(new Color(223, 53, 53));
		
		movmax = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		// Robot main loop
		int min = -500;
      	int max = 500;
		while(true) {
			int numeroAleatorio= (int)Math.floor(Math.random() * (max - min + 1) + min);
			
			out.print(numeroAleatorio);
			if (der){
				ahead(numeroAleatorio);
				setTurnRight(numeroAleatorio);
				setTurnRight(numeroAleatorio);
			}else{
				back(numeroAleatorio);
				setTurnLeft(numeroAleatorio);
				setTurnLeft(numeroAleatorio);
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	/*	setTurnGunRight(getHeading() - getGunHeading() + e.getBearing());
		setTurnRight(getHeading() - getGunHeading());
		//setAhead(e.getDistance() - 200);
	
		if (e.getDistance() < 150){
			fire(1);
			fire(1);
		}else{
		//	setAhead(e.getDistance() - 100);
		}*/
		fire(1);
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		if (getEnergy() < 45){
			setTurnRight(getHeading() - getGunHeading());
			setBack(movmax/5);
			setTurnRight(100);
			setBack(movmax/5);
		}	

		if (der){
			der = false;
		}else{
			der = true;
		}
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
	/*	if (chocafrente){
			if (chocalado){
				turnGunRight(100);
				chocalado = false;
			}else{
				turnGunLeft(100);
				chocalado = true;
			}
			back(100);
			chocafrente = false;
		}else{
			if (chocalado){
				turnGunRight(100);
				chocalado = false;
			}else{
				turnGunLeft(100);
				chocalado = true;
			}
			ahead(100);
			chocafrente = true;
		}
		//back(20);*/
		
		if(e.getBearing() > -90 && e.getBearing() <90 ){
			setBack(movmax/5);
			setTurnRight(100);
			setBack(movmax/5);
		}else{
			setAhead(movmax/5);
			setTurnRight(100);
			setAhead(movmax/5);
		}
	}
	
	public void onHitRobot (HitRobotEvent e){
	/*	if (chocafrente){
			if (chocalado){
				turnGunRight(100);
				chocalado = false;
			}else{
				turnGunLeft(100);
				chocalado = true;
			}
			back(100);
			chocafrente = false;
		}else{
			if (chocalado){
				turnGunRight(100);
				chocalado = false;
			}else{
				turnGunLeft(100);
				chocalado = true;
			}
			ahead(100);
			chocafrente = true;
		}*/
	
		if(e.getBearing() > -90 && e.getBearing() <90 ){
			setBack(movmax/5);
			setTurnRight(100);
			setBack(movmax/5);
		}else{
			setAhead(movmax/5);
			setTurnRight(100);
			setAhead(movmax/5);
		}
	}
}
