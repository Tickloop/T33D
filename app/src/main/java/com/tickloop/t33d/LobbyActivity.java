package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LobbyActivity extends AppCompatActivity {
    private static final String TAG = "LobbyActivityTAG";
    private final View.OnClickListener launchGame = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: Launch Game was fired");
            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        ((Button) findViewById(R.id.play_button)).setOnClickListener(launchGame);
    }
}