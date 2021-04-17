package com.android.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Lname,Lpass;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login here");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Lname= (EditText)findViewById(R.id.loginEmail);
        Lpass= (EditText)findViewById(R.id.loginPassword);

        Login = (Button)findViewById(R.id.LoginActivityBtn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ln, lp;
                Ln = Lname.getText().toString();
                lp = Lpass.getText().toString();
                Toast.makeText(LoginActivity.this, "Login with"+" \n Email :"+ Ln + "\n Password :"+lp  , Toast.LENGTH_SHORT).show();
            }
        });
    }
}