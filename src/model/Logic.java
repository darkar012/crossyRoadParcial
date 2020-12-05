package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import exception.Lost;
import exception.Win;
import processing.core.PApplet;

public class Logic extends PApplet{

	private PApplet app;
	private Hero hero;
	private String[] road;
	private ArrayList<Car> carList;  
	private LinkedList<Game>gameList;
	private ByDateComparator BD;
	private ByHour BH;
	private int posY;
	private int change;
	private int day;
	private int month;
	private int year;
	private Date duration;
	private boolean win;
	private boolean lose;
	private int sec = 0;
	private int min = 0;
	private int hour = 0;

	public Logic (PApplet app) {

		this.app = app;
		road = app.loadStrings("../data/road.txt");
		carList=new ArrayList<Car>();
		gameList = new LinkedList<Game>();
		BD = new ByDateComparator();
		BH = new ByHour();
		change =1;
		win=false;
		lose = false;
		day = app.day();
		month = app.month();
		year = app.year();
		
		try {
			readTXT();
		} catch (Exception runtimeException) {
			// TODO: handle exception
		}
		
		dateHourPreset();
	}	
	
	public void dateHourPreset() {
		String dateString = 15+"-"+11+"-"+2021;
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date datePreset= null;
		
		try {
			datePreset = format.parse(dateString);
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 Date hourPreset = new Date();
		 
		 String durationString = 00+":"+10 +":"+00;
		 DateFormat durationFormat = new SimpleDateFormat("HH:mm:ss");
		 Date durationPreset= null;
		 try {
				durationPreset = durationFormat.parse(durationString);
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex);
			}
		 
		gameList.add(new Game(datePreset, durationPreset , hourPreset,this.app));
	}
	
	public void newGame() {
		String dateString = day+"-"+month+"-"+year;
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = format.parse(dateString);
			//System.out.println(format.format(date));
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 Date date2 = new Date();
		  //System.out.println(dateFormat.format(date2));
			
	
			 gameList.add(new Game(date, duration , date2, this.app));
		
	}
	
	public void durationCounter() {
		
		//System.out.println(frameCount);
		if (app.frameCount % 60 == 0) {
			sec += 1;
		}
		if (sec == 60) {
			sec = 0;
			min += 1;
		}
		if (min == 60) {
			min = 0;
			hour += 1;
		}
		app.textSize(20);
		app.text(hour+":"+min+":"+sec, 700, 50);

		String durationString = hour+":"+min +":"+sec;
		 DateFormat durationFormat = new SimpleDateFormat("HH:mm:ss");
		 duration= null;
		 try {
				duration = durationFormat.parse(durationString);
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex);
			}
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
	}

	public void paintGame() {
		hero.paintChar();
		
		durationCounter();
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).paintChar();
			Thread car = new Thread(carList.get(i));
			car.start();
		}
		
		try {
			winLostValidation();
		} catch (Win e) {
			change=2;
			win =true;
			
		} catch (Lost e) {
			change=3;
			lose = true;
			
		}
		
	}
	
	public void winLostValidation() throws Win, Lost {
		if (hero.getPosY() >= 530) {
			newGame();
			throw new Win("ganaste");
		}
		for (int i = 0; i < carList.size(); i++) {
			
			int heroX = hero.getPosX();
			int heroY = hero.getPosY();
			int carX = carList.get(i).getPosX();
			int carY = carList.get(i).getPosY();
			
			if (app.dist(heroX, heroY, carX, carY) <= hero.getSize()) {
				newGame();
				throw new Lost ("perdiste");
			}
		}
		
	}
	
	public void paintRegister() {
		for (int i = 0; i < gameList.size() ; i++) {
			gameList.get(i).writeGame(300+(30*i));
		}
	}
	
	public void key(int key) {
		hero.setKey(key);
		hero.moveChar();
		
		if (win == true || lose == true) {
			if (key==69) {
				app.exit();
			}
			if (key==82) {
				restart();
			}
			if (key == 68) {
				change = 4;
			}
			
			sortList(key);
		}
		
	}
	
	private void sortList(int key) {
		switch (key) {
		
		case 71: {
			Collections.sort(gameList);
		}
		break;
		case 70: {
			Collections.sort(gameList,BD);
		}
		break;
		case 72: {
			Collections.sort(gameList,BH);
		}
		break;
		default:
		
		}
		
	}

	public void restart() {
		
		road = app.loadStrings("../data/road.txt");
		carList=new ArrayList<Car>();
		change =1;
		win=false;
		lose = false;
		day = app.day();
		month = app.month();
		year = app.year();
		
		readTXT();
		
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}
	
	
	
}
