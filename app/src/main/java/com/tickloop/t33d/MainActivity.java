package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tickloop.t33d.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: On Create was fired by the Android Framework");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: On Start was fired by the Android Framework");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: On Resume was fired by the Android Framework");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: On Pause was fired by the Android Framework");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: On Stop was fired by the Android Framework");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: On Destroy was fired by the Android Framework");
    }

    public void sendMessage(View view){
        // This is used to facilitate logging in
        Log.d(TAG, "sendMessage: Send Message was fired. User clicked the button");
        Intent intent2 = new Intent(this, LoginActivity.class);
        startActivity(intent2);
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }
}