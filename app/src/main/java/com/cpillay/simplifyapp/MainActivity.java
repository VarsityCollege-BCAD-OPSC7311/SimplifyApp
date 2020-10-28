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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText existingUsername, existingPassword;
    Button Login;
    TextView signUp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        existingUsername = (EditText) findViewById(R.id.etUsername);
        existingPassword = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        signUp = (TextView) findViewById(R.id.tvSignUp);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //if user has logged in before it will not require them to login again
        if (user != null) {
            finish();
            startActivity(new Intent(MainActivity.this, Log.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(existingUsername.getText().toString(), existingPassword.getText().toString());

            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccount.class));
            }

        });
    }

    private void validate(String userName, String userPassword) {
        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(MainActivity.this, MainHomePage.class));
                } else {
                    Toast.makeText(MainActivity.this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}