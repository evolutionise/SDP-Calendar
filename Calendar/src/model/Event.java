package model;

public class Event extends Block{
	String location;

	public Event(String location,
			String eventTitle, 
			int year,
			int month,
			int day,
			int hour,
			int minute){
		
		
		super(eventTitle, year, month, day, hour, minute);
		location = this.location;
	}
}
