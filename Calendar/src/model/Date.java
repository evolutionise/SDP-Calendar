package model;

/*
 * A class to make handling the time and date easier
 */



public class Date {

	int year;
	int month;
	int day;
	int hour;
	int minute;
	
	public Date(int year, int month, int day, int hour, int minute){
		year = this.year;
		month = this.month;
		day = this.day;
		hour = this.hour;
		minute = this.minute;	
		
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
	
	public int getMins(){
		return minute;
	}
	
//	public enum Months {
//		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
//	}
//	
//	public int getMonth(){
//		
//	}
}