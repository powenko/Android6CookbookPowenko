package com.powenko;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DBClassMyAdapter extends BaseAdapter
{
  public LayoutInflater mInflater;
  public List<News> items;

   public DBClassMyAdapter(Context context,List<News> it)
  {
 
    mInflater = LayoutInflater.from(context);
    items = it;
  }

  @Override
public int getCount()
  {
    return items.size();
  }

  @Override
public Object getItem(int position)
  {
    return items.get(position);
  }

  @Override
public long getItemId(int position)
  {
    return position;
  }

 // @Override
  @Override
public View getView(int position,View convertView,ViewGroup par)
  {
    ViewHolder holder;
   String a1="";
    if(convertView == null)
    {
       convertView = mInflater.inflate(R.layout.list, null);
      holder = new ViewHolder();

      holder.text = (TextView) convertView.findViewById(R.id.listTextView1);
      holder.text2 = (TextView) convertView.findViewById(R.id.listTextView2);
      convertView.setTag(holder);
    }
    else
    {
      holder = (ViewHolder) convertView.getTag();
    }
    News tmpN=items.get(position);


    holder.text.setText(tmpN._title   ); //"Ê∏ØÂπ£(HKD) Hong Kong Dollars");//tmpN.getTitle());
  
    holder.text2.setText(tmpN._info    );//  getdynamicRate());
   


    return convertView;
  }

  /* class ViewHolder */
  private class ViewHolder
  {
	    TextView text;
	    TextView text2;
	    TextView text3;
	    TextView text4;
	    TextView text5;
	    TextView text6;
	    TextView text7;
	    TextView text8;
	    ImageView icon;
  }
}