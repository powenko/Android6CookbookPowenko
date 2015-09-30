// 柯博文老師 www.powenko.com
package com.example.TutorialSpinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class TutorialSpinner extends Activity  {
	 private String[] mStrings = {   "Apple", "Banana", "Cherry", "Watermelon"};
	private TextView myTextView01;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myTextView01 = (TextView) findViewById(R.id.TextView01);
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				myTextView01.setText(mStrings[arg2]);            //顯示選取的文字
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
        });
    }
}
