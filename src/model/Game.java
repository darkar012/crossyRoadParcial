package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.PApplet;

public class Game extends PApplet{
	
	private Date date;
	private Date duration;
	private Date hour;
	private PApplet app;
	private int posY;
	
	public Game(int posY, Date date, Date durationPreset, Date hour,PApplet app) {
		this.posY = posY;
		this.date = date;
		this.duration = durationPreset;
		this.hour= hour;
	}
	
	public void writeGame(PApplet app) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(this.date);
		app.fill(0);
		app.text(date, 200, posY);
		//System.out.println(date);
		
		SimpleDateFormat hourformat = new SimpleDateFormat("HH:mm:ss");
		String hour = hourformat.format(this.hour);
		app.text(hour, 340, posY);
		
		SimpleDateFormat durationformat = new SimpleDateFormat("HH:mm:ss");
		String duration = durationformat.format(this.duration);
		app.text(duration, 450 , posY);
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
