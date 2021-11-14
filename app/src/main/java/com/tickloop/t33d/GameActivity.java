package com.tickloop.t33d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class GameActivity extends AppCompatActivity {
    BottomNavigationView bottomNavView;
    GameFragment gameFragment = new GameFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.gameFragment);
        if (fragment == null) {
            fragment = new GameFragment();
            fm.beginTransaction()
                    .add(R.id.gameFragment, fragment)
                    .commit();
        }

        //Adding bottom navigation listener
        bottomNavView = findViewById(R.id.bottomNavigationView);
        bottomNavView.setSelectedItemId(R.id.game);
        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.game:
                        getSupportFragmentManager().beginTransaction().replace(R.id.gameFragment, gameFragment).commit();
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.gameFragment, profileFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}