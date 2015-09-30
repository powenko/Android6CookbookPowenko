package com.example.tutorial_ui_stackview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.StackView;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        ArrayList<item> items = new ArrayList<item>();
        items.add(new item("apple", this.getResources().getDrawable(R.drawable.apple)));
        items.add(new item("banana", this.getResources().getDrawable(R.drawable.banana)));
        items.add(new item("cherry", this.getResources().getDrawable(R.drawable.cherry)));
        items.add(new item("icon", this.getResources().getDrawable(R.drawable.ic_launcher)));
        items.add(new item("orange", this.getResources().getDrawable(R.drawable.orange)));
        
        
        
        StackView stk = (StackView)this.findViewById(R.id.stackView1);
        

        
        MyStackAdapter adapt = new MyStackAdapter(this, R.layout.listitem , items);
        stk.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					   Toast.makeText(getApplicationContext(),
					           "Click ListItem Number " + arg2, Toast.LENGTH_LONG).show();
					
				}
            });
        stk.setAdapter(adapt);
        
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
