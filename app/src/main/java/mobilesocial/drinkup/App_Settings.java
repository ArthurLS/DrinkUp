package mobilesocial.drinkup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import mobilesocial.drinkup.R;

/**
 * Created by Arthur on 05/04/2017.
 */

public class App_Settings extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_app_settings);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio_easy:
                        Log.d("TAGME", "radio1 has changed");
                        break;
                    case R.id.radio_medium:
                        Log.d("TAGME", "radio2 has changed");
                        break;
                    case R.id.radio_hard:
                        Log.d("TAGME", "radio3 has changed");
                        break;
                }
            }
        });
    }
}
