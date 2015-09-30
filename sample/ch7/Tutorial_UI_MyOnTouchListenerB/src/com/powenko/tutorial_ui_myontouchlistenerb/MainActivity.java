package com.powenko.tutorial_ui_myontouchlistenerb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements  OnTouchListener {

	
	private ImageView imageView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView1=(ImageView) findViewById(R.id.imageView1 );
		imageView1.setOnTouchListener(this);
		  
	}  
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		ImageView t_v=(ImageView) v;
		if(t_v==imageView1){
			Toast.makeText(getApplicationContext(), "Hi!  PowenKo.com", Toast.LENGTH_SHORT).show();
		}
		
				
				
		return false;
	}

}
