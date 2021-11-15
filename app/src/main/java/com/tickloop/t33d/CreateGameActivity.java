package com.tickloop.t33d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CreateGameActivity extends AppCompatActivity {
    private static final String TAG = "CreateGameActivityTAG";
    BottomNavigationView bottomNavView;
    CreateGameFragment createGameFragment = new CreateGameFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        //Start Game fragment when createGame activity is created
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.createGameFragment);
        if (fragment == null) {
            fragment = new CreateGameFragment();
            fm.beginTransaction()
                    .add(R.id.createGameFragment, fragment)
                    .commit();
        }

        //Adding bottom navigation listener
        bottomNavView = findViewById(R.id.bottomNavigationView);
        bottomNavView.setSelectedItemId(R.id.createGame);
        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.createGame:
                        getSupportFragmentManager().beginTransaction().replace(R.id.createGameFragment,
                                createGameFragment).commit();
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.createGameFragment,
                                profileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}