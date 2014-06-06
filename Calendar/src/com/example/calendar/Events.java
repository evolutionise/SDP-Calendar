package com.example.calendar;

import model.Event;
import database.DatabaseHandler;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Events extends Activity {
	
	private Button save;
	private EditText title, description, location, year, month, day, hour, minute, tag;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		// Show the Up button in the action bar.
		setupActionBar();
		
		title = (EditText) findViewById(R.id.titleText);
		description = (EditText) findViewById(R.id.descriptionText);
		location = (EditText) findViewById(R.id.locationText);
		year = (EditText) findViewById(R.id.yearText);
		month = (EditText) findViewById(R.id.monthText);
		day = (EditText) findViewById(R.id.dayText);
		hour = (EditText) findViewById(R.id.hourText);
		minute = (EditText) findViewById(R.id.minuteText);
		save = (Button) findViewById(R.id.saveButton);
		tag = (EditText) findViewById(R.id.tagText);
		
		final Context context = getApplicationContext();
		
		save.setOnClickListener(new OnClickListener () {

			@Override
			public void onClick(View view) {
				//System.out.println(year.getText().toString());
				Event newEvent = new Event(
						title.getText().toString(),
						location.getText().toString(),
						description.getText().toString(),
						Integer.parseInt(year.getText().toString()),
						Integer.parseInt(month.getText().toString()),
						Integer.parseInt(day.getText().toString()),
						Integer.parseInt(hour.getText().toString()),
						Integer.parseInt(minute.getText().toString()),
						tag.getText().toString());
				System.out.println(newEvent.getYear());
				
				DatabaseHandler.insertEvent(newEvent);
				Toast.makeText(context, "event inserted", Toast.LENGTH_LONG).show();
				//Intent myIntent = new Intent(view.getContext(), Calendar.class);
				//startActivityForResult(myIntent, 0);
			}
			
		});

		
		
		Button menu = (Button) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent myIntent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(myIntent, 0);
            }

        });
     
        Button login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        Button calendar = (Button) findViewById(R.id.calendarButton);
        calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent myIntent = new Intent(view.getContext(), Calendar.class);
                startActivityForResult(myIntent, 0);
            }

        });
	}
	
	
		
	

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		//getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events, menu);
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
