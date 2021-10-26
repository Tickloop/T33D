package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HomeScreenActivity extends AppCompatActivity {
    private static final String TAG = "HomeScreenTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
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

    public void updatePassword(View v){
        Log.d(TAG, "updatePassword: updatePassword was fired");
    }

    public void deleteAccount(View v){
        Log.d(TAG, "deleteAccount: deleteAccount was fired");
    }
}