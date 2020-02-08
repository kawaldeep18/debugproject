package com.example.newyork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
final Button press=findViewById(R.id.back);
        final Intent intent4=new Intent(this,Main3Activity.class);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
    }
}
