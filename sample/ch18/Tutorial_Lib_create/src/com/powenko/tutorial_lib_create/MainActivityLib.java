package com.powenko.tutorial_lib_create;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivityLib extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_lib);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity_lib, menu);
		return true;
	}

}
