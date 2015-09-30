package com.powenko.tutorial_ui_expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class MainActivity extends ExpandableListActivity {
    
	private String[] mFruit= { 
            "Apple", 
            "Banana", 
            "Orange", 
            "Watermelon", };
	private String[] mOS= { 
            "Android", 
            "iPhone", 
            "Windows",  };
	
	private ExpandableListAdapter mAdapter;
	ExpandableListView expand;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
	List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
	List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
	
	/* ******************** Start Group  ********************* */
	Map<String, String> curgroupMap1 = new HashMap<String, String>();
	groupData.add(curgroupMap1);
	curgroupMap1.put("parent", "Fruit");
	
	List<Map<String,String>> children1 =new ArrayList<Map<String,String>>();
	/* *** ChildData ***/
	Map<String, String> curChildMap1 = new HashMap<String, String>();
	children1.add(curChildMap1);
	curChildMap1.put("child", mFruit[0]);
	
    /////////
	Map<String, String> curChildMap2 = new HashMap<String, String>();
	children1.add(curChildMap2);
	curChildMap2.put("child", mFruit[1]);
	
	 /////////
	Map<String, String> curChildMap3 = new HashMap<String, String>();
	children1.add(curChildMap3);
	curChildMap3.put("child", mFruit[2]);
	
	 /////////
	Map<String, String> curChildMap4 = new HashMap<String, String>();
	children1.add(curChildMap4);
	curChildMap4.put("child", mFruit[3]);
	
	 /////////
//	Map<String, String> curChildMap5 = new HashMap<String, String>();
//	children1.add(curChildMap5);
//	curChildMap5.put("child",mFruit[4]);
	
	childData.add(children1);
	
	/* *************************End Group **************************/
	
	/* ******************** Start Group  ********************* */
	Map<String, String> curgroupMap2 = new HashMap<String, String>();
	groupData.add(curgroupMap2);
	curgroupMap2.put("parent", "MobileOS");
	List<Map<String,String>> children2 =new ArrayList<Map<String,String>>();
	
	 /////////
	Map<String, String> curChildMap6 = new HashMap<String, String>();
	children2.add(curChildMap6);
	curChildMap6.put("child", mOS[0]);
	
	 /////////
	Map<String, String> curChildMap7 = new HashMap<String, String>();
	children2.add(curChildMap7);
	curChildMap7.put("child", mOS[1]);
	
	 /////////
	Map<String, String> curChildMap8 = new HashMap<String, String>();
	children2.add(curChildMap8);
	curChildMap8.put("child",mOS[2]);
	
	childData.add(children2);
	
	/* *************************End Group **************************/
	
	
	
	 mAdapter = new SimpleExpandableListAdapter(
	            this,
	            groupData,
	            android.R.layout.simple_expandable_list_item_1,
	            new String[] { "parent" },
	            new int[] { android.R.id.text1, android.R.id.text2 },
	            childData,
	            android.R.layout.simple_expandable_list_item_2,
	            new String[] {"child"},
	            new int[] { android.R.id.text1 }
	            );
	 setListAdapter(mAdapter);
	
	 expand = getExpandableListView();
	 expand.setOnChildClickListener(new OnChildClickListener() {
		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			
			switch (groupPosition)
			{
			case 0 :
				Toast.makeText(getBaseContext(), mFruit[childPosition],
						Toast.LENGTH_SHORT).show();
				
				break;
			case 1:
				Toast.makeText(getBaseContext(), mOS[childPosition],
						Toast.LENGTH_SHORT).show();
				
				break;
			
			}
			
			return false;
		}
	});
        
        
	}
}
 
