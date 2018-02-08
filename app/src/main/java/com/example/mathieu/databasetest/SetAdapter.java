package com.example.mathieu.databasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mathieu on 03/05/2017.
 */

public class SetAdapter extends BaseAdapter {
    private List<CardRule> listSet;
    private Context mContext;
    private LayoutInflater lInflater;

    public SetAdapter(Context context, List<CardRule> listSet) {
        mContext = context;
        this.listSet = listSet;
        lInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return listSet.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        if (convertView == null) {
            layoutItem = (LinearLayout) lInflater.inflate(R.layout.layout_set, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        TextView card_name = (TextView)layoutItem.findViewById(R.id.card_name);
        TextView rule_name = (TextView)layoutItem.findViewById(R.id.rule_name);

        card_name.setText(listSet.get(position).getCard());
        rule_name.setText(listSet.get(position).getRule());

        return layoutItem;
    }
}