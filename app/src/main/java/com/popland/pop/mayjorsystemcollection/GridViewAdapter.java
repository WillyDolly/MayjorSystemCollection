package com.popland.pop.mayjorsystemcollection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by hai on 29/04/2017.
 */

public class GridViewAdapter extends BaseAdapter {
    Context mContext;
    Integer[] collection = new Integer[110];

    GridViewAdapter(Context c){
        mContext = c;
        for(int i=0;i<110;i++)
            collection[i] = R.drawable.money;
    }

    @Override
    public int getCount() {
        return collection.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100,100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);// keep whole image =/ center
            imageView.setPadding(0,0,0,0);
        }
        else
            imageView = (ImageView)convertView;
        imageView.setImageResource(collection[position]);
        return imageView;
    }
}
