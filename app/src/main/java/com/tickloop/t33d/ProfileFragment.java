package com.tickloop.t33d;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tickloop.t33d.api.models.Player;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private static String TAG = "ProfileFragmentTAG";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // setup on click listeners
        Button update = view.findViewById(R.id.update_button);
        update.setOnClickListener(this);

        Button delete = view.findViewById(R.id.delete_button);
        delete.setOnClickListener(this);

        // get the data to show to the user
        Player p = (Player) getActivity().getIntent().getSerializableExtra("player");
        Log.d(TAG, "onViewCreated: " + p);

        // set the values of textViews
        EditText username = view.findViewById(R.id.username);
        username.setText(p.getUsername());

        EditText password = view.findViewById(R.id.password);
        password.setText("password");
    }

    private static void update() {
        Log.d(TAG, "update: update called");
    }

    private static void delete() {
        Log.d(TAG, "delete: delete called");
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if(vId == R.id.update_button)
            update();
        else if(vId == R.id.delete_button)
            delete();
        else
            Log.d(TAG, "onClick: OnClick called with error binding");
    }
}