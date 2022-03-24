package com.example.runningapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class viewWorkouts_activity extends AppCompatActivity {

    RecyclerView normal_recycler;
    private WorkoutAdapter adapter;
    private ArrayList<Workouts> workoutsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workouts);

        normal_recycler= findViewById(R.id.workoutRecycler);

        normal_recycler.setLayoutManager(new LinearLayoutManager(this));
        workoutsArrayList= new ArrayList<>();
        adapter= new WorkoutAdapter(this, workoutsArrayList);
        normal_recycler.setAdapter(adapter);

        normal_recycler.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));


    }
}