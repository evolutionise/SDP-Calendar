package database;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.calendar.Menu;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;

import model.Block;
import model.Event;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

/**
 * Class handles all the events added to database
 * 
 * @author Charlotte, Jaspreet, Alix, Farah
 *
 */
public class DatabaseHandler {

	public static final String TITLE = "title";
	public static final String LOCATION = "location";
	public static final String DESCRIPTION = "description";
	public static final String YEAR ="year";
	public static final String MONTH ="month";
	public static final String DAY ="day";
	public static final String HOUR ="hour";
	public static final String MINUTE ="minute";
	public static final String TAG ="tag";
	public static final String TABLE_NAME = "event";
	public static final String DATABASE_NAME = "eventdb";
	public static final int DATABASE_VERSION = 5;
	public static final String TABLE = "create table event(title TEXT, location TEXT, description TEXT, year INT, month INT, day INT, hour INT, minute INT, tag TEXT);";
	
	private static DatabaseHelper dbhelper; 
	private static SQLiteDatabase db;
	
	/**
	 * Create Database.
	 */
	private DatabaseHandler() {
		dbhelper = new DatabaseHelper();
		db = dbhelper.getWritableDatabase();
	}
	
	/**
	 * Creating Table and verifying the database.
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper() {
			super(Menu.context, DATABASE_NAME,null,DATABASE_VERSION);
			//onUpgrade(getWritableDatabase(),0,0);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			try{
			db.execSQL(TABLE);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS event");
			onCreate(db);
			
		}
		
	}
	
	/**
	 * 
	 * @return The database.
	 */
	private static SQLiteDatabase getDB() {
		if (db == null) {
			new DatabaseHandler();
		}
		return db;
	}
	
	private void close() {
		dbhelper.close();
	}
	
	public static long insertEvent(Event event) {
		ContentValues content = new ContentValues(); 
		content.put(TITLE, event.getTitle());;
		content.put(LOCATION, event.getLocation());
		content.put(YEAR, event.getYear());
		content.put(MONTH, event.getMonth());
		content.put(DAY, event.getDay());
		content.put(HOUR, event.getHour());
		content.put(MINUTE, event.getMinutes());
		content.put(DESCRIPTION, event.getDescription());
		content.put(TAG, event.getTag());
		return getDB().insert(TABLE_NAME, null, content);
	}
	
	public static List<Event> getEventsInMonth(int month, int year) {
		//Select * From event Where Month=month And Year=year
		List<Event> events = getEvents();
	    for (Event event: events) {
			if(event.getMonth() != month && event.getYear() != year) {
				events.remove(event);
			}
		}
		return events;
		//return record set
	}
	
	public static void addFacebookEvents(){
		
		Session session = Session.getActiveSession();

		if (session.isOpened()) {
	          // make request to the /me API
	          Request.newMeRequest(session, new Request.GraphUserCallback() {
	            // callback after Graph API response with user object

				@Override
				public void onCompleted(GraphUser user, Response response) {
					// TODO Auto-generated method stub
					if (user != null) {
						String fqlQuery = "select eid, name, description, start_time, location from event where eid in (select eid from event_member where uid=me())";
						Bundle params = new Bundle();
						params.putString("q", fqlQuery);
						
						Session session = Session.getActiveSession();
						Request request = new Request(session, 
						    "/fql", 
						    params, 
						    HttpMethod.GET, 
						    new Request.Callback(){ 
							public void onCompleted(Response response) {
								
								try
							    {
							        GraphObject go  = response.getGraphObject();
							        JSONObject  jso = go.getInnerJSONObject();
							        JSONArray   arr = jso.getJSONArray( "data" );

							        for ( int i = 0; i < ( arr.length() ); i++ )
							        {
							            JSONObject json_obj = arr.getJSONObject(i);
							            String id     = json_obj.getString("eid");
							            String name   = json_obj.getString("name");
							            String description = json_obj.getString("description");
							            String startTime = json_obj.getString("start_time");
							            int year = 0;
							            int month = 0;
							            int day = 0;
							            if(startTime != null){
							            	String[] time = startTime.split("-|T");
							            	if(time.length > 2){
							            		year = Integer.parseInt(time[0]);
							            		month = Integer.parseInt(time[1]);
							            		day = Integer.parseInt(time[2]);
							            	}
							            	
							            }
							            
							            String location = json_obj.getString("location");
							            Event tempEvent = new Event(name, location, description, year, month, day, 0, 0, "Facebook");
							            //Checks that the event has not already been created.
							            for(Event e: getEvents()){
							            	if(e.getTag().equals("Facebook")){
							            		if(!(e.getTitle().equals(name) && e.getDay() == day)){
							            			insertEvent(tempEvent);
							            		}
							            	}
							            } 
							        }
							        
							    }
							    catch (Throwable t )
							    {
							        t.printStackTrace();
							    }
						    }
							
						});
						Request.executeBatchAsync(request);
		            }
				}
	          }).executeAsync();
		}
	}
	
	public static List<Event> getEvents() {
		Cursor cursor = getDB().query(TABLE_NAME, new String[] {TITLE, LOCATION, DESCRIPTION, YEAR, MONTH, DAY, HOUR, MINUTE, TAG}, null, null, null, null, null);
		List<Event> events = new ArrayList<Event>();
		while (cursor.moveToNext()) {
			Event event = new Event(
					cursor.getString(0), 
					cursor.getString(1),
					cursor.getString(2),
					cursor.getInt(3),
					cursor.getInt(4),
					cursor.getInt(5),
					cursor.getInt(6),
					cursor.getInt(7),
					cursor.getString(8));
			events.add(event);
		}
		return events;
	}


}
