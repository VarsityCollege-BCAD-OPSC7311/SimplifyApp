package com.cpillay.simplifyapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Log extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    public static final int CAMERA_REQUEST_CODE = 102;
    private static final int CAMERA_PERM_CODE = 101;
    private static final int CAMERA_REQUEST_CODE2 = 103;
    private static final int CAMERA_REQUEST_CODE4 = 104;
    private static final int CAMERA_REQUEST_CODE3 = 105;
    ImageButton pic1, pic2, pic3, pic4;
    ImageView imgBreakfast, imgLunch, imgSupper, imgSnack;
    private static final int CAN_REQUEST = 1313;
    EditText breakfast, lunch, supper, snacks;
    String enteredBreakfast, enteredLunch, enteredSupper, enteredSnacks;
    Button save;
    LogMealsHelperClass logMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        breakfast = findViewById(R.id.BreakfastCal);
        lunch = findViewById(R.id.Lunch);
        supper = findViewById(R.id.SupperCal);
        snacks = findViewById(R.id.SnacksCal);
        save = findViewById(R.id.btnSaveMeals);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("meals");

                enteredBreakfast = breakfast.getText().toString().trim();
                enteredLunch = lunch.getText().toString().trim();
                enteredSupper = supper.getText().toString().trim();
                enteredSnacks = snacks.getText().toString().trim();
                logMeals = new LogMealsHelperClass(enteredBreakfast, enteredLunch, enteredSupper, enteredSnacks);
                if (!TextUtils.isEmpty(enteredBreakfast) || !TextUtils.isEmpty(enteredLunch) || !TextUtils.isEmpty(enteredSupper) || !TextUtils.isEmpty(enteredSnacks)) {


                    Toast.makeText(Log.this, "Data has been saved. ", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(Log.this, MyDay.class));
                    reference.push().setValue(logMeals);
                } else {
                    Toast.makeText(Log.this, "Enter all values!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        pic1 = (ImageButton) findViewById(R.id.btnCamera1);
        pic2 = (ImageButton) findViewById(R.id.btnCamera2);
        pic3 = (ImageButton) findViewById(R.id.btnCamera3);
        pic4 = (ImageButton) findViewById(R.id.btnCamera4);

        imgBreakfast = (ImageView) findViewById(R.id.imageView);
        imgLunch = (ImageView) findViewById(R.id.imageView2);
        imgSupper = (ImageView) findViewById(R.id.imageView3);
        imgSnack = (ImageView) findViewById(R.id.imageView4);


        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCameraPermission();
            }
        });

        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //askCameraPermission();
                openCamera2();
            }
        });

        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //askCameraPermission();
                openCamera3();
            }
        });

        pic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // askCameraPermission();
                openCamera4();
            }
        });


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

    private void askCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        } else {
            openCamera();
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);


    }

    private void openCamera2() {
        Intent camera2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera2, CAMERA_REQUEST_CODE2);

    }

    private void openCamera3() {
        Intent camera3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera3, CAMERA_REQUEST_CODE3);


    }

    private void openCamera4() {
        Intent camera4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera4, CAMERA_REQUEST_CODE4);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imgBreakfast.setImageBitmap(image);

        } else if (requestCode == CAMERA_REQUEST_CODE2) {
            Bitmap image2 = (Bitmap) data.getExtras().get("data");
            imgLunch.setImageBitmap(image2);

        } else if (requestCode == CAMERA_REQUEST_CODE3) {
            Bitmap image3 = (Bitmap) data.getExtras().get("data");
            imgSupper.setImageBitmap(image3);

        } else {
            Bitmap image4 = (Bitmap) data.getExtras().get("data");
            imgSnack.setImageBitmap(image4);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(this, "Camera persmission is required.", Toast.LENGTH_SHORT).show();
            }
        }

    }

}