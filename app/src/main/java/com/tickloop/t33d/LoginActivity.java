package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tickloop.t33d.api.APIClient;
import com.tickloop.t33d.api.endpoints.User;
import com.tickloop.t33d.api.models.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener {
    private static final String TAG = "LoginActivityTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: On Create was fired by the Android Framework");

        // adding click listeners
        Button login = findViewById(R.id.login_button);
        login.setOnClickListener(this);

        TextView signup = findViewById(R.id.signup_text);
        signup.setOnClickListener(this);
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

    private void login() {
        // This is used to facilitate logging in
        Log.d(TAG, "login: login was fired. User clicked the button");
//        Intent intent = new Intent(getApplicationContext(), CreateGameActivity.class);
//        startActivity(intent);

        // get the API Client and making the call
        Call<Result> c = APIClient.getClient().create(User.class).getUsers();
        c.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d(TAG, "onResponse: onResponse Called");
                Result r = response.body();
                Log.d(TAG, "onResponse: " + r.getUsers());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "onFailure: Request Failed!");
            }
        });
    }

    private void signup() {
        // This is used to launch signup screen instead
        Log.d(TAG, "launchSignup: launchSignup was fired");
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if(vId == R.id.login_button)
            login();
        else if(vId == R.id.signup_text)
            signup();
        else
            Log.i(TAG, "onClick: Error! onClick fired by unbound view");
    }
}