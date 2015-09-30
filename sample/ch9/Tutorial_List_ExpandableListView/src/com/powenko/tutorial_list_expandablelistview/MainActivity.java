package com.powenko.tutorial_list_expandablelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {


	  SparseArray<MySubData> SparseArray1 = new SparseArray<MySubData>();
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 for (int j = 0; j < 5; j++) {
			  MySubData group1 = new MySubData("No:"+ j);
		      for (int i = 0; i < 5; i++) {
		        group1.children.add("Sub" + i);
		      }
		      SparseArray1.append(j, group1);
		    }
		
		
		ExpandableListView ExpandableListView1 = (ExpandableListView) findViewById(R.id.expandableListView1 );
		MyExpandableListAdapter adapter = new MyExpandableListAdapter(this,SparseArray1);
		ExpandableListView1.setAdapter(adapter);
	}

	
}
