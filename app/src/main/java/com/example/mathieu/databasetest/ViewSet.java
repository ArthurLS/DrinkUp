package com.example.mathieu.databasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Mathieu on 03/05/2017.
 */

public class ViewSet extends AppCompatActivity {
    ListView viewSet ;
    CardRuleDAO cardRuleBuilder = new CardRuleDAO(this) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewset);
        CardRuleDAO cardRuleBuilder = new CardRuleDAO(this);
        cardRuleBuilder.open();
        List<CardRule> allCardRules = cardRuleBuilder.getAllCardRules();

        SetAdapter adapter = new SetAdapter(this,allCardRules);
        viewSet = (ListView) findViewById(R.id.listView_set);
        viewSet.setAdapter(adapter);
    }
}