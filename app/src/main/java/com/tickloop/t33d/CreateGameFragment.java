package com.tickloop.t33d;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateGameFragment} factory method to
 * create an instance of this fragment.
 */
public class CreateGameFragment extends Fragment {
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

        ((Button)view.findViewById(R.id.host_game_button)).setOnClickListener(launchLobby);
        ((Button)view.findViewById(R.id.join_game_button)).setOnClickListener(launchLobby);
        return view;
    }
}