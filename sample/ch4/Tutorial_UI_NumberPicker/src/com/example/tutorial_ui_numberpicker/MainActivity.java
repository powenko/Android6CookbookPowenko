// 柯博文老師 www.powenko.com
package com.example.tutorial_ui_numberpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//設定0~20 的數字矩陣
		String[] nums = new String[21];                          
		for(int i=0; i<nums.length; i++)
		   nums[i] =    Integer.toString(i*5);
		//設定 NumberPicker元件 -選取數字
		final NumberPicker np = (NumberPicker) findViewById(R.id.np);
		np.setMaxValue(nums.length-1);                 // 最大值
		np.setMinValue(0);                             // 初始值
		np.setWrapSelectorWheel(false);
		np.setDisplayedValues(nums);                  

   		textView1  = (TextView) findViewById(R.id.textView1);
	    Button getvalue  = (Button) findViewById(R.id.button1);
	        getvalue.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					textView1.setText("Numer is "+ String.valueOf(np.getValue()) );
					Toast.makeText(getApplicationContext(), String.valueOf(np.getValue()), Toast.LENGTH_SHORT).show();
				}
			});      
	}
}
