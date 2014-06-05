package model;

import java.util.ArrayList;

import database.DatabaseHandler;



/*
 * Class added by Alix
 * 
 * V2.0 - created at uni as Git did not push what I wrote last night
 * 
 * 14/4/14
 */

public abstract class Block {
	
	private String blockTitle; //title of the event or task
	private String blockLocation; //location of the event or task
	private String blockDescription; //description of the event or task
	protected Date blockDate; //date and time of the event or task
	private String tag;
	private int  year, month, day, hour, minute;
	
	/*
	 * Constructor method - child implementations will add more fields
	 * 
	 * @params 	String blockTitle = title of the event/task
	 * 			int year = year of the event/task
	 * 			int month = month of the event/task
	 * 			int day = day of the event/task
	 * 			int hour = hour of the event/task
	 * 			int minute = minute of the event/task
	 */
	
	public Block(String blockTitle, 
			String blockLocation,
			String blockDescription,
			int year,
			int month,
			int day,
			int hour,
			int minute,
			String tag){
		this.blockTitle = blockTitle;
		this.blockDescription = blockDescription;
		this.blockLocation = blockLocation;
		this.tag = tag;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		blockDate = new Date(year, month, day, hour, minute);
		
	}
	
	/*
	 * Getter method for title
	 */
	public String getTitle(){
		
		return blockTitle;
		
	}
	
	public String getLocation(){
		return blockLocation;
	}
	
	public String getDescription(){
		return blockDescription;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMinutes(){
		return minute;
	}
	
	
	
	/*
	 * Getter method for Date
	 */
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getDate(){
		
		return blockDate;		
	}
	
	/*
	 * Setter for Title
	 */
	
	public void setTitle(String newTitle){
		blockTitle = newTitle;
	}
	
	
	
	


}
