package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CreateGameActivity extends AppCompatActivity {
    private static final String TAG = "CreateGameActivityTAG";

    private View.OnClickListener launchLobby = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: On Click was called");
            Intent intent = new Intent(getApplicationContext(), LobbyActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
        ((Button)findViewById(R.id.host_game_button)).setOnClickListener(launchLobby);
        ((Button)findViewById(R.id.join_game_button)).setOnClickListener(launchLobby);
    }
}