package com.example.administrator.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class imgAdapter extends ArrayAdapter<image> {
    private int resourceID;
    public  imgAdapter(Context context, int textViewResourceID, List<image> img){
        super(context,textViewResourceID,img);
        resourceID = textViewResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        image pic = getItem(position);
        View view;
        viewHolder holder = new viewHolder();
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
            holder.picName = (TextView) view.findViewById(R.id.pic_name);
            holder.pic = (ImageView) view.findViewById(R.id.pic);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (viewHolder) view.getTag();
        }
        holder.pic.setImageResource(pic.getImgNumber());
        holder.picName.setText(pic.getName());
        return view;
    }
}
class viewHolder{
            TextView picName;
            ImageView pic;
        }