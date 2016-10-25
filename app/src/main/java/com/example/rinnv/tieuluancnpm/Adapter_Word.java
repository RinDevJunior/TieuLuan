package com.example.rinnv.tieuluancnpm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rinnv on 25/10/2016.
 */

public class Adapter_Word extends BaseAdapter {
    private ArrayList<Word> items;
    private LayoutInflater itemInflater;

    @Override
    public int getCount() {
        return items.size();
    }

    public Adapter_Word(Context c, ArrayList<Word> the_Items)
    {
        items = the_Items;
        itemInflater = LayoutInflater.from(c);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout Layout = (LinearLayout)itemInflater.inflate(R.layout.item_layout,
                parent,
                false);

        TextView titleView  = (TextView)Layout.findViewById(R.id.itemtitle);


        Word item = items.get(position);
        titleView.setText(item.getWord_Title() + ":" + item.getWord_Title_VN());
        titleView.setTextSize(20);



        Layout.setTag(position);
        return Layout;

    }
}
