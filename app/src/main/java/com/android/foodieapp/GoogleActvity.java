package com.android.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class GoogleActvity extends AppCompatActivity {
    EditText Gemail, dob;
    RadioButton male,female;
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_actvity);
        getSupportActionBar().hide();
//        getSupportActionBar().setTitle("Sync with google");
//
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        );
        Gemail = (EditText)findViewById(R.id.Gemail);
        dob = (EditText)findViewById(R.id.DoB);
        male=(RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);

        verify = (Button)findViewById(R.id.btnVerify);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = Gemail.getText().toString();
                String d = dob.getText().toString();
                String m = male.getText().toString();
                String f = female.getText().toString();

                Toast.makeText(GoogleActvity.this, "Email :"+ e + "\n Date of Birth :"+d , Toast.LENGTH_SHORT).show();
            }
        });
    }
}