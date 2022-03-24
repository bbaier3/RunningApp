package com.example.runningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_workout extends AppCompatActivity {

    private DBOpenHelper mySQLHandler;
    private EditText editWorkoutDate;
    private EditText editRepNumber;
    private EditText editRepDist;
    private EditText editWorkoutName;
    private EditText editWorkoutType;
    private SQLiteDatabase workoutsDB;
    private Button returnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        editWorkoutDate=findViewById(R.id.editWrktDate);
        editRepDist=findViewById(R.id.editRepDist);
        editWorkoutType=findViewById(R.id.editWorkType);
        editRepNumber=findViewById(R.id.editNumReps);
        editWorkoutName=findViewById(R.id.editWrkTitle);
        try {
            mySQLHandler = new DBOpenHelper(this);
            workoutsDB=mySQLHandler.getWritableDatabase();
            workoutsDB.execSQL("CREATE TABLE "+ DBStructure.EVENT_TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + DBStructure.WORKOUTNAME+"TEXT, "+ DBStructure.DATE+" TEXT, "+ DBStructure.NUMREPS+" TEXT, "+ DBStructure.WORKOUTTYPE+" TEXT,"
                    + DBStructure.REPDIST+" TEXT)");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        returnHome=findViewById(R.id.returnFromAdd);
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

    public void InsertDatabase(View view){
        mySQLHandler.SaveEvent(editWorkoutName.getText().toString(),editWorkoutDate.getText().toString(),editRepNumber.getText().toString(),editRepDist.getText().toString(), editWorkoutType.getText().toString(),workoutsDB);
        Toast.makeText(this,"Event Saved", Toast.LENGTH_SHORT).show();
    }
}