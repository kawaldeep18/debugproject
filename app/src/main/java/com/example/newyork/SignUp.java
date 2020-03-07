package com.example.newyork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText userName,userPassword, userEmail;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();
        firebaseAuth =FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //upload data to the firebase
                    String user_email= userEmail.getText().toString().trim();
                    String user_password =  userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent (SignUp.this,LoginActivity.class));
                            }
                            else{
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
    private void setupUIViews(){
        userName= (EditText)findViewById(R.id.et_name);
        userPassword=(EditText) findViewById(R.id.et_signup_pass);
        userEmail= (EditText)findViewById(R.id.et_Signup_email);
        signup= (Button)findViewById(R.id.b_signup_button);


    }
    private Boolean validate(){
        Boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email= userPassword.getText().toString();
        if (name.isEmpty()|| password.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"Please enter all details ",Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }
}
