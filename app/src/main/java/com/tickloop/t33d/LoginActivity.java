package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tickloop.t33d.api.APIClient;
import com.tickloop.t33d.api.endpoints.SignupLogin;
import com.tickloop.t33d.api.models.SignupLoginResponse;
import com.tickloop.t33d.api.models.User;

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
        Log.d(TAG, "login: login was fired. Player clicked the button");

        // get the API Client and making the call
        // get values from input fields
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        if(username.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Username is empty", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Toast toast;
            if (password.equals((""))) {
                toast = Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT);
            } else {
                toast = Toast.makeText(getApplicationContext(), "Logging In", Toast.LENGTH_SHORT);

                // this is supposed to sign up the user
                com.tickloop.t33d.api.models.User user = new User(username, password);
                Call<SignupLoginResponse> call = APIClient.getClient()
                        .create(SignupLogin.class)
                        .login(user);

                call.enqueue(new Callback<SignupLoginResponse>() {
                    @Override
                    public void onResponse(Call<SignupLoginResponse> call, Response<SignupLoginResponse> response) {
                        Log.d(TAG, "onResponse: On Response was successful");
                        SignupLoginResponse r = response.body();

                        Log.d(TAG, "onResponse: " + r.getStatus());
                        Log.d(TAG, "onResponse: " + r.getPlayer());

                        // send the user to the next activity
                        if (r.getStatus().equals("ok")) {
                            Intent intent = new Intent(getApplicationContext(), CreateGameActivity.class);
                            intent.putExtra("player", r.getPlayer());
                            startActivity(intent);
                        } else {
                            // show an error toast
                            Toast toast = Toast.makeText(getApplicationContext(), "Error: Username/Password Incorrect", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupLoginResponse> call, Throwable t) {
                        Log.e(TAG, "onFailure: Login API Call failed!");
                    }
                });
            }
            toast.show();
        }
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