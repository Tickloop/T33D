package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LobbyActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LobbyActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        // setting on click listeners
        Button play_game_button = findViewById(R.id.play_button);
        play_game_button.setOnClickListener(this);
    }

    private void launchGame() {
        Log.d(TAG, "onClick: Launch Game was fired");
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if(vId == R.id.play_button)
            launchGame();
    }
}