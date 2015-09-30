package com.powenko;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class TutorialActionBarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    ////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_powen1:
            Toast.makeText(getApplicationContext(), "Hello toast! menu_powen1", Toast.LENGTH_SHORT).show();
       	return true;
        case R.id.menu_powen2:
            Toast.makeText(getApplicationContext(), "Hello toast! menu_powen2", Toast.LENGTH_SHORT).show();
       	return true;
        case R.id.menu_powen3:
            Toast.makeText(getApplicationContext(), "Hello toast! menu_powen3", Toast.LENGTH_SHORT).show();
       	return true;
       default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    
}