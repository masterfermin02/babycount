package com.babycount.fpapp.babycount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


public class BiberonAdapter extends BaseAdapter {

    private Context c;
    // references to our images
    private ArrayList<Integer> mThumbIds = new ArrayList<>();

    public BiberonAdapter(Context c){
        this.c = c;
    }

    public void addBiberon(Integer position)
    {
        mThumbIds.add(R.drawable.biberon);
    }

    public void resetBiberones(){
        mThumbIds.clear();
        notifyDataSetChanged();
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(c);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(20, 20, 20, 20);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }


}
