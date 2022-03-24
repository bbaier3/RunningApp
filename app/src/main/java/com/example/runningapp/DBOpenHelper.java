package com.example.runningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String CREATE_WORKOUT_TABLE = "CREATE TABLE "+ DBStructure.EVENT_TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DBStructure.WORKOUTNAME+"TEXT, "+ DBStructure.DATE+" TEXT, "+ DBStructure.NUMREPS+" TEXT, "+ DBStructure.WORKOUTTYPE+" TEXT,"
            + DBStructure.REPDIST+" TEXT)";
    private static final String DROP_EVENTS_TABLE= "DROP TABLE IF EXISTS "+ DBStructure.EVENT_TABLE_NAME;


    public DBOpenHelper(@Nullable Context context) {
        super(context, DBStructure.DB_NAME, null, DBStructure.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WORKOUT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREATE_WORKOUT_TABLE);
        onCreate(db);
    }


    public void SaveEvent(String wrkName, String date, String numReps, String repDist, String wrkoutType, SQLiteDatabase database){
        ContentValues contentValues= new ContentValues();
        contentValues.put(DBStructure.WORKOUTNAME,wrkName);
        contentValues.put(DBStructure.DATE,date);
        contentValues.put(DBStructure.NUMREPS,numReps);
        contentValues.put(DBStructure.REPDIST,repDist);
        contentValues.put(DBStructure.WORKOUTTYPE,wrkoutType);
        database.insert(DBStructure.EVENT_TABLE_NAME,null,contentValues);
    }

    public Cursor ReadEventsperMonth(String workoutname, String date,SQLiteDatabase database){
        String [] Projections= {DBStructure.WORKOUTNAME,DBStructure.DATE};
        String Selection= DBStructure.WORKOUTNAME+"=? and"+DBStructure.DATE+"=?";
        String [] SelectionArgs= {workoutname,date};

        return database.query(DBStructure.EVENT_TABLE_NAME,Projections,Selection,SelectionArgs,null,null,null);
    }




}
