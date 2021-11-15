package com.tickloop.t33d;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tickloop.t33d.api.models.Player;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateGameFragment} factory method to
 * create an instance of this fragment.
 */
public class CreateGameFragment extends Fragment implements  View.OnClickListener{
    private static final String TAG = "CreateGameFragmentTAG";

    public CreateGameFragment() {
        // Required empty public constructor
    }

    private View.OnClickListener launchLobby = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: On Click was called");
            Intent intent = new Intent(getActivity(), LobbyActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_game, container, false);

        // setting on click listeners
        Button join_game_button = view.findViewById(R.id.join_game_button);
        join_game_button.setOnClickListener(this);

        Button host_game_button = view.findViewById(R.id.host_game_button);
        host_game_button.setOnClickListener(this);

        // check if we got ourselves a player or not
        Player player = (Player) getActivity().getIntent().getSerializableExtra("player");
        Log.d(TAG, "onCreate: Player: " + player);

        return view;
    }

    private void hostGame() {
        Log.d(TAG, "onClick: On Click was called");
        Intent intent = new Intent(getActivity(), LobbyActivity.class);
        startActivity(intent);
    }

    private void joinGame() {
        Log.d(TAG, "onClick: On Click was called");
        Intent intent = new Intent(getActivity(), LobbyActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if (vId == R.id.host_game_button)
            hostGame();
        else if (vId == R.id.join_game_button)
            joinGame();
    }
}