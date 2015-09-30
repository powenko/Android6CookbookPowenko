package com.powenko.tutorial_ui_datepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
public class MainActivity extends Activity {
	private TextView textView1;
	private DatePicker datePicker1;
	private Button button1;
	private int year;
	private int month;
	private  int day;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView1 = (TextView) findViewById(R.id.textView1 );
		datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
		setCurrentTime();
		button1 = (Button) findViewById(R.id.button1 );
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
	
	                
				DatePickerDialog Dialog1=
	    		    new DatePickerDialog(MainActivity.this, datePickerListener,
	    		    		year, month,day);

	       Dialog1.setTitle("Select Time");
	       Dialog1.show();
				
				
				
			}
		});
		
	}
	
	public void setCurrentTime() {


		final Calendar c = Calendar.getInstance(); 

		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
		FunDisplayp();	
		datePicker1.init(year, month, day, onDateChangedListener1);
	}
	private DatePicker.OnDateChangedListener onDateChangedListener1 = new DatePicker.OnDateChangedListener() {
	    @Override
	    public void onDateChanged(DatePicker view, int iyear, int monthOfYear,
	            int dayOfMonth) {
	    	year=iyear;
	    	month=monthOfYear;
	    	day=dayOfMonth;
	    	FunDisplayp();
	    }
	};
	private void FunDisplayp(){
		textView1.setText(new StringBuilder().append(month + 1)
				   .append("-").append(day).append("-").append(year)
				   .append(" "));
		
	}
	private DatePickerDialog.OnDateSetListener datePickerListener = 
            new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker arg0, int arg1, int arg2,
						int arg3) {
				year = arg1;
				month = arg2;
				day = arg3;
				FunDisplayp();	
				datePicker1.init(year, month, day, onDateChangedListener1);
			}
	};

	
}
