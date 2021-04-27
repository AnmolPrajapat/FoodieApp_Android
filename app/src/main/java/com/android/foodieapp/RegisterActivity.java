package com.android.foodieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.foodieapp.Models.Customer;
import com.android.foodieapp.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog dialog;

//    EditText name, email, password,phone;
//    Button Register, fb,google,AlRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        dialog = new ProgressDialog(RegisterActivity.this);
        dialog.setTitle("Creating Account");
        dialog.setMessage("creating your Food Account");

        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
//
//        name= (EditText)findViewById(R.id.Rname);
//        email= (EditText)findViewById(R.id.Remail);
//        password= (EditText)findViewById(R.id.Rpass);
//        phone= (EditText)findViewById(R.id.Rphone);
//
//        Register=(Button)findViewById(R.id.btnRegister);
//        fb= (Button)findViewById(R.id.btnFB);
//        google=(Button)findViewById(R.id.btnGoogle);
//        AlRegister= (Button)findViewById(R.id.alreadyRegister);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
//                String n= binding.Rname.getText().toString();
//                String e= binding.Remail.getText().toString();
//                String pass = binding.Rpass.getText().toString();
//                String ph = binding.Rphone.getText().toString();
//
//                Toast.makeText(RegisterActivity.this,"name :"+ n+ "\n email : "+e+"\n phone no. :"+ph,Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
//                startActivity(intent);
                auth.createUserWithEmailAndPassword(binding.Remail.getText().toString(),binding.Rpass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                dialog.dismiss();
                                if(task.isSuccessful()){

                                    Customer customer = new Customer(binding.Rname.getText().toString(),binding.Remail.getText().toString(),
                                            binding.Rpass.getText().toString(),binding.Rphone.getText().toString());
                                    String id = task.getResult().getUser().getUid();
                                    database.getReference().child("customers").child(id).setValue(customer);

                                    Toast.makeText(RegisterActivity.this, "Successfully registerd", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        binding.btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Registering you with facebook", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Registering you with google", Toast.LENGTH_SHORT).show();
                Intent intent9 = new Intent(RegisterActivity.this,GoogleActvity.class);
                startActivity(intent9);
            }
        });
        binding.alreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}