package com.powenko.myfragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
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
	String[] testValues= new String[]{"Apple","Banana","Orange","Tangerine"};
	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.mylistfragment,container, false);	    
	    
	    listView1=(ListView) view.findViewById(R.id.listView1);   //取得listView1
		ListAdapter adapter = createAdapter(); 
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(new OnItemClickListener(){  //選項按下反應
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			  String item = (String) parent.getItemAtPosition(position);   //哪一個列表
			   Toast.makeText(getActivity(), 
					   item+"selected="+testValues[position],   
                       Toast.LENGTH_LONG).show();              //顯示訊號
			   MyDetailFragment fragment = (MyDetailFragment) getFragmentManager()
			            .findFragmentById(R.id.detailFragment);
			        if (fragment != null && fragment.isInLayout()) {
			          fragment.setText(testValues[position]);
			        } 
			}
		} );
	    return view;
	  }
	 private  ListAdapter createAdapter(){
			ListAdapter adapter=new  ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, testValues);
			return adapter; 
	}
	 
}
