package com.example.mathieu.databasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 03/05/2017.
 */

public class ViewRules extends AppCompatActivity {
    ListView viewRules ;
    RuleDAO ruleBuilder = new RuleDAO(this);
    public ArrayList<Rule> listRules = new ArrayList<Rule>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_rules);

        RuleDAO ruleBuilder = new RuleDAO(this);
        ruleBuilder.open();
        List<Rule> allRules = ruleBuilder.getAllRules();

        RuleAdapter adapter = new RuleAdapter(this,allRules);
        viewRules = (ListView) findViewById(R.id.listView_rules);
        viewRules.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ruleBuilder.close();
    }
}
