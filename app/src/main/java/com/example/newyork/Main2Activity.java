package com.example.newyork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView bookslist=findViewById(R.id.bookslist);
        bookslist.setLayoutManager(new LinearLayoutManager(this));
        String[] books ={"The Glass Hotel","Long Bright River","The Authenticity Project"};
bookslist.setAdapter(new Booksadapter(books));
    }
}
