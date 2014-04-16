package com.example.calendar;




import model.AddingEvents;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.support.v4.app.NavUtils;

public class Events extends Activity implements OnClickListener {
	
	Button save;
	EditText title, location, date;
	TimePicker time;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		title = (EditText) findViewById(R.id.editText1);
		location = (EditText) findViewById(R.id.editText2);
		date = (EditText) findViewById(R.id.editText3);
		
		save.setOnClickListener(this);
		
		save = (Button) findViewById(R.id.button4);
		  save.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	            	Intent myIntent = new Intent(view.getContext(), DisplayMessageActivity.class);
	                startActivityForResult(myIntent, 0);
	            }

	        });
		
		
		Button menu = (Button) findViewById(R.id.button2);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent myIntent = new Intent(view.getContext(), Menu.class);
                startActivityForResult(myIntent, 0);
            }

        });
     
        Button login = (Button) findViewById(R.id.button1);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
            }

        });
        Button calendar = (Button) findViewById(R.id.button3);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	Intent myIntent = new Intent(view.getContext(), Calendar.class);
                startActivityForResult(myIntent, 0);
            }

        });
	}
	
	public void onClick (View v) {
		switch (v.getId()) {
		case R.id.button4: 
			boolean didItWork = true;
			try{
			String event = title.getText().toString();
			String loc = location.getText().toString();
			String dat = date.getText().toString();
			int tim = time.getBaseline();
			
			AddingEvents entry = new AddingEvents(Events.this);
			
			entry.open();
			entry.createEvent(event, loc, dat, tim);
			entry.close();
			}catch (Exception e) {
				didItWork = false;
			}finally{
				if(didItWork) {
					Dialog d = new Dialog(this);
					d.setTitle("event saved!");
					TextView tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
					
				}
			}
			break;
		}
		
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
