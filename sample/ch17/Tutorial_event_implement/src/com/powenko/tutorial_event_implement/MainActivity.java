package com.powenko.tutorial_event_implement;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.powenko.tutorial_event_implement.MyClass.TheListener;

public class MainActivity extends Activity implements TheListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		MyClass mMyClass=new MyClass();
		mMyClass.setTheListener(this);
		  
		mMyClass.DoSomething();
		    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void somethingHappened(String i_string) {
		
        
        TextView mmyTextView=(TextView) findViewById(R.id.textView1); 
        mmyTextView.setText(i_string); 
        
	}

}
