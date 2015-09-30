package com.powenko.tutorial_ui_listpopupwindow;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  Button get = (Button) findViewById(R.id.button1 );
			    
		 	        get.setOnClickListener(new View.OnClickListener() {
		 	            @Override
		 	            public void onClick(View v) {
		 	            	showListPopup(v);
		 	            }
		 	        });
		
	}


	
    protected void showListPopup(View anchor) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
                android.R.layout.simple_list_item_1, 
                android.R.id.text1,
                new String[] { 
                   "Apple", 
                   "Banana", 
                   "Orange", 
                   "powenko.com" });

        ListPopupWindow popup = new ListPopupWindow(this);
        popup.setAdapter(adapter);
        popup.setAnchorView(anchor);
      
       
        popup.setOnItemClickListener(new OnItemClickListener() {
           

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				 Toast.makeText(getApplicationContext(),
				            "Click ListItem Number " + arg2, Toast.LENGTH_LONG)
				            .show();
				
			}
            });
        
        popup.show();
        
    }


}
