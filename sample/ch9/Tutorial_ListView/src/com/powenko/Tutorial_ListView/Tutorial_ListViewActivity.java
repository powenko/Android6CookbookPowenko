package com.powenko.Tutorial_ListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Tutorial_ListViewActivity extends Activity {

	ListView listView;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    listView = (ListView) findViewById(R.id.lv_country);
	    listView.setAdapter(new EfficientAdapter(this));

	         listView.setOnItemClickListener(        
	            new OnItemClickListener()
	            {
	                @Override
	                public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
	               
	                    Toast.makeText(getApplicationContext(),"You Selected Item "+Integer.toString(position), Toast.LENGTH_LONG).show();          
	                }       
	            }
	         );
	}
}