package com.example.mathieu.databasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mathieu on 03/05/2017.
 */

public class ChangeRule extends AppCompatActivity {
    Button btn_changeRule ;
    EditText editText_cardName ;
    EditText editText_ruleName ;
    RuleDAO rulebuilder ;
    CardDAO cardbuilder ;
    CardRuleDAO cardrulebuilder ;
    CharSequence text ;
    int duration = Toast.LENGTH_SHORT ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_changerule);
        btn_changeRule = (Button) findViewById(R.id.button_changerule) ;
        editText_ruleName = (EditText) findViewById(R.id.editText_changeName) ;
        editText_cardName = (EditText) findViewById(R.id.editText_changecardname);
        cardrulebuilder = new CardRuleDAO(this) ;
        cardbuilder = new CardDAO(this);
        rulebuilder = new RuleDAO(this);
        cardbuilder.open();
        rulebuilder.open();
        cardrulebuilder.open();

        final List<Card> allCards = cardbuilder.getAllCards();
        final List<Rule> allRules = rulebuilder.getAllRules();

        btn_changeRule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rulebuilder.exist(editText_ruleName.getText().toString()) && cardbuilder.exist(editText_cardName.getText().toString())){
                    cardrulebuilder.deleteCardRule(editText_cardName.getText().toString());
                    cardrulebuilder.createCardRule(editText_cardName.getText().toString(), editText_ruleName.getText().toString());
                    text = "Set modified !";
                    Toast toast = Toast.makeText(ChangeRule.this, text, duration);
                    toast.show();
                }
                else {
                    text = "Problem : the card or the rule doesn't exist" ;
                    Toast toast = Toast.makeText(ChangeRule.this, text, duration);
                    toast.show();
                }
            }
        });

        Button btn_resetRule = (Button) findViewById(R.id.btn_resetSet);

        btn_resetRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardrulebuilder.cleanTable();
                for (int i = 0; i < 13; i++) {
                    for (int j = 0; j < 4; j++){
                        text = "Your game Set has been reset!";
                        Toast toast = Toast.makeText(ChangeRule.this, text, duration);
                        toast.show();
                        cardrulebuilder.createCardRule(allCards.get(4*i + j).getName(), allRules.get(i).getName());
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cardrulebuilder.close();
        rulebuilder.close();
        cardrulebuilder.close();
    }
}