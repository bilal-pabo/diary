package com.bilal.teacherdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentInfo extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6;
    Tasks db;
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentinfo);
        t4 = findViewById(R.id.t1);
        t5 = findViewById(R.id.t2);
        t6 = findViewById(R.id.t3);
        b1 = findViewById(R.id.edit);
        b2 = findViewById(R.id.save);
        t1 = findViewById(R.id.heading1);
        t2 = findViewById(R.id.heading2);
        t3 = findViewById(R.id.heading3);
        db = new Tasks(this);
        String name = getIntent().getStringExtra("name");
        String roll = getIntent().getStringExtra("roll");
        String Class = getIntent().getStringExtra("Class");
        t1.setText("Name: " + name);
        t2.setText("Roll Number: " + roll);
        t3.setText("Class: " + Class);
        Task record = db.searchRecords(roll);
        t4.setText(record.sabaq);
        t5.setText(record.sabaqi);
        t6.setText(record.manzil);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4.setEnabled(true);
                t5.setEnabled(true);
                t6.setEnabled(true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t4.isEnabled())
                {
                    if (t4.getText().toString().equals(record.sabaq) && t5.getText().toString().equals(record.sabaqi) &&
                    t6.getText().toString().equals(record.manzil))
                    {
                        Toast toast = Toast.makeText(StudentInfo.this, "No change detected", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        String s1 = t4.getText().toString(); String s2 = t5.getText().toString();
                        String s3 = t6.getText().toString();
                        int row = db.updateRecord(roll, s1, s2, s3);
                        if (row != 0)
                        {
                            Intent intent = new Intent(StudentInfo.this, AllStudents.class);
                            startActivity(intent);
                            Toast toast = Toast.makeText(StudentInfo.this, "Updated Successfully", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else {
                            Toast toast = Toast.makeText(StudentInfo.this, "Update Failed", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                }
                else
                {
                    Toast toast = Toast.makeText(StudentInfo.this, "Edit First", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });




    }
}
