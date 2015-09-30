package com.my.CallOutAP;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallOutAP extends Activity {
	
	  private Button mButton1; 
	  private EditText mEditText1; 
	   
	  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mEditText1 = (EditText) findViewById(R.id.EditText01); 
        mButton1 = (Button) findViewById(R.id.Button01); 
     
        mButton1.setOnClickListener(new Button.OnClickListener() 
        { 
          @Override 
          public void onClick(View v) 
          { 
            try 
            { 
            	  String strInput = mEditText1.getText().toString(); 
                  
                  Intent myIntentDial = new  
                  Intent("android.intent.action.CALL",Uri.parse("tel:"+strInput)); 
                  startActivity(myIntentDial);
                  mEditText1.setText("");
                 
            }
            catch(Exception e) { 
            	e.printStackTrace(); 
          } 
        } 
      }); 
        
        
        
        
        
    }
}