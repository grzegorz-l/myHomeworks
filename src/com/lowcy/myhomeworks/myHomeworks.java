package com.lowcy.myhomeworks;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class myHomeworks extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, FirstTab.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("first").setIndicator("First",
                          res.getDrawable(R.drawable.first_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, SecondTab.class);
        spec = tabHost.newTabSpec("second").setIndicator("Second",
                          res.getDrawable(R.drawable.second_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ThirdTab.class);
        spec = tabHost.newTabSpec("third").setIndicator("Third",
                          res.getDrawable(R.drawable.third_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
}