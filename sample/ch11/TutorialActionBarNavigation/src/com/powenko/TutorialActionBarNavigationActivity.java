package com.powenko;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class TutorialActionBarNavigationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    
    ////
    
   
    private TextView TextView01;
    private SearchView searchView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        

        TextView01 = (TextView)findViewById(R.id.TextView01); 


        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
          searchView.setOnQueryTextListener(queryTextListener);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_powen1:         
             return true;         	
        case R.id.menu_powen2:
        	startActivity(new Intent(this, page2.class));
            return true;
        case R.id.menu_powen3:
             startActivity(new Intent(this, page3.class));          
             return true;
       default:
             return super.onOptionsItemSelected(item);
        }
    }
    
    final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String newText) {
            // Do something
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