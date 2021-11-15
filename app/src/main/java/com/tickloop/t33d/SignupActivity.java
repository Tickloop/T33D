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

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "SignupActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        Log.d(TAG, "onCreate: On Create was fired by the Android Framework");

        //  setting the onClickListeners
        Button signup_button = findViewById(R.id.signup_button);
        signup_button.setOnClickListener(this);

        TextView login_text = findViewById(R.id.login_text);
        login_text.setOnClickListener(this);
    }

    public void signup(){
        // This is used to facilitate singing up
        Log.d(TAG, "signup: signup was fired. Player clicked the button");

        // get values from input fields
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();

        if(username.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Username is empty", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast;
            if(password.equals((""))){
                toast = Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT);
            }else{
                toast = Toast.makeText(getApplicationContext(), "Signing You Up", Toast.LENGTH_SHORT);

                // this is supposed to sign up the user
                User user = new User(username, password);
                Call<SignupLoginResponse> call = APIClient.getClient()
                        .create(SignupLogin.class)
                        .signup(user);

                call.enqueue(new Callback<SignupLoginResponse>() {
                    @Override
                    public void onResponse(Call<SignupLoginResponse> call, Response<SignupLoginResponse> response) {
                        Log.d(TAG, "onResponse: On Response was successful");
                        SignupLoginResponse r = response.body();

                        Log.d(TAG, "onResponse: " + r.getStatus());
                        Log.d(TAG, "onResponse: " + r.getPlayer());

                        // send the user to the next activity
                        if(r.getStatus().equals("ok")){
                            Intent intent = new Intent(getApplicationContext(), CreateGameActivity.class);
                            intent.putExtra("player", r.getPlayer());
                            startActivity(intent);
                        }else{
                            // show an error toast
                            Toast toast = Toast.makeText(getApplicationContext(), "Error: Username taken", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupLoginResponse> call, Throwable t) {
                        Log.e(TAG, "onFailure: Signup API Call failed!");
                    }
                });
            }
            toast.show();
        }
    }

    public void launchLogin(){
        // This is used to launch signup screen instead
        Log.d(TAG, "launchLogin: launchLogin was fired");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if(vId == R.id.signup_button)
            signup();
        else if(vId == R.id.login_text)
            launchLogin();
    }
}