package com.bilal.teacherdiary;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllStudents extends AppCompatActivity {

    DBHelper db;
    ListView listView;
    TextView head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allstudents);
        head = findViewById(R.id.headingTextView);
        db = new DBHelper(this);
        ArrayList<Student> students = db.getAllStudents();
        int size = students.size();
        head.setText("Total Students: " + size);
        listView = findViewById(R.id.listView);

        // Create an instance of the custom adapter
        StudentAdapter adapter = new StudentAdapter(this, students);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);
    }
}
