package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> studentList = new ArrayList<Student>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student s0 = new Student("Ghufran", R.drawable.person_24);
        Student s1 = new Student("Me", R.drawable.person_24);
        Student s2 = new Student("You", R.drawable.person_24);
        Student s3 = new Student("Nerd", R.drawable.person_24);
        Student s4 = new Student("Nerdiest", R.drawable.person_24);
        Student s5 = new Student("Looking Cool?", R.drawable.person_24);

        studentList.addAll(Arrays.asList(new Student[]{s0,s1,s2,s3,s4,s5}));

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new RVAdapter(studentList);
        recyclerView.setAdapter(adapter);
    }
}