package com.powenko.tutorial_list_expandablelistview;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableListAdapter extends BaseExpandableListAdapter  {
	private final SparseArray<MySubData> SparseArray1;
	public LayoutInflater inflater;
	public Activity activity;
	  
    public MyExpandableListAdapter(Activity act, SparseArray<MySubData> groups) {
		activity = act;
		this.SparseArray1 = groups;
		inflater = act.getLayoutInflater();
	}
	
	  
	@Override
	public Object getChild(int arg0, int arg1) {
		return SparseArray1.get(arg0).children.get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return 0;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View convertView,
			ViewGroup arg4) {
		
		 final String children = (String) getChild(arg0, arg1);
		    TextView text = null;
		    if (convertView == null) {
		      convertView = inflater.inflate(R.layout.detail , null);
		    }
		    text = (TextView) convertView.findViewById(R.id.textView1);
		    text.setText(children);
		    convertView.setOnClickListener(new OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        Toast.makeText(activity, children,
		        Toast.LENGTH_SHORT).show();
		      }
		    });
		    return convertView;
	}

	@Override
	public int getChildrenCount(int arg0) {
		return SparseArray1.get(arg0).children.size();
	}

	@Override
	public Object getGroup(int arg0) {
		return SparseArray1.get(arg0);
	}

	@Override
	public int getGroupCount() {
		return SparseArray1.size();
	}

	@Override
	public long getGroupId(int arg0) {
		return 0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View convertView, ViewGroup arg3) {
	
		if (convertView == null) {
		      convertView = inflater.inflate(R.layout.listrow , null);
		    }
		    MySubData MySubData1 = (MySubData) getGroup(arg0);
		    ((CheckedTextView) convertView).setText(MySubData1.string);
		    ((CheckedTextView) convertView).setChecked(arg1);
	     return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return false;
	}

}
