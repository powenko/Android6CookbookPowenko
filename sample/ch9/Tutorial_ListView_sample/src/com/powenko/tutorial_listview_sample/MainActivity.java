package com.powenko.tutorial_listview_sample;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
 
public class MainActivity extends ListActivity   {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        ListAdapter adapter = createAdapter();
        setListAdapter(adapter);
        
   
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "You have chosen : " + " " + position, Toast.LENGTH_SHORT ).show();
    }


	protected ListAdapter createAdapter()
    {
    	// Create some  data
    	String[] testValues = new String[] {
    			"Apple",
    			"Banana",
    			"Orange",
    			"Tangerine"
    	};
 
    	ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testValues);
 
    	return adapter;
    }
}