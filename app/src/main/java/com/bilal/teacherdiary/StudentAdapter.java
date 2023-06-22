package com.bilal.teacherdiary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bilal.teacherdiary.R;
import com.bilal.teacherdiary.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;
    private Context context;

    public StudentAdapter(ArrayList<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    // Create the view holder for each student item
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewFriendName;
        public TextView textViewDate;
        public TextView textViewCity;

        public StudentViewHolder(View itemView) {
            super(itemView);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewCity = itemView.findViewById(R.id.textViewCity);
        }
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each student item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchresult, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // Bind the data to the view holder
        Student student = studentList.get(position);
        holder.textViewFriendName.setText(student.getName());
        holder.textViewDate.setText(student.getRollNo());
        holder.textViewCity.setText(student.getclass());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
