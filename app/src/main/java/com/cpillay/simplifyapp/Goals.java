package com.cpillay.simplifyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Goals extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    EditText targetWeight, targetCalories, dailyWeight;
    Button save;
    String enteredTargetWeight, enteredTargetCalories, enteredDailyWeight;
    goalsClass Goals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        targetWeight = findViewById(R.id.etTargetWeight);
        targetCalories = findViewById(R.id.etTargetCalories);
        dailyWeight = findViewById(R.id.etDailyWeight);
        save = findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("goals");

                enteredTargetWeight = targetWeight.getText().toString().trim();
                enteredTargetCalories = targetCalories.getText().toString().trim();
                enteredDailyWeight = dailyWeight.getText().toString().trim();

                Goals = new goalsClass(enteredTargetWeight, enteredTargetCalories, enteredDailyWeight);

                if (!TextUtils.isEmpty(enteredTargetWeight) || !TextUtils.isEmpty(enteredTargetCalories) || !TextUtils.isEmpty(enteredDailyWeight)) {

                    startActivity(new Intent(Goals.this, MyDay.class));
                    Toast.makeText(Goals.this, "Data has been saved. ", Toast.LENGTH_LONG).show();


                    reference.push().setValue(Goals);
                } else {
                    Toast.makeText(Goals.this, "Enter all values!", Toast.LENGTH_SHORT).show();

                }

            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.miGoals);

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