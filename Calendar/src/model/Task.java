package model;

public class Task extends Block{
	
	public Task(String eventTitle, 
			String eventLocation,
			String eventDescription,
			int year,
			int month,
			int day,
			int hour,
			int minute) {
		
		super(eventTitle, eventLocation, eventDescription, year, month, day, hour, minute);
	}
	

}
