package com.tickloop.t33d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity{
    private static final String TAG = "LoginActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: On Create was fired by the Android Framework");

        // adding click listeners
        Button login = (Button)findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This is used to facilitate logging in
                Log.d(TAG, "login: login was fired. User clicked the button");
                Intent intent = new Intent(getApplicationContext(), CreateGameActivity.class);
                startActivity(intent);
            }
        });

        TextView signup = (TextView) findViewById(R.id.signup_text);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This is used to launch signup screen instead
                Log.d(TAG, "launchSignup: launchSignup was fired");
                Intent intent = new Intent(getApplicationContext(), SignupScreenActivity.class);
                startActivity(intent);
            }
        });
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
}