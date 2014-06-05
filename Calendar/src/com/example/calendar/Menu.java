package com.example.calendar;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

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


public class Menu extends FragmentActivity {
	
	public static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		context = this;
	//shows login page.
		Session.openActiveSession(this, true, new Session.StatusCallback() {

		      // callback when session changes state
		      @Override
		      public void call(Session session, SessionState state, Exception exception) {
		        if (session.isOpened()) {

		          Request.newMeRequest(session, new Request.GraphUserCallback() {

		            // callback after Graph API response with user object
		            @Override
		            public void onCompleted(GraphUser user, Response response) {
//		              if (user != null) {
//		                TextView welcome = (TextView) findViewById(R.id.welcome);
//		                welcome.setText("Hello " + user.getName() + "!");
//		              }
		            }
		          }).executeAsync();
		        }
		      }
		    });
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}
	

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, (android.view.Menu) menu);
		return true;
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
	
	
	


