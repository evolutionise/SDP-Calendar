package model;

public class Task extends Block{
	int duration; //in minutes
	
	public Task(int duration,
			String taskTitle, 
			int year,
			int month,
			int day,
			int hour,
			int minute) {
		
		super(taskTitle, year, month, day, hour, minute);
		duration = this.duration;
	}
	

}
