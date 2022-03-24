package com.example.runningapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutHolder> {

    //Workout Adapter
    private Context context;
    private ArrayList<Workouts> workoutsArrayList;

    //constructor

    public WorkoutAdapter(Context context, ArrayList<Workouts> workoutsArrayList) {
        this.context = context;
        this.workoutsArrayList = workoutsArrayList;
    }

    @NonNull
    @Override
    public WorkoutAdapter.WorkoutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.WorkoutHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //Workout Holder is a separate class

    class WorkoutHolder extends RecyclerView.ViewHolder{

        private Text textWrkname, textWrkDate, textWrkRep, textWrkDistance, textWrkType;

        public WorkoutHolder(@NonNull View itemView) {
            super(itemView);
            textWrkname= itemView.findViewById(R.id.textWrkName);
            textWrkDate=itemView.findViewById(R.id.textWrkDate);
            textWrkType=itemView.findViewById(R.id.textWrkType);
            textWrkRep=itemView.findViewById(R.id.textWrkRep);
            textWrkDistance=itemView.findViewById(R.id.textWrkDistance);
        }
    }
}
