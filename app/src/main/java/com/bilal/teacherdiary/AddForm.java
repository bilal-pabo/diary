package com.bilal.teacherdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddForm extends AppCompatActivity {
    EditText name, rollNum, Class, sabaq, sabaqi, manzil;
    Button add;
    DBHelper db;
    Tasks db2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addform);
        name = findViewById(R.id.name);
        rollNum = findViewById(R.id.rollNum);
        Class = findViewById(R.id.Class);
        add = findViewById(R.id.add);
        sabaq = findViewById(R.id.t1);
        sabaqi = findViewById(R.id.t2);
        manzil = findViewById(R.id.t3);
        db = new DBHelper(this);
        db2 = new Tasks(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String RollNumber = rollNum.getText().toString();
                String StdClass = Class.getText().toString();
                String Sabaq = sabaq.getText().toString();
                String Sabaqi = sabaqi.getText().toString();
                String Manzil = manzil.getText().toString();
                if (Name.isEmpty() || RollNumber.isEmpty() || StdClass.isEmpty() || Sabaq.isEmpty() || Sabaqi.isEmpty() || Manzil.isEmpty())
                {
                    Toast.makeText(AddForm.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Student student = new Student(Name, RollNumber, StdClass);
                    long result = db.insertStudent(student);
                    long result2 = db2.addRecord(RollNumber, Sabaq, Sabaqi, Manzil);
                    if (result != -1 && result2 != -1)
                    {
                        Toast.makeText(AddForm.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(AddForm.this, "Operation Failed", Toast.LENGTH_SHORT).show();
                    }
                    name.setText("");
                    rollNum.setText("");
                    Class.setText("");
                    sabaq.setText("");
                    sabaqi.setText("");
                    manzil.setText("");
                }
                }
        });
    }
}
