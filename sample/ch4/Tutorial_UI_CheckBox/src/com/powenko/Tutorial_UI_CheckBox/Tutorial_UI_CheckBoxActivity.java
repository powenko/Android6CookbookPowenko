 // 柯博文老師 www.powenko.com
package com.powenko.Tutorial_UI_CheckBox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

public class Tutorial_UI_CheckBoxActivity extends Activity {
    private CheckBox checkBox1;   
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
   	  checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
   	  checkBox1.setOnClickListener(new OnClickListener() {    //按鈕觸發監聽
   		  
  	    @Override
  	    public void onClick(View v) {                          // 按鈕觸發 
  		  if (((CheckBox) v).isChecked()) {                    //is checked?
  			checkBox1.setText("Checked");
  			Toast.makeText(Tutorial_UI_CheckBoxActivity.this,
  		 	   "powenko.com Checked)", Toast.LENGTH_LONG).show();
  	      }else{
  			checkBox1.setText("Not Checked");
  			Toast.makeText(Tutorial_UI_CheckBoxActivity.this,
  		 	   "powenko.com Not Checked)", Toast.LENGTH_LONG).show();
  		  }
  	    }
  	    
  	  });

    }
}