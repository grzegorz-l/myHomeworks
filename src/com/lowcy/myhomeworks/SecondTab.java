package com.lowcy.myhomeworks;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class SecondTab extends Activity {
	
	private DatePicker date;
	private EditText title;
	private EditText desc;
	private Button button1;
	SQLiteDatabase db;
	private DatabaseHelper dbhelper;
	
	public OnClickListener listener1 = new OnClickListener() {
		public void onClick(View v) {
			date = (DatePicker)findViewById(R.id.date_picker01);
			title = (EditText)findViewById(R.id.tytul);
			desc = (EditText)findViewById(R.id.opis);
			dbhelper = new DatabaseHelper(getApplicationContext());
			db = dbhelper.getWritableDatabase();
			if (dbhelper.addNote(db, title.getText().toString(), desc.getText().toString(), date.toString()) != -1)
				Toast.makeText(getApplicationContext(), "Zadanie zostalo dodane", Toast.LENGTH_SHORT).show();
			else 
				Toast.makeText(getApplicationContext(), "Zadanie nie zostalo dodane", Toast.LENGTH_SHORT).show();
			db.close();
		}
	};
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second);
        button1 = (Button)findViewById(R.id.dodaj);
        button1.setOnClickListener(listener1);
    }
}