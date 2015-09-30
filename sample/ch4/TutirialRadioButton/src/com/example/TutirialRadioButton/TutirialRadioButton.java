 // 柯博文老師 www.powenko.com
package com.example.TutirialRadioButton;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class TutirialRadioButton extends Activity {
    /** Called when the activity is first created. */
	private TextView mmyTextView;
	private EditText mmyEditText;
	 public RadioGroup mRadioGroup1; 
	  public RadioButton mRadio1,mRadio2; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mmyTextView=(TextView) findViewById(R.id.myTextView);
        mmyTextView.setText("How Are you");
        mmyTextView.setBackgroundColor(Color.RED);
        mmyTextView.setTextColor(Color.rgb(0, 255, 0));
        mmyTextView.setHeight(100);
        mmyTextView.setTextSize(20);
               
        mRadioGroup1 = (RadioGroup) findViewById(R.id.myRadioGroup);      
        mRadio1 = (RadioButton) findViewById(R.id.myRadioButton1);  
        mRadio2 = (RadioButton) findViewById(R.id.myRadioButton2); 
        mRadioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {                                        //按鈕觸發監聽
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{ 		
				if(checkedId==mRadio1.getId()) 
				{            
					   mmyTextView.setText("apple");  
				} else if(checkedId==mRadio2.getId()) 
				{ 
					   mmyTextView.setText("banana");  		
				}       
			} 
        });
    }
}