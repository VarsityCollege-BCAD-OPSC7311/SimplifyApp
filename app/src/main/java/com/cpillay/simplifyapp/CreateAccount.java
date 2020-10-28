package com.cpillay.simplifyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    EditText Username, userPassword, userEmail;
    Button createBtn;
    TextView userLogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(CreateAccount.this, "Registration successful", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(CreateAccount.this, Home.class));
                            } else {
                                Toast.makeText(CreateAccount.this, "Registration failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CreateAccount.this, MainActivity.class));


            }
        });
    }


    private void setupUIViews() {
        Username = (EditText) findViewById(R.id.etNewUsername);
        userPassword = (EditText) findViewById(R.id.etNewPassword);
        userEmail = (EditText) findViewById(R.id.etEmail);
        createBtn = (Button) findViewById(R.id.btnCreateAccount1);
        userLogin = (TextView) findViewById(R.id.tvLogin);
    }

    private boolean validate() {
        Boolean result = false;
        String name = Username.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "All details are required", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}