package view;

import controller.GameController;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	public GameController game;
	public PApplet app;
    
	public void settings() {
		
		size(800,600);
		
	}

	public void setup() {
		game = new GameController(this);
	}

	public void draw() {
		background(255);
		game.paintGame();
	}
	
	public void keyPressed() {
	}
	
	public void keyReleased() {
		int key = keyCode;
	}

}
