package controller;

import model.Logic;
import processing.core.PApplet;

public class GameController {

	private Logic logic;
	private PApplet app;
	
	public GameController(PApplet app) {
		this.app = app;
		logic= new Logic(app);
	}
	
	public void paintGame() {
		logic.paintGame();
	}
	
}
