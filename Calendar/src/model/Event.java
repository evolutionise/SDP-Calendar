package model;

public class Event extends Block{


	public Event(String eventTitle, 
			String eventLocation,
			String eventDescription,
			int year,
			int month,
			int day,
			int hour,
			int minute,
			String tag){
		
		
		super(eventTitle, eventLocation, eventDescription, year, month, day, hour, minute, tag);
		System.out.println("year:" + year);
		System.out.println("Month:" + month);
		System.out.println("Day:" + day);
		System.out.println("hour:" + hour);
		System.out.println("min:" + minute);

	}
}
