package com.lowcy.myhomeworks;


import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class FirstTab extends ListActivity {
	
	
	private DatabaseHelper dbhelper;
	private TextView text;

	@Override
	public void onCreate(Bundle icicle)
	{
	super.onCreate(icicle);
	
		setContentView(R.layout.note_entry);
		
		dbhelper = new DatabaseHelper(getApplicationContext());
		Cursor cursor = dbhelper.getAllNotes();
		startManagingCursor(cursor);
		
		//cursor.moveToLast();
		//text = (TextView)findViewById(R.id.title_entry);
		//text.setText(cursor.getString(1));
		String[] columns = new String[] {DatabaseHelper.colTitle , DatabaseHelper.colDate};
		
		int[] to = new int[] { android.R.id.text1, android.R.id.text2};
		
		SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, columns, to);

		setListAdapter(mAdapter);
	}
}
