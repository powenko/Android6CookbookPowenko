package com.powenko.tutorial_listview_togglebutton;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	private ListView listView1;
	String[] days = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY",
	            "FRIDAY", "SATURDAY" };
	boolean[] onOff = new boolean[] { false, true, false, true, false, false,
	            false };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.listView1 );
        listView1.setAdapter(new MyAdapter());
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
	       public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
        	   Toast.makeText(getApplicationContext(), "The item selected"+ Integer.toString(position),  Toast.LENGTH_LONG).show();
             }
	    });
      
    }
    ///////////
    public class MyAdapter extends BaseAdapter {

        public int getCount() {
            return days.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {

            return position;
        }

        @Override
        public int getViewTypeCount() {
            return days.length;
        }

        
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
		
			ViewHolder holder;
			
			if(convertView==null){
			holder=new ViewHolder();

		       LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		       convertView = vi.inflate(R.layout.myrow , null);
		   
		       holder.text1 = (TextView) convertView.findViewById(R.id.TextView1 );
		       holder.text2 = (TextView) convertView.findViewById(R.id.TextView2 );
		   
		       holder.ToggleBut1 = (ToggleButton) convertView.findViewById(R.id.ToggleButton1 );
		       holder.ToggleBut1.setOnClickListener(new OnClickListener() {
		    	
				@Override
				public void onClick(View v){
					ToggleButton tb = (ToggleButton) v;
					onOff[position]=tb.isChecked();
					Toast.makeText(getApplicationContext(), "The ToggleButton "+ String.valueOf(onOff[position]),  Toast.LENGTH_LONG).show();
				}
			});
		       
		        convertView.setTag(holder);
		    
			}else{
				holder=(ViewHolder)convertView.getTag();
			}
			holder.text1 .setText(days[position]);
			holder.text2.setText(days[position]);
			holder.ToggleBut1.setChecked(onOff[position]);
				  
			
			return convertView;
		}

    }
    static class ViewHolder { 
    	TextView text1;
    	TextView text2; 
    	ToggleButton ToggleBut1;
    }

 
}
