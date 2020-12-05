package model;

import processing.core.PApplet;

public abstract class Character extends PApplet {

	protected PApplet app;
	protected int posX;
	protected int posY;
	protected int speed;

	public Character (int posX, int posY, int speed, PApplet app){
		this.posX=posX;
		this.posY=posY;
		this.speed=speed;
		this.app=app;
	}
	
	public abstract void moveChar();
	public abstract void paintChar();

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
