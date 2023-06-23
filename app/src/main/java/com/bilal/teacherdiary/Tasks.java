package com.bilal.teacherdiary;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Tasks extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "task_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "task";
    private static final String COLUMN_ROLLNO = "rollno";
    private static final String COLUMN_SABAQ = "sabaq";
    private static final String COLUMN_SABAQI = "sabaqi";
    private static final String COLUMN_MANZIL = "manzil";

    public Tasks(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ROLLNO + " INTEGER PRIMARY KEY," +
                COLUMN_SABAQ + " TEXT," +
                COLUMN_SABAQI + " TEXT," +
                COLUMN_MANZIL + " TEXT" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addRecord(String rollNo, String sabaq, String sabaqi, String manzil) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLLNO, rollNo);
        values.put(COLUMN_SABAQ, sabaq);
        values.put(COLUMN_SABAQI, sabaqi);
        values.put(COLUMN_MANZIL, manzil);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public int updateRecord(String rollNo, String sabaq, String sabaqi, String manzil) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SABAQ, sabaq);
        values.put(COLUMN_SABAQI, sabaqi);
        values.put(COLUMN_MANZIL, manzil);
        String selection = COLUMN_ROLLNO + " = ?";
        String[] selectionArgs = {String.valueOf(rollNo)};
        int row = db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
        return row;
    }

    public Task searchRecords(String rollNo) {
        Task record = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ROLLNO, COLUMN_SABAQ, COLUMN_SABAQI, COLUMN_MANZIL};
        String selection = COLUMN_ROLLNO + " = ?";
        String[] selectionArgs = {String.valueOf(rollNo)};
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {

                @SuppressLint("Range") String foundRollNo = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO));
                @SuppressLint("Range") String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_SABAQ));
                @SuppressLint("Range") String sabaqi = cursor.getString(cursor.getColumnIndex(COLUMN_SABAQI));
                @SuppressLint("Range") String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_MANZIL));

                record = new Task(foundRollNo, sabaq, sabaqi, manzil);


        }
        cursor.close();
        db.close();
        return record;
    }

}

