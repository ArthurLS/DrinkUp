package com.example.mathieu.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import com.example.mathieu.databasetest.fragments.OneFragment;
/**
 * Created by Salla on 29.4.2017.
 */

public class Game extends AppCompatActivity  implements TextToSpeech.OnInitListener {
    CardRuleDAO cardRuleBuilder = new CardRuleDAO(this);
    RuleDAO ruleBuilder = new RuleDAO(this);
    CardDAO cardBuilder = new CardDAO(this);
    List<CardRule> allCardRule;
    int count = 0;
    int previousPlayer = -1;
    List<Integer> suffledNumbers = new ArrayList<Integer>();
    HashMap<String, Integer> hmap = new HashMap<String, Integer>();

    TextToSpeech tts;


    public static OneFragment names = new OneFragment();
    public static void main(String[] args){
        names.getList().get(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tts = new TextToSpeech(this, this);

        setContentView(R.layout.layout_game);
        ImageView img = (ImageView) findViewById(R.id.cardView);
        img.setImageResource(R.drawable.red_joker);
        TextView text = (TextView) findViewById(R.id.ruleView);
        text.setText("Start the game by clicking the screen.");
        cardRuleBuilder.open();
        cardBuilder.open();
        ruleBuilder.open();
        allCardRule = cardRuleBuilder.getAllCardRules();

        hmap.put("Ace Of Heart", R.drawable.aceofheart);
        hmap.put("Ace Of Spade", R.drawable.aceofspade);
        hmap.put("Ace Of clubs", R.drawable.aceofclubs);
        hmap.put("Ace Of Diamond", R.drawable.aceofdiamond);
        hmap.put("Two Of Heart", R.drawable.twoofheart);
        hmap.put("Two Of Spade", R.drawable.twoofspade);
        hmap.put("Two Of clubs", R.drawable.twoofclubs);
        hmap.put("Two Of Diamond", R.drawable.twoofdiamond);
        hmap.put("Three Of Heart", R.drawable.threeofheart);
        hmap.put("Three Of Spade", R.drawable.threeofspade);
        hmap.put("Three Of clubs", R.drawable.threeofclubs);
        hmap.put("Three Of Diamond", R.drawable.threeofdiamond);
        hmap.put("Four Of Heart", R.drawable.fourofheart);
        hmap.put("Four Of Spade", R.drawable.fourofspade);
        hmap.put("Four Of clubs", R.drawable.fourofclubs);
        hmap.put("Four Of Diamond", R.drawable.fourofdiamond);
        hmap.put("Five Of Heart", R.drawable.fiveofheart);
        hmap.put("Five Of Spade", R.drawable.fiveofspade);
        hmap.put("Five Of clubs", R.drawable.fiveofclubs);
        hmap.put("Five Of Diamond", R.drawable.fiveofdiamond);
        hmap.put("Six Of Heart", R.drawable.sixofheart);
        hmap.put("Six Of Spade", R.drawable.sixofspade);
        hmap.put("Six Of clubs", R.drawable.sixofclubs);
        hmap.put("Six Of Diamond", R.drawable.sixofdiamond);
        hmap.put("Seven Of Heart", R.drawable.sevenofheart);
        hmap.put("Seven Of Spade", R.drawable.sevenofspade);
        hmap.put("Seven Of clubs", R.drawable.sevenofclubs);
        hmap.put("Seven Of Diamond", R.drawable.sevenofdiamond);
        hmap.put("Eight Of Heart", R.drawable.eightofheart);
        hmap.put("Eight Of Spade", R.drawable.eightofspade);
        hmap.put("Eight Of clubs", R.drawable.eightofclubs);
        hmap.put("Eight Of Diamond", R.drawable.eightofdiamond);
        hmap.put("Nine Of Heart", R.drawable.nineofheart);
        hmap.put("Nine Of Spade", R.drawable.nineofspade);
        hmap.put("Nine Of clubs", R.drawable.nineofclubs);
        hmap.put("Nine Of Diamond", R.drawable.nineofdiamond);
        hmap.put("Ten Of Heart", R.drawable.tenofheart);
        hmap.put("Ten Of Spade", R.drawable.tenofspade);
        hmap.put("Ten Of clubs", R.drawable.tenofclubs);
        hmap.put("Ten Of Diamond", R.drawable.tenofdiamond);
        hmap.put("Jack Of Heart", R.drawable.jackofheart);
        hmap.put("Jack Of Spade", R.drawable.jackofspade);
        hmap.put("Jack Of clubs", R.drawable.jackofclubs);
        hmap.put("Jack Of Diamond", R.drawable.jackofdiamond);
        hmap.put("Queen Of Heart", R.drawable.queenofheart);
        hmap.put("Queen Of Spade", R.drawable.queenofspade);
        hmap.put("Queen Of clubs", R.drawable.queenofclubs);
        hmap.put("Queen Of Diamond", R.drawable.queenofdiamond);
        hmap.put("King Of Heart", R.drawable.kingofheart);
        hmap.put("King Of Spade", R.drawable.kingofspade);
        hmap.put("King Of clubs", R.drawable.kingofclubs);
        hmap.put("King Of Diamond", R.drawable.kingofdiamond);

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.US);
        } else {
            installTTS();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //adds shuffled numbers to list
        while (suffledNumbers.size() < 52 ) {
            //generates a random number between 0-6
            int randomNum = ThreadLocalRandom.current().nextInt(0, 52);
            if (suffledNumbers.contains(randomNum)) {
                //item already in the list
            }
            else {
                //adds item to list if not already
                suffledNumbers.add(randomNum);
            }
        }
        if (event.getAction() == MotionEvent.ACTION_UP & count<52) {
            int randNumb = suffledNumbers.get(count);
            ImageView img = (ImageView) findViewById(R.id.cardView);
            img.setImageResource(hmap.get(allCardRule.get(randNumb).getCard()));
            TextView textView = (TextView) findViewById(R.id.ruleView);
            String ruleDescription = ruleBuilder.getDescription(allCardRule.get(randNumb).getRule());
            textView.setText(ruleDescription);

            String namePlayer;
            TextView nameView = (TextView) findViewById(R.id.nameView);
            count++;

            // If We start the list for the first time
            if(previousPlayer == -1){
                namePlayer = names.getList().get(0);
                nameView.setText(namePlayer);
                previousPlayer++;
            }
            // if We arrive at the end (ex: 3 players, size = 3, then previousPlayer = 1)
            else if(previousPlayer == names.getList().size()-2){
                namePlayer = names.getList().get(previousPlayer+1);
                nameView.setText(namePlayer);
                previousPlayer = -1;
            }
            else{
                namePlayer = names.getList().get(previousPlayer+1);
                nameView.setText(namePlayer);
                previousPlayer++;
            }
            tts.stop();
            Log.i("TAGME" , "I Arrived Here!");
            speak(namePlayer);
            Log.i("TAGME" , "Prout");
            speak(ruleDescription);
            Log.i("TAGME" , "I Arrived Over there!");

            return true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP & count>=52) {
/*            TextView text = (TextView) findViewById(R.id.ruleView);
            text.setText("End Game");
            ImageView img = (ImageView) findViewById(R.id.cardView);
            img.setImageResource(R.drawable.red_joker);*/
            startActivity(new Intent(Game.this, Game_End.class));
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cardRuleBuilder.close();
        ruleBuilder.close();
        cardBuilder.close();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    private void installTTS() {
        Intent installTTS = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
        startActivity(installTTS);
    }

    public void speak(String sentence_text) {
        tts.speak(sentence_text, TextToSpeech.QUEUE_ADD, null);
    }
}

