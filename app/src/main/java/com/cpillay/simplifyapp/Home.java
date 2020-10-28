package com.cpillay.simplifyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseDatabase database;
    DatabaseReference reference;

    EditText age, weight, height, gender;
    Button next;
    String enteredAge, enteredWeight, enteredHeight, selectedSystem, enteredGender;
    information Information;
    Spinner dropdown2;
    int maxid = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gender = findViewById(R.id.etGender);
        age = findViewById(R.id.etAge);
        weight = findViewById(R.id.etWeight);
        height = findViewById(R.id.etHeight);
        next = findViewById(R.id.btnNext);

        dropdown2 = (Spinner) findViewById(R.id.spinner2);
        dropdown2.setOnItemSelectedListener(this);
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Metric");
        categories2.add("Imperial");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(dataAdapter2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("information");

                enteredAge = age.getText().toString();
                enteredGender = gender.getText().toString().trim();
                enteredWeight = weight.getText().toString().trim();
                enteredHeight = height.getText().toString().trim();
                selectedSystem = dropdown2.getSelectedItem().toString().trim();
                Information = new information(enteredAge, enteredWeight, enteredHeight, enteredGender, selectedSystem);


                if (!TextUtils.isEmpty(enteredAge) || !TextUtils.isEmpty(enteredGender) || !TextUtils.isEmpty(enteredAge) || !TextUtils.isEmpty(enteredWeight) || !TextUtils.isEmpty(enteredHeight) || !TextUtils.isEmpty(selectedSystem)) {


                    Toast.makeText(Home.this, "Data has been captured. ", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(Home.this, Log.class));
                    reference.push().setValue(Information);
                } else {
                    Toast.makeText(Home.this, "Enter all values!", Toast.LENGTH_SHORT).show();

                }


            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}


