package com.cpillay.simplifyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyProfile extends AppCompatActivity {


    EditText gender, height, weight, age;
    Spinner dropdown;
    Button editProfile, ViewProfile;
    information info;
    String enteredGender, enteredHeight, enteredAge;
    double enteredWeight;
    TextView showDataTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        editProfile = findViewById(R.id.btnEditProfile);
        ViewProfile = findViewById(R.id.btnViewProfile);


        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProfile.this, Home.class));

            }
        });

   /*ViewProfile.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           reference.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot MainSnapshot) {
                   for (DataSnapshot SubSnapshot : MainSnapshot.getChildren()) {

                       information info = SubSnapshot.getValue(information.class);

                       // Adding name and phone number of student into string that is coming from server.
                       String ShowDataString = "Age : " + info.getAge() + "\nGender : " + info.getGender() + "\nHeight : " + info.getHeight() + "\nWeight : " + info.getWeight() + "\nSystem : " + info.getSystem();

                       // Apply complete string variable into TextView.
                       showDataTextView.setText(ShowDataString);

                   }
               }
               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {
                   Toast.makeText(MyProfile.this,"Data access failed", Toast.LENGTH_LONG).show();

               }
           });*/
        //}
        //});


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.miProfile);

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
                        return true;

                }

                return false;
            }
        });


    }


}

