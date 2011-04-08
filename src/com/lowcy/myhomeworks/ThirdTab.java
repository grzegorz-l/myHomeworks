package com.lowcy.myhomeworks;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdTab extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is third tab");
        setContentView(textview);
    }
}