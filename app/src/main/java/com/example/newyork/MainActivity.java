package com.example.newyork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt_logemail=findViewById(R.id.edt_logemail);
        final EditText edt_logpassword=findViewById(R.id.edt_logpassword1);
        final Button logu=findViewById(R.id.logu);
        final Button signup = findViewById(R.id.b_signup);
        final Intent intent1 =new Intent(this,Main2Activity.class);
        //button
        logu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if (!edt_logemail.getText().toString().equals("admin")){
    if (!edt_logemail.getText().toString().equals("username")|| !edt_logpassword.getText().toString().equals("password")) {
        if (!edt_logemail.getText().toString().equals("username")) {
            edt_logemail.setError("Username is incorrect");
        }
        if (!edt_logpassword.getText().toString().equals("password")) {
            edt_logpassword.setError("Password is incorrect");
        }
    } else {
        startActivity(intent1);
    }
    }
}
            });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,SignUp.class);
               startActivity(intent);
            }
        });
    }
}
