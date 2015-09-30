package com.powenko.tutorial_system_clipboardmanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText1;
	private EditText editText2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText1  = (EditText) findViewById(R.id.editText1 );
		editText2  = (EditText) findViewById(R.id.editText2 );
		
		
		Button button1  = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				copyToClipBoard(editText1.getText().toString());
			}
		});
	        
	    	
		Button button2  = (Button) findViewById(R.id.button2);  
		button2.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				String t1=pasteFromClipBoard();
				editText2.setText(t1);
			}
		});
	}
	
	@SuppressLint("NewApi")
	private void copyToClipBoard(String i_string)
	{
		ClipboardManager ClipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		ClipMan.setText(i_string);
		

	}
	
	
	@SuppressLint("NewApi")
	private String pasteFromClipBoard()
	{
		ClipboardManager ClipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		return ClipMan.getText().toString();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
