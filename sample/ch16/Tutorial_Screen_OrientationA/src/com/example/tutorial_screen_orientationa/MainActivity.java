package com.example.tutorial_screen_orientationa;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/////////////////////
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		//////
        //*******************************************************************************
        /* First, get the Display from the WindowManager */
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        /* Now we can retrieve all display-related info */
        int width = display.getWidth();
        int height = display.getHeight();
        //int orientation = display.getOrientation();
        int orientation = display.getRotation();
        switch (orientation) {
            case 0: //No rotation, screen in it's natual position
                Toast.makeText(this, "No rotation", Toast.LENGTH_SHORT).show();
                break;
            case 1: //Rotated 90 deg LEFT
                Toast.makeText(this, "Rotated Left", Toast.LENGTH_SHORT).show();
                break;
            case 2: //Rotated 180 deg UPSIDE DOWN
                Toast.makeText(this, "Upside Down", Toast.LENGTH_SHORT).show();
                break;
            case 3: //Rotated 270 deg RIGHT
                Toast.makeText(this, "Rotated Right", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Oops, rotation code:" + orientation, Toast.LENGTH_SHORT).show();
                break;
        }

       //Landscape (2) or Portrait (1)
        //http://stackoverflow.com/questions/2795833/check-orientation-on-android-phone
       orientation = getResources().getConfiguration().orientation;
        Toast.makeText(this, "Portrait or Landscape:" + orientation, Toast.LENGTH_SHORT).show();
       //*****************************************************************************
		//////
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
