package com.example.calendar;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Menu class show the main menu of the application.
 * 
 */
public class Menu extends FragmentActivity {
	
	public static Context context;
	private FacebookFragment fbFragment;
	public Session session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		context = this;
		
		ActionBar actionBar = getActionBar();
		actionBar.hide(); //Hides the top bar.
		setContentView(R.layout.activity_menu);
		
		//Checks current Facebook session and sends user straight to calender if already logged in.
		session = Session.getActiveSession();
		if(session != null && session.isOpened()){
			Intent intent = new Intent(this, Calendar.class);
			startActivity(intent);
		}
	}

	/*
	 * Sends user to the Calendar once they log in with Facebook.
	 * 
	 * @see android.support.v4.app.FragmentActivity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
		
		if(session != null && session.isOpened()){
			Intent intent = new Intent(this, Calendar.class);
			startActivity(intent);
		}
	}
	
	/*
	 * Inflate the menu; this adds items to the action bar if it is present.
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.menu, (android.view.Menu) menu);
		return true;
	}
	
	/*
	 * When Log in button is clicked user is sent to Facebook login page.
	 */
	public void loginAction(View view){
		
		CharSequence loginText = "Login";
		
		Toast calendarToast = Toast.makeText(this, loginText, Toast.LENGTH_SHORT);
		calendarToast.show();
		

	    fbFragment = new FacebookFragment();
	    getSupportFragmentManager()
	    .beginTransaction()
	    .add(android.R.id.content, fbFragment)
	    .commit();    
	}
	

	/*
	 * When Calendar button is clicked user is sent to Calendar.
	 * 
	 */
	public void calendarAction(View view){
		
		CharSequence calendarText = "Calendar";
		
		Toast calendarToast = Toast.makeText(this, calendarText, Toast.LENGTH_SHORT);
		calendarToast.show();
		
		Intent intent = new Intent(this, Calendar.class);
		startActivity(intent);
	}
	
	/*
	 * User is sent to the create event page.
	 * 
	 */
	public void createEventAction(View view){
		
		CharSequence createEventText = "Create Event";
		
		Toast createEventToast = Toast.makeText(this, createEventText, Toast.LENGTH_SHORT);
		createEventToast.show();
		
		Intent intent = new Intent(this, Events.class);
		startActivity(intent);
	}
	
	/*
	 * Shows toast of developers for this application.
	 * 
	 */
	public void devAction(View view){
		
		CharSequence devText = "Alix Klingenberg, Charlotte Paterson, Farah Qoulaq, Jaspreet Walia";
		
		Toast devToast = Toast.makeText(this, devText, Toast.LENGTH_SHORT);
		devToast.show();
	}
	
}	
	
	
	


