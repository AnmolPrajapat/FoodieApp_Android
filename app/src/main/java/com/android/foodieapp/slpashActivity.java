package com.android.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class slpashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slpash);
        getSupportActionBar().hide();
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(slpashActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        };thread.start();
    }
}