package view;

import controller.GameController;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	public GameController game;
	public PApplet app;
	public int change;
	
    
	public void settings() {
		
		size(800,600);
		
	}

	public void setup() {
		game = new GameController(this);
		change=1;
	}

	public void draw() {
		background(255);
		change = game.getChange();
		switch(change) {
		case 1:{
			fill(0);
			rectMode(CORNER);
			rect(-300, 110 , 1100, 50);
			rect(-300, 175 , 1100, 50);
			rect(-300, 240 , 1100, 50);
			rect(-300, 310 , 1100, 50);
			rect(-300, 375 , 1100, 50);
			rect(-300, 440 , 1100, 50);
			game.paintGame();
			
		}
		break;
		case 2: {
			fill(0, 255, 158);
			rect(100, 100, 1800, 1600);
			fill(0);
			textSize(35);
			text("Has Ganado", 200, 200);
			textSize(20);
			text("Presiona R para reiniciar", 200, 400);
			text("Presiona E para salir", 200, 450);
			text("Presiona D para ver otras partidas", 200, 500);
		}
		break;
		case 3: {
			fill(255, 0, 0);
			rect(100, 100, 1800, 1600);
			fill(255);
			textSize(35);
			text("Has perdido", 200, 200);
			textSize(20);
			text("Presiona R para reiniciar", 200, 400);
			text("Presiona E para salir", 200, 450);
			text("Presiona D para ver otras partidas", 200, 500);
		}
		break;
		case 4: {
			text("Last Games Durations", 300, 100);
			text ("presiona H para ordenar por hora",100,130);
			text ("presiona F para ordenar por fecha",100,155);
			text ("presiona G para ordenar por duración",100,180);
			text("presiona R para reiniciar",470,130);
			text("presiona E para salir",495,155);
			text("Fecha",230,250);
			text("Hora",345,250);
			text("Duración",450,250);
			//System.out.println("2");
			game.paintRegister();
		}
		}
				
	}
	
	public void keyPressed() {
		int key = keyCode;
		game.key(key);
	}
}
