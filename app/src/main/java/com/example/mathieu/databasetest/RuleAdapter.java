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

public class RuleAdapter extends BaseAdapter {
    private List<Rule> listR ;
    private Context mContext ;
    private LayoutInflater lInflater ;

    public RuleAdapter(Context context, List<Rule> listR){
        mContext = context ;
        this.listR = listR ;
        lInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return listR.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listR.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        if (convertView == null) {
            layoutItem = (LinearLayout) lInflater.inflate(R.layout.layout_rule, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        TextView rule_name = (TextView)layoutItem.findViewById(R.id.rule_name);
        TextView rule_description = (TextView)layoutItem.findViewById(R.id.rule_description);

        rule_name.setText(listR.get(position).getName());
        rule_description.setText(listR.get(position).getDescription());

        return layoutItem;
    }
}
