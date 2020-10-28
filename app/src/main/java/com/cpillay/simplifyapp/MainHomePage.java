package com.cpillay.simplifyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.cpillay.simplifyapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.miLog);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.miMyDay:
                        startActivity(new Intent(getApplicationContext(), MyDay.class));

                        overridePendingTransition(0, 0);

                        return true;

                    case R.id.miLog:
                        startActivity(new Intent(getApplicationContext(), Log.class));

                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.miGoals:
                        startActivity(new Intent(getApplicationContext(), Goals.class));

                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.miProfile:
                        startActivity(new Intent(getApplicationContext(), MyProfile.class));

                        overridePendingTransition(0, 0);
                        return true;

                }

                return false;
            }
        });

    }
}