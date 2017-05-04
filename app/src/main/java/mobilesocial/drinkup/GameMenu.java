package mobilesocial.drinkup;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import mobilesocial.drinkup.R;

/**
 * Created by Salla on 3.5.2017.
 */

public class GameMenu extends PreferenceActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handles actionbar item clicks here.
        switch (item.getItemId()) {
            case R.id.game_menu:
                Intent b = new Intent(GameMenu.this, App_Settings.class);
                startActivity(b);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}