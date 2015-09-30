package com.powenko.TutorialJson;

import java.util.ArrayList;


import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;






public class TutorialJson extends Activity {
    /** Called when the activity is first created. */
 
    	private JSONObject jObject;
    	private String jString = "{\"menu\": {\"id\": \"file\", \"value\": \"File\", \"popup\": { \"menuitem\": [ {\"value\": \"New\",   \"onclick\": \"CreateNewDoc()\"}, {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"}, {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}]}}}";

    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.main);
    		try {
    			 String[] converted = parse();
    			
    			ListAdapter adapter = new ArrayAdapter<String>(this,
    	        		android.R.layout.simple_list_item_1, converted);
    			
    			ListView listView = (ListView) findViewById(R.id.lv_country); 
    	        listView.setAdapter(adapter);
    	        
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	private String[] parse() throws Exception {
    		jObject = new JSONObject(jString);

    		JSONObject menuObject = jObject.getJSONObject("menu");
    		String attributeId = menuObject.getString("id");
    		System.out.println(attributeId);

    		String attributeValue = menuObject.getString("value");
    		System.out.println(attributeValue);

    		JSONObject popupObject = menuObject.getJSONObject("popup");
    		JSONArray menuitemArray = popupObject.getJSONArray("menuitem");

    		
    		
    	   ArrayList<String> list = new ArrayList<String>();
    		   
    		for (int i = 0; i < 3; i++) {
    			String t1=menuitemArray.getJSONObject(i)
    					.getString("value").toString();
    			System.out.println();
    			list.add(t1);
    			System.out.println(menuitemArray.getJSONObject(i).getString(
    					"onclick").toString());
    		}
    		return list.toArray(new String[list.size()]);
    		
    		
    	}

    	
    	
    
    	    
    		  
    
}

