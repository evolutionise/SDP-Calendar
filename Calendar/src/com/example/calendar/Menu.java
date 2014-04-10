package com.example.calendar;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, (android.view.Menu) menu);
		return true;
	}
	
public void loginAction(View view){
		
		CharSequence loginText = "Login";
		
		Toast loginToast = Toast.makeText(this, loginText, Toast.LENGTH_SHORT);
		loginToast.show();
		
		Intent intent = new Intent(this, Login.class);
		startActivity(intent);
	}
	
	public void calendarAction(View view){
		
		CharSequence calendarText = "Calendar";
		
		Toast calendarToast = Toast.makeText(this, calendarText, Toast.LENGTH_SHORT);
		calendarToast.show();
		
		Intent intent = new Intent(this, Calendar.class);
		startActivity(intent);
	}

	public void createEventAction(View view){
		
		CharSequence createEventText = "Create Event";
		
		Toast createEventToast = Toast.makeText(this, createEventText, Toast.LENGTH_SHORT);
		createEventToast.show();
		
		Intent intent = new Intent(this, Events.class);
		startActivity(intent);
	}
	
	public void devAction(View view){
		
		CharSequence devText = "Alix Klingenberg, Charlotte Paterson, Farah Qoulaq, Jaspreet Walia";
		
		Toast devToast = Toast.makeText(this, devText, Toast.LENGTH_SHORT);
		devToast.show();
	}

}
