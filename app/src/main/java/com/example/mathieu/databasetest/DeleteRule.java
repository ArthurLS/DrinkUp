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

public class DeleteRule extends AppCompatActivity {
    Button btn_deleteRule ;
    EditText editText_ruleName ;
    RuleDAO rulebuilder ;
    CharSequence text ;
    int duration = Toast.LENGTH_SHORT ;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule_delete);
        btn_deleteRule = (Button) findViewById(R.id.button_ruleDelete) ;
        editText_ruleName = (EditText) findViewById(R.id.editText_ruledeletename) ;
        rulebuilder = new RuleDAO(this) ;
        rulebuilder.open();
        btn_deleteRule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(rulebuilder.exist(editText_ruleName.getText().toString())){
                    rulebuilder.deleteRule(editText_ruleName.getText().toString());
                    text = "Rule Deleted !";
                    Toast toast = Toast.makeText(DeleteRule.this, text, duration);
                    toast.show();
                }
                else {
                    text = "This rule doesn't exist";
                    Toast toast = Toast.makeText(DeleteRule.this, text, duration);
                    toast.show();
                }
            }
        });
    }
}
