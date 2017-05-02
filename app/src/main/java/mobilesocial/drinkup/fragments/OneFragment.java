package mobilesocial.drinkup.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mobilesocial.drinkup.Game_Settings;
import mobilesocial.drinkup.R;

public class OneFragment extends Fragment {
    List<String> prenoms = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView list;
    EditText editTxt;
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_players, container, false);

        list = (ListView) rootView.findViewById(R.id.listFrag);

        editTxt = (EditText) rootView.findViewById(R.id.editText);
        editTxt.setImeOptions(EditorInfo.IME_ACTION_DONE);

        editTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    Log.i("TAGME","Enter pressed");
                    addPlayer();
                }
                return false;
            }
        });

        if(prenoms.isEmpty()){
            prenoms.add("Arthur");
            prenoms.add("Salla");
        }
        if (prenoms.size() > 8){
            editTxt.setVisibility(View.GONE);
        }





        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                prenoms);

        // Here, you set the data in your ListView
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String playerName = parent.getAdapter().getItem(position).toString();
                Log.d("TAGME", "Player Name:"+playerName);
                OnPlayerPressed(playerName);
            }
        });
        return rootView;
    }

    public void OnPlayerPressed(final String playerName) {
        new AlertDialog.Builder(getActivity())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Remove player")
                .setMessage("Are you sure you want to remove "+ playerName +"?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        prenoms.remove(playerName);
                        adapter.notifyDataSetChanged();
                        Log.d("TAGME", "The player has been removed");
                        if(prenoms.size() < 9){
                            editTxt.setVisibility(View.VISIBLE);
                        }
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void addPlayer(){
        String newplayer = editTxt.getText().toString();
        if (newplayer.length() == 0) {
            Toast.makeText(getActivity(), "A Man Has No Name.", Toast.LENGTH_SHORT).show();
        } else {
            prenoms.add(newplayer);
            adapter.notifyDataSetChanged();
            editTxt.setText("");
        }
        Log.i("TAGME", "Size: "+prenoms.size() );
        if(prenoms.size() > 8){
            editTxt.setVisibility(View.GONE);
        }
        Log.d("TAGME", "Player Added");
    }



}
