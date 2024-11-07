package com.example.recycleviewdata_localdatabse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.student_card,parent,false);
        return new StudentAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyViewHolder holder, int position) {

        Student student= studentList.get(position);

        holder.name.setText(student.name);
        holder.age.setText(student.age+" Years Old");
        holder.grade.setText(student.grade+"");
        holder.address.setText(student.address);
        holder.distance.setText(student.distance+" Km");

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,age,grade,address,distance;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.edt_Name);
            age=itemView.findViewById(R.id.edt_Age);
            grade=itemView.findViewById(R.id.edt_Grade);
            address=itemView.findViewById(R.id.edt_Address);
            distance=itemView.findViewById(R.id.edt_Distance);
        }
    }
}

