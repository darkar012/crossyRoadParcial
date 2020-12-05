package model;

import processing.core.PApplet;

public class Hero extends Character {

	private int size;
	
	public Hero(int posX, int posY, int speed, PApplet app) {
		super(posX,posY,speed,app);
		size=40;
	}

	public void moveChar() {
		
		switch (key) {
		
		case 39: {
			posX += speed+10;
			if(posX >= 800){
				posX -= speed+10;					
			}
		}
		break;
		case 37: {
			posX -=speed+10;
			if(posX <= 0){
				posX +=speed+10;
			}
		}
		break;
		case 40: {
			posY +=speed+10;
		}
		
		break;
		
		case 38: {
			posY -=speed+10;
			if(posY <= 0){
				posY += speed+10;					
			}
		}
		
		break;
		default:
		}
		
	}

	public void paintChar() {
		
		app.fill (255,0,0);
		app.ellipse(posX, posY, 40, 40) ;
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
