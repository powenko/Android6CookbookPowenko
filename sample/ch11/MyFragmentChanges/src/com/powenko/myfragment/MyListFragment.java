package com.powenko.myfragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MyListFragment extends Fragment {
	private  ListView listView1;
	String[] testValues= new String[]{"Apple","Google","Orange","Powenko"};
	String[] testURL= new String[]{"http://www.apple.com","http://www.google.com",
			                       "","http://www.powenko.com"};
	private final Handler handler = new Handler();
	private int m_position=0;
	
	 @SuppressLint("CommitTransaction")
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.mylistfragment,container, false);	    
	    
	    listView1=(ListView) view.findViewById(R.id.listView1);   //取得listView1
		ListAdapter adapter = createAdapter(); 
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(new OnItemClickListener(){        //選項按下反應
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
		
			  String item = (String) parent.getItemAtPosition(position);   //哪一個列表
			   Toast.makeText(getActivity(), 
					   item+"selected="+testValues[position],   
                       Toast.LENGTH_LONG).show();                          //顯示訊號
			   m_position=position;
			   if(position<2){
					FragmentManager fm = getFragmentManager();
					MyDetailFragment2 newFragment = new MyDetailFragment2();
					FragmentTransaction transaction = getFragmentManager().beginTransaction();	
					transaction.replace(R.id.detailFragment, newFragment);
					transaction.commit();
					Runnable notification = new Runnable() {
				        public void run() {
				        	startPlayProgressUpdater2();           
						}
					};
					handler.postDelayed(notification,500);
			   }else{
				   FragmentManager fm = getFragmentManager();
					MyDetailFragment newFragment = new MyDetailFragment();
					FragmentTransaction transaction = getFragmentManager().beginTransaction();	
					transaction.replace(R.id.detailFragment, newFragment);
					transaction.commit();
					Runnable notification = new Runnable() {
				        public void run() {
				        	startPlayProgressUpdater();           
						}
					};
					handler.postDelayed(notification,500);
			   }	   
			}
		} );
	    return view;
	  }
	  
		
		public void startPlayProgressUpdater() {
			MyDetailFragment fragment = (MyDetailFragment) getFragmentManager()
		            .findFragmentById(R.id.detailFragment);
			if (fragment != null) {
				fragment.setText(testValues[m_position]);
			} 
		}
			
		public void startPlayProgressUpdater2() {
			MyDetailFragment2 fragment = (MyDetailFragment2) getFragmentManager()
		            .findFragmentById(R.id.detailFragment);
			if (fragment != null) {
				fragment.setText(testValues[m_position]);
			} 
		}				
	 private  ListAdapter createAdapter(){
			ListAdapter adapter=new  ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, testValues);
			return adapter; 
	}
	 
}
