package com.example.recycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyVH> {
    List<Student> studentData;

    public RVAdapter(List<Student> studentData) {
        this.studentData = studentData;
    }


    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_single_student_row, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data = studentData.get(position);
        holder.imageStudent.setImageResource(holder.data.getImage());
        holder.studentName.setText(holder.data.getName());

        holder.viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(Integer.toString(holder.getAdapterPosition()), "onClick: ");
            }
        });

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(Integer.toString(holder.getAdapterPosition()), "onClick: ");
            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(Integer.toString(holder.getAdapterPosition()), "onClick: ");
                studentData.remove(holder.getAdapterPosition());
                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return studentData.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        ImageView imageStudent;
        TextView studentName;
        ImageButton viewBtn, addBtn, deleteBtn;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            imageStudent = itemView.findViewById(R.id.studentImage);
            studentName = itemView.findViewById(R.id.studentName);
            viewBtn = itemView.findViewById(R.id.viewBtn);
            addBtn = itemView.findViewById(R.id.addBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
