package com.bilal.teacherdiary;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllStudents extends AppCompatActivity {

    DBHelper db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allstudents);

        db = new DBHelper(this);
        ArrayList<Student> students = db.getAllStudents();

        listView = findViewById(R.id.listView);

        // Create an instance of the custom adapter
        StudentAdapter adapter = new StudentAdapter(this, students);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);
    }
}
