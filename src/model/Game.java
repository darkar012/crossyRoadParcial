package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.PApplet;

public class Game extends PApplet implements Comparable<Game>{
	
	private Date date;
	private Date duration;
	private Date hour;
	private PApplet app;
	
	public Game(Date date, Date durationPreset, Date hour,PApplet app) {
		this.app = app;
		this.date = date;
		this.duration = durationPreset;
		this.hour= hour;
	}
	
	public void writeGame(int posY) {
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
	

	public int compareTo(Game nextGame) {
		// TODO Auto-generated method stub
		return this.duration.compareTo(nextGame.getDuration()); 
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
	
}
