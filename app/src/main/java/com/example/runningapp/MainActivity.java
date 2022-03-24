package com.example.runningapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView date_view;
    private Button add_workout;
    private Button view_workout;
    private Button check_weather;
    private Button athlete_stats;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)
                findViewById(R.id.calendar);
        date_view = (TextView)
                findViewById(R.id.date_view);

        add_workout = findViewById(R.id.addWRKbutton);
        add_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddWrkActivity();
            }
        });

        athlete_stats=findViewById(R.id.athleteStatsbttn);
        athlete_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewAthletesActivity();
            }
        });

        check_weather=findViewById(R.id.checkWeatherbttn);
        check_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeatherActivity();
            }
        });
    }

    public void openAddWrkActivity(){
        Intent intent= new Intent(this,add_workout.class);
        startActivity(intent);
    }

    public void openViewAthletesActivity(){
        Intent intent= new Intent(this,viewAthletes.class);
        startActivity(intent);
    }

    public void openWeatherActivity(){
        Intent intent= new Intent(this,weather.class);
        startActivity(intent);
    }
}