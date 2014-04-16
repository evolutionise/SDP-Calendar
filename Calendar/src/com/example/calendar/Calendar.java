package com.example.calendar;

import com.tyczj.extendedcalendarview.*;


import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;



public class Calendar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		// Show the Up button in the action bar.
		setupActionBar();
	}
	
	public void addEvent(){
		ContentValues values = new ContentValues();
	    values.put(CalendarProvider.COLOR, Event.COLOR_RED);
	    values.put(CalendarProvider.DESCRIPTION, "Some Description");
	    values.put(CalendarProvider.LOCATION, "Some location");
	    values.put(CalendarProvider.EVENT, "Event name");

	    Calendar cal = Calendar.getInstance();

	    cal.set(startDayYear, startDayMonth, startDayDay, startTimeHour, startTimeMin);
	    values.put(CalendarProvider.START, cal.getTimeInMillis());
	    values.put(CalendarProvider.START_DAY, julianDay);
	    TimeZone tz = TimeZone.getDefault();

	    cal.set(endDayYear, endDayMonth, endDayDay, endTimeHour, endTimeMin);
	    int endDayJulian = Time.getJulianDay(cal.getTimeInMillis(), TimeUnit.MILLISECONDS.toSeconds(tz.getOffset(cal.getTimeInMillis())));

	    values.put(CalendarProvider.END, cal.getTimeInMillis());
	    values.put(CalendarProvider.END_DAY, endDayJulian);

	    Uri uri = getContentResolver().insert(CalendarProvider.CONTENT_URI, values);
	}



	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
