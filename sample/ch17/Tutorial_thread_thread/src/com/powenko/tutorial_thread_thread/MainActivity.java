package com.powenko.tutorial_thread_thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final TextView txt1 = (TextView) findViewById(R.id.textView1 );

	        new Thread(new Runnable() { 
	            public void run(){
	            	
	            	txt1.setText("Thread!!");
	            	
	            }
	    }).start();
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
