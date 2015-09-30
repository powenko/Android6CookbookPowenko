package com.example.tutorial_ui_loadermanager;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {

		 Toast.makeText(this, "onCreateLoader", Toast.LENGTH_SHORT).show();
		return null;
	// TBD
	}
	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
	// TBD
		 Toast.makeText(this, "onLoadFinished", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
	// TBD
		 Toast.makeText(this, "onLoaderReset", Toast.LENGTH_SHORT).show();
	}
	private static final int TUTORIAL_LIST_LOADER = 0x01;
	private LoaderManager.LoaderCallbacks<Cursor> mCallbacks;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.lv_country); 
		String[] testValues=new String[]{"apple","banana"};
		
		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, testValues);
		listView.setAdapter(adapter);
		/////////
		
		 mCallbacks = this;
		String[] uiBindFrom = { "COL_TITLE" };
	    int[] uiBindTo = { 1 };
	    //getLoaderManager().initLoader(TUTORIAL_LIST_LOADER, null,		 this);
	    getSupportLoaderManager().initLoader(0, null, this);
	    
	    
	  
	   // setListAdapter(adapter);
	    listView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
