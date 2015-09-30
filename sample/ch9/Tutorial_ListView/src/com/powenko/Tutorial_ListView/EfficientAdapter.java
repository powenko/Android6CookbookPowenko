package com.powenko.Tutorial_ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class EfficientAdapter extends BaseAdapter {
	
	public static String[] fruit = { "Apple",
		"Banana",
		"Orange",
		"Tangerine" };
	public static String[] fruit_nickName = { "AP","BA","OR","TA" };
	
	
    private LayoutInflater mInflater;

    public EfficientAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return fruit.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row, null);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            holder.text2 = (TextView) convertView
                    .findViewById(R.id.TextView02);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text1.setText(fruit_nickName[position]);
        holder.text2.setText(fruit[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
        TextView text2;
    }
}