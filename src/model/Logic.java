package model;

import java.util.ArrayList;


import processing.core.PApplet;

public class Logic extends PApplet{

	private PApplet app;
	private Hero hero;
	private String[] road;
	private ArrayList<Car> carList;  
	private int posY;

	public Logic (PApplet app) {

		this.app = app;
		road = app.loadStrings("../data/road.txt");
		carList=new ArrayList<Car>();
		readTXT();

	}

	public void readTXT() {

		for (int i = 0; i < road.length; i++) {
			String[] roadCars = road[i].split(",");
			String[] carString = road[i].split(",");			

			for (int j = 0; j < 36; j++) {
				int number = (int) random(0,carString.length);
				if (carString[number].equals("carro")) {
					int speed = Integer.parseInt(carString[1]);
					
					int posX = 200;
					int posX1 = Integer.parseInt(carString[2]);
					int posX2 = Integer.parseInt(carString[2])+50;
					int posX3 = Integer.parseInt(carString[2])-50;
					int posX4 = Integer.parseInt(carString[2])-70;
 					
					posY = 200;
					int posY1 = Integer.parseInt(carString[3]);
					int posY2 = Integer.parseInt(carString[3]) + 65;
 					int posY3 = Integer.parseInt(carString[3]) - 65;
 					
 					int posYchange = (int)random(1,5);
 					
 					switch (posYchange) {
 					case 1 :
 						posY = posY1;
 						posX = posX3;
 						break;
 					
 					case 2 :
 						posY = posY2;
 						posX = posX1;
 						break;
 					
 					case 3 :
 						posY = posY3;
 						posX = posX2;
 						break;
 						
 					case 4:
 						posX = posX4;
 						break;
 					default:
 					}
 		
					carList.add(new Car(posX, posY, speed, this.app));
					/*for (int k = 0; k < carList.size(); k++) {
						System.out.println(carList.get(k).getPosY());
					}*/
				}
			}

			for (int j = 0; j < roadCars.length; j++) {

				if (roadCars[j].equals("personaje")) {
					int speed = Integer.parseInt(roadCars[1]);
					int posX = Integer.parseInt(roadCars[2]);
					int posY = Integer.parseInt(roadCars[3]);

					hero = new Hero(posX, posY, speed, this.app);
				}
			}

		}
		System.out.println(carList);
	}

	public void paintGame() {
		hero.paintChar();
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).paintChar();
			carList.get(i).moveChar();
		}
	}
}
