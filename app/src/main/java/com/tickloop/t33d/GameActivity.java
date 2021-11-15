package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivityTAG";
    private String winner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle extras = getIntent().getExtras();
        ArrayList<String> playerList = extras.getStringArrayList("playerList");
        if(playerList.size() !=0){
            int randomVal = (int)(Math.random()*playerList.size());
            winner =playerList.get(randomVal);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        TextView text = findViewById(R.id.user_pl_text);
        if(text!=null) {
            text.setText(winner);
            boolean show = text.isShown();
            Log.d("onStart", "Is shown = " + show);
            Log.d("onStart", "Text set to show winner");
        }
        Log.d(TAG, "onStart: On Start was fired by the Android Framework");
    }
}