package com.tickloop.t33d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private final String TAG = "SignupActivityTAG";
    private static final String URL = "https://t33d.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        Log.d(TAG, "onCreate: On Create was fired by the Android Framework");
    }

    public void signup(View v){
        // This is used to facilitate singing up
        Log.d(TAG, "signup: signup was fired. User clicked the button");

        // get values from input fields
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        Log.d(TAG, username);
        Log.d(TAG, password);

        if(username.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Username is empty", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast;
            if(password.equals((""))){
                toast = Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT);
            }else{
                toast = Toast.makeText(getApplicationContext(), "Good to go", Toast.LENGTH_SHORT);
            }
            toast.show();
        }
    }

    public void launchLogin(View v){
        // This is used to launch signup screen instead
        Log.d(TAG, "launchLogin: launchLogin was fired");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}