//柯博文老師 www.powenko.com
package com.powenko.tutorialbutton3;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity   // 方法2  implements OnClickListener 
{
/** Called when the activity is first created. */
	private TextView mmyTextView;
	private EditText mmyEditText;
	private Button mmyButton01;
	private Button mmyButton02;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mmyTextView=(TextView) findViewById(R.id.myTextView);
    mmyTextView.setText("How Are you");
    mmyTextView.setBackgroundColor(Color.RED);
    mmyTextView.setTextColor(Color.rgb(0, 255, 0));
    mmyTextView.setHeight(100);
    mmyTextView.setTextSize(20);
              	    	 
    mmyEditText=(EditText) findViewById(R.id.myEditText);
    mmyEditText.setTextColor(Color.GREEN);       
    String ttext1=mmyEditText.getText().toString();
                                
    mmyEditText.setOnKeyListener(new OnKeyListener() {
       @Override
       public boolean onKey(View v, int keyCode, KeyEvent event) {                                        
       if(event.getAction() == KeyEvent.ACTION_UP){
    	   String ttext=mmyEditText.getText().toString();	
    	   mmyTextView.setText(ttext);         	   
        }
        return false;
       }
    });
    
    mmyButton01=(Button) findViewById(R.id.Button01);
    mmyButton02=(Button) findViewById(R.id.Button02);    
/*
    // 方法一:
    mmyButton01.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
        	   mmyEditText.setTextColor(Color.YELLOW);                   	                     	
           }
       });
    
    mmyButton02.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
     	   mmyEditText.setTextColor(Color.RED);                   	                     	
        }
    });    
*/     
/*    // 方法二:
      mmyButton01.setOnClickListener(this);
      mmyButton02.setOnClickListener(this);
  */
}
/*
//方法二:
public void onClick(View v) {                             	// 實現的方法
	   	switch(v.getId()){	                                    // 處理 
	   		case R.id.Button01: 		              
	   			mmyEditText.setTextColor(Color.YELLOW);        //改變顏色
			 break;
	   		case R.id.Button02: 		
	   			 mmyEditText.setTextColor(Color.RED); 
	   			 break;
	   		default:
	   	break;
	   	}
}
*/

//方法三 android 1.6 版後的方法
	public void myClickHandler(View view) {
		switch (view.getId()) {
		case R.id.Button01:
			mmyEditText.setTextColor(Color.YELLOW); 
			break;
		case R.id.Button02:
			mmyEditText.setTextColor(Color.RED); 
			break;
		}
	}



}