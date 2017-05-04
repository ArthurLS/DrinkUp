package mobilesocial.drinkup;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Random;

/**
 * Created by Salla on 29.4.2017.
 */

public class Game extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game);

        ImageView img = (ImageView) findViewById(R.id.cardView);
        img.setImageResource(R.drawable.black_joker);
        TextView text = (TextView) findViewById(R.id.ruleView);
        text.setText("Start the game by clicking the screen.");

    }
    int count = 0;
    List<Integer> suffledNumbers = new ArrayList<Integer>();
    int[] cards={R.drawable.card1,R.drawable.card2,R.drawable.card3,R.drawable.card4,R.drawable.card5,
            R.drawable.card6,R.drawable.card7,R.drawable.card8,R.drawable.card9,R.drawable.card10,R.drawable.card11,R.drawable.card12,R.drawable.card13,R.drawable.card14,R.drawable.card15,
            R.drawable.card16,R.drawable.card17,R.drawable.card18,R.drawable.card19,R.drawable.card20,R.drawable.card21,R.drawable.card22,R.drawable.card23,R.drawable.card24,R.drawable.card25,
            R.drawable.card26,R.drawable.card27,R.drawable.card28,R.drawable.card29,R.drawable.card30,R.drawable.card31,R.drawable.card32,R.drawable.card33,R.drawable.card34,R.drawable.card35,
            R.drawable.card36,R.drawable.card37,R.drawable.card38,R.drawable.card39,R.drawable.card40,R.drawable.card41,R.drawable.card42,R.drawable.card43,R.drawable.card44,R.drawable.card45,
            R.drawable.card46,R.drawable.card47,R.drawable.card48,R.drawable.card49,R.drawable.card50,
            R.drawable.card51,R.drawable.card52};
    List<String> rules = Arrays.asList("Waterfall. Everyone starts drinking at the same time. Person who draw this card can stop drinking first. Rest can stop drinking after the person on your right has stopped.", "Give 2 drinks to anyone.", "Take 3 drinks.", "All the ladies playing takes a drink.", "The person across from you takes a drink.", "All the guys take a drink.", "The drawer of this card sends 7 gulps to any player/players.",
            "Never have I ever. The person who drew this card says something they haven’t done before. Everyone who has done it takes a drink.", "Slap. The last person to slap their head takes a drink.", "Categories. The person who drew the card picks a category and says the first word on it. First person that fails to come up with a new word for that category takes a drink.", "Social. Everyone takes a drink.", "Questions. Go around in a circle and you have to keep asking questions to each other. Whoever messes up and does not say a question, drinks.", "Make any rule. The person that breaks it has to drink.", "Waterfall. Everyone starts drinking at the same time. Person who draw this card can stop drinking first. Rest can stop drinking after the person on your right has stopped.",
            "Give 2 drinks to anyone.", "Take 3 drinks.", "All the ladies playing takes a drink.", "The person across from you takes a drink.", "All the guys take a drink.", "The drawer of this card sends 7 gulps to any player/players.", "Never have I ever. The person who drew this card says something they haven’t done before. Everyone who has done it takes a drink.",
            "Slap. The last person to slap their head takes a drink.", "Categories. The person who drew the card picks a category and says the first word on it. First person that fails to come up with a new word for that category takes a drink.", "Social. Everyone takes a drink.", "Questions. Go around in a circle and you have to keep asking questions to each other. Whoever messes up and does not say a question, drinks.", "Make any rule. The person that breaks it has to drink.", "Waterfall. Everyone starts drinking at the same time. Person who draw this card can stop drinking first. Rest can stop drinking after the person on your right has stopped.", "Give 2 drinks to anyone.",
            "Take 3 drinks.", "All the ladies playing takes a drink.", "The person across from you takes a drink.", "All the guys take a drink.", "The drawer of this card sends 7 gulps to any player/players.", "Never have I ever. The person who drew this card says something they haven’t done before. Everyone who has done it takes a drink.", "Slap. The last person to slap their head takes a drink.",
            "Categories. The person who drew the card picks a category and says the first word on it. First person that fails to come up with a new word for that category takes a drink.", "Social. Everyone takes a drink.", "Questions. Go around in a circle and you have to keep asking questions to each other. Whoever messes up and does not say a question, drinks.", "Make any rule. The person that breaks it has to drink.", "Waterfall. Everyone starts drinking at the same time. Person who draw this card can stop drinking first. Rest can stop drinking after the person on your right has stopped.", "Give 2 drinks to anyone.", "Take 3 drinks.",
            "All the ladies playing takes a drink.", "The person across from you takes a drink.", "All the guys take a drink.", "The drawer of this card sends 7 gulps to any player/players.", "Never have I ever. The person who drew this card says something they haven’t done before. Everyone who has done it takes a drink.", "Slap. The last person to slap their head takes a drink.", "Categories. The person who drew the card picks a category and says the first word on it. First person that fails to come up with a new word for that category takes a drink.",
            "Social. Everyone takes a drink.", "Questions. Go around in a circle and you have to keep asking questions to each other. Whoever messes up and does not say a question, drinks.", "Make any rule. The person that breaks it has to drink.");

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
            ImageView img = (ImageView) findViewById(R.id.cardView);
            //img.setImageResource(cards[numbers[count]]);
            img.setImageResource(cards[suffledNumbers.get(count)]);
            TextView text = (TextView) findViewById(R.id.ruleView);
            text.setText(rules.get(suffledNumbers.get(count)));
            count++;
            return true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP & count>=52) {
            //End of the game
            //TextView text = (TextView) findViewById(R.id.ruleView);
            //text.setText("Game over");
            startActivity(new Intent(Game.this, Game_End.class));
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is presented
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}

