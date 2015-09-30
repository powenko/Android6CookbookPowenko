package com.powenko;



import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Tutorial_DB_SQLiteActivity extends Activity {


private ListView myListView;
	private DBClass mDBClass;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myListView = (ListView) this.findViewById(R.id.myListView);
        Fun_open();
        
      

        
    }
    public void Fun_open(){
    	
        // Save data to DB
    	mDBClass = new DBClass(this);
    	try {
			mDBClass.createDataBase();
			mDBClass.insert("title","info");
			Cursor tCursor=mDBClass.select();
			tCursor=mDBClass.doSQL("select * from powenkotable where title='powenko' ");
			List<News> t_List=mDBClass.FunGetNewsInfo(tCursor);
			
		int tsize=t_List.size();   //t_List.size();
	//		tsize=tsize;
			
		DBClassMyAdapter t_DBClassMyAdapter=new DBClassMyAdapter(this,t_List );
		
		
			
	        myListView.setAdapter(t_DBClassMyAdapter);
	        
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }
}