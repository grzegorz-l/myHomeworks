package com.lowcy.myhomeworks;

public class Note {
	
	int _id;
	String _title;
	String _desc;
	String _date;
	
	public Note(String Title, String Desc, String Date)
	{
		
		this._title=Title;
		this._desc=Desc;
		this._date=Date;
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
}
