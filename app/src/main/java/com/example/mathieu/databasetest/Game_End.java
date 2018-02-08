package com.example.mathieu.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Salla on 4.5.2017.
 */

public class Game_End extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game_end);
        Button newGameButton= (Button) findViewById(R.id.button_new_game);
        Button homeButton= (Button) findViewById(R.id.button_home);
        // set OnClickListener for Button here
        newGameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(Game_End.this, Game.class));
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(Game_End.this, Home.class));
            }
        });
    }
}