package com.powenko.tutorialactionbarsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView TextView01;
	private SearchView searchView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity , menu);
		
		TextView01 = (TextView)findViewById(R.id.textView1);
		searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		           searchView.setOnQueryTextListener(queryTextListener);
	
		return true;
	}
	
	final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String newText) {
        	TextView01.setText(newText);
            return true;
        }
        @Override
        public boolean onQueryTextSubmit(String query) {
        	TextView01.setText(query);
            return true;
        }
    };
    

}
