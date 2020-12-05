package model;

import processing.core.PApplet;

public class Hero extends Character {

	public Hero(int posX, int posY, int speed, PApplet app) {
		super(posX,posY,speed,app);
	}

	public void moveChar() {
	}

	public void paintChar() {
		
		app.fill (255,0,0);
		app.ellipse(posX, posY, 40, 40) ;
		
	}

}
