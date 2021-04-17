package com.android.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText name, email, password,phone;
    Button Register, fb,google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        name= (EditText)findViewById(R.id.Rname);
        email= (EditText)findViewById(R.id.Remail);
        password= (EditText)findViewById(R.id.Rpass);
        phone= (EditText)findViewById(R.id.Rphone);

        Register=(Button)findViewById(R.id.btnRegister);
        fb= (Button)findViewById(R.id.btnFB);
        google=(Button)findViewById(R.id.btnGoogle);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n= name.getText().toString();
                String e= email.getText().toString();
                String pass = password.getText().toString();
                String ph = phone.getText().toString();

                Toast.makeText(RegisterActivity.this,"name :"+ n+ "\n email : "+e+"\n phone no. :"+ph,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Registering you with facebook", Toast.LENGTH_SHORT).show();
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Registering you with google", Toast.LENGTH_SHORT).show();
            }
        });
    }
}