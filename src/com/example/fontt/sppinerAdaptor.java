package com.example.fontt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class sppinerAdaptor extends BaseAdapter {
 
    private String[] items;
    private Context context;
 
    public sppinerAdaptor(Context context,String[] i) {
        this.items = i;
        this.context = context;
    }
 
    @Override
    public int getCount() {
        return items.length;
    }
 
    @Override
    public Object getItem(int index) {
        return items[index];
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { 

    	LayoutInflater mInflater = (LayoutInflater)
        context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.custom_spiner, null);
        
        TextView txtTitle = (TextView) convertView.findViewById(R.id.text_main_seen);
         
        txtTitle.setText(items[position]);
     
        return convertView;
    }
     
 
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spiner, null);
        }
         
       
       TextView txtTitle = (TextView) convertView.findViewById(R.id.text_main_seen);
       txtTitle.setText(items[position]);
        return convertView;
    }


 
}