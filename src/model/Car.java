package model;

import processing.core.PApplet;

public class Car extends Character implements Runnable {

	public Car(int posX, int posY, int speed, PApplet app) {
		super(posX, posY, speed, app);
	}

	@Override
	public void moveChar() {
		posX += speed;
		int limitLeft = -200;
		int limitRight = (int)(random (800,1000));
		boolean speedChange = false;
		 if (posX >= limitRight) {
			speed *=-1;
		}
		 if (posX < limitLeft) {
			speed *=-1;
			speedChange = true;
		 }
		 if (speedChange) {
			 speed *= random((float) 0.5,2);
		 }
	}

	public void paintChar() {
		app.fill(255,0,0);
		app.rectMode(CENTER);
		app.rect(posX, posY, 70, 40);
	}

	@Override
	public void run() {
		moveChar();
	}

}
