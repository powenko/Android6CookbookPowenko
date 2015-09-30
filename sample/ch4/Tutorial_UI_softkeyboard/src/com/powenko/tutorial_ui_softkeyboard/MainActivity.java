package com.powenko.tutorial_ui_softkeyboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private EditText editText1;
	private EditText editText2;
	private EditText editText3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 =  (EditText) findViewById(R.id.editText1);
		editText2 =  (EditText) findViewById(R.id.editText2);
		editText3 =  (EditText) findViewById(R.id.editText3);
		RelativeLayout RelativeLayout1 =  (RelativeLayout) findViewById(R.id.relativeLayout1 );
		RelativeLayout1.setOnClickListener(new View.OnClickListener()
		    {
		        @Override
		        public void onClick(View v)
		        {
		            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
		            imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
		            imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
			        imm.hideSoftInputFromWindow(editText3.getWindowToken(), 0);
		        }
		});
		
	}


}
