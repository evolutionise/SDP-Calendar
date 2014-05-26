package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler {
	public static final String TITLE = "title";
	public static final String LOCATION = "location";
	public static final String DATE = "date";
	public static final String TABLE_NAME = "event";
	public static final String DATABASE_NAME = "eventdb";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_CREATE = "create table event(title text not null, location text, date text);";
	
	DatabaseHelper dbhelper; 
	Context ctx;
	SQLiteDatabase db;
	public DatabaseHandler(Context ctx) {
		this.ctx = ctx;
		dbhelper = new DatabaseHelper(ctx);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context ctx){
			super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			try{
			db.execSQL(TABLE_CREATE);
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
	
	public DatabaseHandler open() {
		db = dbhelper.getWritableDatabase();
		return this; 
	}
	
	public void close() {
		dbhelper.close();
	}
	
	public long insertData(String title, String location, String date) {
		ContentValues content = new ContentValues(); 
		content.put(TITLE, title);
		content.put(LOCATION, location);
		content.put(DATE, date);
		return db.insert(TABLE_NAME, null, content);
	}
	
	public Cursor returnData() {
		return db.query(TABLE_NAME, new String[] {TITLE, LOCATION, DATE}, null, null, null, null, null);
	}
	

}
