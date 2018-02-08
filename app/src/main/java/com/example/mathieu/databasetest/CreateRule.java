package com.example.mathieu.databasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Mathieu on 01/05/2017.
 */

public class CreateRule extends AppCompatActivity {
    Button btn_createRule ;
    Button btn_ruleExist ;
    EditText editText_ruleName ;
    EditText editText_ruleDescription ;
    RuleDAO rulebuilder ;
    CharSequence text ;
    int duration ;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule_creation);
        btn_createRule = (Button) findViewById(R.id.button_createRule) ;
        editText_ruleName = (EditText) findViewById(R.id.editText_ruleName) ;
        editText_ruleDescription = (EditText) findViewById(R.id.editText_ruleDescription);
        rulebuilder = new RuleDAO(this) ;
        duration = Toast.LENGTH_SHORT;
        rulebuilder.open();

        btn_createRule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rulebuilder.exist(editText_ruleName.getText().toString())) {
                    text = "This rule already exists";
                    Toast toast = Toast.makeText(CreateRule.this, text, duration);
                    toast.show();
                }
                else {
                    rulebuilder.createRule(editText_ruleName.getText().toString(), editText_ruleDescription.getText().toString());
                    rulebuilder.close();
                    text = "Rule created !";
                    Toast toast = Toast.makeText(CreateRule.this, text, duration);
                    toast.show();
                }
            }
        });
    }
}
