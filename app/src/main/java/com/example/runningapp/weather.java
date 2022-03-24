package com.example.runningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class weather extends AppCompatActivity {

    private Button returnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather3);

        returnHome=findViewById(R.id.returnFromWeather);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

   public void openMainActivity(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}