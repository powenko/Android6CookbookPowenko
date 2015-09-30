package com.powenko.tutorial_ui_timepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends Activity {

	private TextView textView1;
	private TimePicker timePicker1;
	private Button button1;
	private int hour;
	private int minute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView1 = (TextView) findViewById(R.id.textView1 );
		timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
		setCurrentTime();
		

		button1 = (Button) findViewById(R.id.button1 );
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
	
	                
	       TimePickerDialog Dialog1=new TimePickerDialog(MainActivity.this,timePickerListener, hour, minute,false);

	       Dialog1.setTitle("Select Time");
	       Dialog1.show();
				
				
				
			}
		});
		
	}
	public void setCurrentTime() {


		final Calendar c = Calendar.getInstance(); 
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		textView1.setText(
	            new StringBuilder().append(pad(hour))
	                .append(":").append(pad(minute)));

	    
		timePicker1.setCurrentHour(hour);
		timePicker1.setCurrentMinute(minute);
		
	}
	private static String pad(int c) {
		if (c >= 10)
		   return String.valueOf(c);
		else
		   return "0" + String.valueOf(c);
	}
	
	private TimePickerDialog.OnTimeSetListener timePickerListener = 
            new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			hour = selectedHour;
			minute = selectedMinute;

			// set current time into textview
			textView1.setText(new StringBuilder().append(pad(hour))
					.append(":").append(pad(minute)));

			// set current time into timepicker
			timePicker1.setCurrentHour(hour);
			timePicker1.setCurrentMinute(minute);

		}
	};

	
}
