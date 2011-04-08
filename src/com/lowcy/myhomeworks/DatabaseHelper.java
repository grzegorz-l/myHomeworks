package com.lowcy.myhomeworks;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper{

	static final String dbName="notesDB";
	static final String noteTable="Notes";
	static final String colID="_id";
	static final String colTitle="NoteTitle";
	static final String colDesc="NoteDesc";
	static final String colDate="NoteDate";
	
	public DatabaseHelper(Context context) {
		  super(context, dbName, null,1); 
		  }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("CREATE TABLE "+noteTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
				colTitle+" TEXT NOT NULL, "+colDesc+" TEXT NOT NULL, "+colDate+" TEXT NOT NULL);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 
           db.execSQL("DROP TABLE IF EXISTS "+noteTable);
           onCreate(db);
	}
	
	public long addNote(SQLiteDatabase db, String title, String desc, String date)
	{
		ContentValues cv = new ContentValues();
		cv.put(colTitle, title);
		cv.put(colDesc, desc);
		cv.put(colDate, date);
		return db.insert(noteTable, colTitle, cv);
	}
	
	public Cursor getAllNotes()
	 {
		 SQLiteDatabase db=this.getReadableDatabase();
		 
		 return db.query(noteTable, new String [] {colTitle, colDesc, colDate}, null, null, null, null, null);
		
	 }
}
