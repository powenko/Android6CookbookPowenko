package com.powenko.tutorial_layout_add;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button1=(Button)findViewById(R.id.button1);

		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			    LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.linearLayout1);
				LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    View view = inflater.inflate(R.layout.page2 , null, true);
			    linearLayout1.addView(view);
			}});
		

	        
	}



}
