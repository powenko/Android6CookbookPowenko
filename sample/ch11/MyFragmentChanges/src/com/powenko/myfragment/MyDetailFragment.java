package com.powenko.myfragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MyDetailFragment extends Fragment {
	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.mydetailfragment ,container, false);	    
	    return view;
	  }
	 
	  public void setText(String item) {
		    TextView view = (TextView) getView().findViewById(R.id.textView1);
		    view.setText(item);
      }
}
