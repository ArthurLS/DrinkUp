package com.example.mathieu.databasetest.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mathieu.databasetest.ChangeRule;
import com.example.mathieu.databasetest.DeleteRule;
import com.example.mathieu.databasetest.Game;
import com.example.mathieu.databasetest.R;
import com.example.mathieu.databasetest.CreateRule;
/*import com.example.mathieu.databasetest.SetMenu;*/
import com.example.mathieu.databasetest.ViewRules;
import com.example.mathieu.databasetest.ViewSet;


public class TwoFragment extends Fragment {
    Button btn_viewRules ;
    Button btn_createRule ;
    Button btn_deleteRule ;
    Button btn_changeRule ;
    Button btn_startGame ;
    Button btn_viewSet;
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rules, container, false);

        btn_viewRules = (Button) rootView.findViewById(R.id.btn_viewRules);
        btn_viewRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ViewRules.class);
                startActivity(myIntent);}
        });

        btn_createRule = (Button) rootView.findViewById(R.id.btn_createRule);
        btn_createRule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), CreateRule.class);
                startActivity(myIntent);}
        });

        btn_deleteRule = (Button) rootView.findViewById(R.id.btn_deleteRule);
        btn_deleteRule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), DeleteRule.class);
                startActivity(myIntent);}
        });

        btn_changeRule = (Button) rootView.findViewById(R.id.btn_changeRule);
        btn_changeRule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ChangeRule.class);
                startActivity(myIntent);}
        });

        btn_viewSet = (Button) rootView.findViewById(R.id.btn_viewSet);
        btn_viewSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_start = new Intent(getActivity(), ViewSet.class);
                startActivity(intent_start);
            }
        });

        btn_startGame = (Button) rootView.findViewById(R.id.btn_start_game2);
        btn_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_start = new Intent(getActivity(), Game.class);
                startActivity(intent_start);
            }
        });

        return rootView;
    }

}
