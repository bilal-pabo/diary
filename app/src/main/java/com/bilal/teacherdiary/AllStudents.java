package com.bilal.teacherdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentAdapter adapter = new StudentAdapter(students, this);
        recyclerView.setAdapter(adapter);
    }
}
