package com.example.splashscreen;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.progressBar);
        new TimeThread(Splash.this, new splashProgress()).execute();
    }


          public class splashProgress extends Handler {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                //progressBar.setProgress((Integer)msg.obj);
                if(msg.arg1==1) {
                    finish();
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);

                }

                else
                progressBar.setProgress((Integer)msg.obj);




            }

        }






}