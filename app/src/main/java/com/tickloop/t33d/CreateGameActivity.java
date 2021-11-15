package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tickloop.t33d.api.models.Player;

public class CreateGameActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CreateGameActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        // setting on click listeners
        Button join_game_button = findViewById(R.id.join_game_button);
        join_game_button.setOnClickListener(this);

        Button host_game_button = findViewById(R.id.host_game_button);
        host_game_button.setOnClickListener(this);

        // check if we got ourselves a player or not
        Player player = (Player) getIntent().getSerializableExtra("player");
        Log.d(TAG, "onCreate: Player: " + player);
    }

    private void hostGame() {
        Log.d(TAG, "onClick: On Click was called");
        Intent intent = new Intent(getApplicationContext(), LobbyActivity.class);
        startActivity(intent);
    }

    private void joinGame() {
        Log.d(TAG, "onClick: On Click was called");
        Intent intent = new Intent(getApplicationContext(), LobbyActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if(vId == R.id.host_game_button)
            hostGame();
        else if(vId == R.id.join_game_button)
            joinGame();
    }
}