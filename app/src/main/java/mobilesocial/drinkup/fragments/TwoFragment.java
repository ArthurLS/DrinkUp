package mobilesocial.drinkup.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mobilesocial.drinkup.Game;
import mobilesocial.drinkup.R;


public class TwoFragment extends Fragment {

    public TwoFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_rules, container, false);

        Button start_game = (Button) rootView.findViewById(R.id.start_game2);

        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_start = new Intent(getActivity(), Game.class);
                startActivity(intent_start);
            }
        });
        return inflater.inflate(R.layout.fragment_rules, container, false);
    }

}
