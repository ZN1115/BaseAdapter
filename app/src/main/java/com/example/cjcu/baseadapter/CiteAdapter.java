package com.example.cjcu.baseadapter;

import android.text.Layout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CiteAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private  String [][] data;
    static class ViewHolder{
        LinearLayout layout;
        TextView name;
        TextView address;
    }

    public CiteAdapter(String[][]data,LayoutInflater inflater){
        this.data=data;
        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Log.i("ZN","getView被觸發了");
        if(convertView==null){
            convertView=inflater.inflate(R.layout.templayout,null);
            holder=new ViewHolder();
            holder.name=(TextView)convertView.findViewById(R.id.tv_name);
            holder.address=(TextView)convertView.findViewById(R.id.tv_address);
            holder.layout=(LinearLayout)convertView.findViewById(R.id.Layout);
            convertView.setTag(holder);

        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        //holder.name.setText(data[position][0]);
        if(data[position][0].equals("1")){
            holder.name.setText("✿");
        }
        else{
            holder.name.setText("");
        }
        holder.address.setText(data[position][1]);
        return convertView;
    }
}
