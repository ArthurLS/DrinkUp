package com.example.mathieu.databasetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity {
    CardDAO cardBuilder = new CardDAO(this);
    RuleDAO ruleBuilder = new RuleDAO(this);
    CardRuleDAO cardRuleBuilder = new CardRuleDAO(this);
    SharedPreferences prefs = null;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cardBuilder.close();
        ruleBuilder.close();
        cardRuleBuilder.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        Button btn_start = (Button)  findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_start = new Intent(Home.this, Game_Settings.class);
                startActivity(intent_start);
            }});

        Button btn_credits = (Button)  findViewById(R.id.btn_credits);
        btn_credits.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_start = new Intent(Home.this, Credits.class);
                startActivity(intent_start);
            }});


        prefs = getSharedPreferences("DrinkUp", MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)) {
            fillDB();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }
    public void fillDB () {
        cardBuilder.open();
        cardBuilder.createCard("Ace Of Heart", R.drawable.aceofheart);
        cardBuilder.createCard("Ace Of Spade", R.drawable.aceofspade);
        cardBuilder.createCard("Ace Of clubs", R.drawable.aceofclubs);
        cardBuilder.createCard("Ace Of Diamond", R.drawable.aceofdiamond);
        cardBuilder.createCard("Two Of Heart", R.drawable.twoofheart);
        cardBuilder.createCard("Two Of Spade", R.drawable.twoofspade);
        cardBuilder.createCard("Two Of clubs", R.drawable.twoofclubs);
        cardBuilder.createCard("Two Of Diamond", R.drawable.twoofdiamond);
        cardBuilder.createCard("Three Of Heart", R.drawable.threeofheart);
        cardBuilder.createCard("Three Of Spade", R.drawable.threeofspade);
        cardBuilder.createCard("Three Of clubs", R.drawable.threeofclubs);
        cardBuilder.createCard("Three Of Diamond", R.drawable.threeofdiamond);
        cardBuilder.createCard("Four Of Heart", R.drawable.fourofheart);
        cardBuilder.createCard("Four Of Spade", R.drawable.fourofspade);
        cardBuilder.createCard("Four Of clubs", R.drawable.fourofclubs);
        cardBuilder.createCard("Four Of Diamond", R.drawable.fourofdiamond);
        cardBuilder.createCard("Five Of Heart", R.drawable.fiveofheart);
        cardBuilder.createCard("Five Of Spade", R.drawable.fiveofspade);
        cardBuilder.createCard("Five Of clubs", R.drawable.fiveofclubs);
        cardBuilder.createCard("Five Of Diamond", R.drawable.fiveofdiamond);
        cardBuilder.createCard("Six Of Heart", R.drawable.sixofheart);
        cardBuilder.createCard("Six Of Spade", R.drawable.sixofspade);
        cardBuilder.createCard("Six Of clubs", R.drawable.sixofclubs);
        cardBuilder.createCard("Six Of Diamond", R.drawable.sixofdiamond);
        cardBuilder.createCard("Seven Of Heart", R.drawable.sevenofheart);
        cardBuilder.createCard("Seven Of Spade", R.drawable.sevenofspade);
        cardBuilder.createCard("Seven Of clubs", R.drawable.sevenofclubs);
        cardBuilder.createCard("Seven Of Diamond", R.drawable.sevenofdiamond);
        cardBuilder.createCard("Eight Of Heart", R.drawable.eightofheart);
        cardBuilder.createCard("Eight Of Spade", R.drawable.eightofspade);
        cardBuilder.createCard("Eight Of clubs", R.drawable.eightofclubs);
        cardBuilder.createCard("Eight Of Diamond", R.drawable.eightofdiamond);
        cardBuilder.createCard("Nine Of Heart", R.drawable.nineofheart);
        cardBuilder.createCard("Nine Of Spade", R.drawable.nineofspade);
        cardBuilder.createCard("Nine Of clubs", R.drawable.nineofclubs);
        cardBuilder.createCard("Nine Of Diamond", R.drawable.nineofdiamond);
        cardBuilder.createCard("Ten Of Heart", R.drawable.tenofheart);
        cardBuilder.createCard("Ten Of Spade", R.drawable.tenofspade);
        cardBuilder.createCard("Ten Of clubs", R.drawable.tenofclubs);
        cardBuilder.createCard("Ten Of Diamond", R.drawable.tenofdiamond);
        cardBuilder.createCard("Jack Of Heart", R.drawable.jackofheart);
        cardBuilder.createCard("Jack Of Spade", R.drawable.jackofspade);
        cardBuilder.createCard("Jack Of clubs", R.drawable.jackofclubs);
        cardBuilder.createCard("Jack Of Diamond", R.drawable.jackofdiamond);
        cardBuilder.createCard("Queen Of Heart", R.drawable.queenofheart);
        cardBuilder.createCard("Queen Of Spade", R.drawable.queenofspade);
        cardBuilder.createCard("Queen Of clubs", R.drawable.queenofclubs);
        cardBuilder.createCard("Queen Of Diamond", R.drawable.queenofdiamond);
        cardBuilder.createCard("King Of Heart", R.drawable.kingofheart);
        cardBuilder.createCard("King Of Spade", R.drawable.kingofspade);
        cardBuilder.createCard("King Of clubs", R.drawable.kingofclubs);
        cardBuilder.createCard("King Of Diamond", R.drawable.kingofdiamond);
        List<Card> allCards = cardBuilder.getAllCards();

        ruleBuilder.open();

        ruleBuilder.createRule("WaterFall", "WaterFall: Everyone starts drinking at the same time. Person who draw this card can stop drinking first. Rest can stop drinking after the person on your right has stopped.");
        ruleBuilder.createRule("Two Drinks", "Give 2 drinks to anyone.");
        ruleBuilder.createRule("Three Drinks", "Take 3 drinks.");
        ruleBuilder.createRule("Ladies", "All the ladies playing takes a drink.");
        ruleBuilder.createRule("Placement", "The person across from you takes a drink.");
        ruleBuilder.createRule("Guys", "All the guys take a drink.");
        ruleBuilder.createRule("DrinkUp", "DrinkUp: The player of this card sends 7 gulps to any player/players.");
        ruleBuilder.createRule("Never have I ever", "Never have I ever: The person who drew this card says something they haven’t done before. Everyone who has done it takes a drink.");
        ruleBuilder.createRule("Slap", "Slap: The last person to slap their head takes a drink.");
        ruleBuilder.createRule("Categories", "Categories: The person who drew the card picks a category and says the first word on it. First person that fails to come up with a new word for that category takes a drink.");
        ruleBuilder.createRule("Social", "Social: Everyone takes a drink.");
        ruleBuilder.createRule("Questions", "Questions: Go around in a circle and you have to keep asking questions to each other. Whoever messes up and does not say a question, drinks.");
        ruleBuilder.createRule("Make any rule", "Make any rule: The person that breaks it has to drink.");
        List<Rule> allRules = ruleBuilder.getAllRules();
        cardRuleBuilder.open();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++){
                cardRuleBuilder.createCardRule(allCards.get(4*i + j).getName(), allRules.get(i).getName());
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Log.d("tag", "Returned result OK");
            }
            if (resultCode == RESULT_CANCELED) {
                Log.d("tag", "Returned result Canceled");
            }
        }
    }
}
