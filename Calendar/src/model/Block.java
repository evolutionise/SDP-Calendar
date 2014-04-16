package model;

import java.util.ArrayList;



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
	private Date blockDate; //date and time of the event or task
	
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
			int minute){
		blockTitle = this.blockTitle;
		Date blockDate = new Date(year, month, day, hour, minute);
		
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
		return blockLocation;
	}
	
	public int getYear(){
		return blockDate.getYear();
	}
	
	public int getMonth(){
		return blockDate.getMonth();
	}
	
	public int getDay(){
		return blockDate.getDay();
	}
	
	public int getHour(){
		return blockDate.getHour();
	}
	
	public int getMinutes(){
		return blockDate.getMins();
	}
	
	/*
	 * Getter method for Date
	 */
	
	public Date getDate(){
		
		return blockDate;		
	}
	
	/*
	 * Setter for Title
	 */
	
	public void setTitle(String newTitle){
		blockTitle = newTitle;
	}
	
	
	/*
	 * Method to get all events in a month
	 * 
	 * @Param: 
	 */
	
	public static ArrayList<Block> getBlocksInMonth(){
		//insert code to request from database
		ArrayList<Block> blocks = new ArrayList<Block>();
		//hard-coding some examples for testing as DB is not running
		Block exampleEvent = new Event("Example Location", "Example Title", "Example Description", 2014, 4, 15, 14, 30);
		Block exampleTask = new Event("Example Title", "Example Location", "Example Task Title", 2014, 4, 16, 11, 15);
		blocks.add(exampleEvent);
		blocks.add(exampleTask);
		return blocks;
	}

}
