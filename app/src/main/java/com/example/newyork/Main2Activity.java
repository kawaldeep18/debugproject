package com.example.newyork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
final Button press=findViewById(R.id.press);
final Intent intent2=new Intent(this,Main3Activity.class);
press.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(intent2);
    }
});

    }
}
