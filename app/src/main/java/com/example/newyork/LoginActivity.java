package com.example.newyork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_logemail;
    private EditText edt_logpassword;
    private int counter=3;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private Button logu,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_logemail=findViewById(R.id.edt_logemail);
        edt_logpassword=findViewById(R.id.edt_logpassword1);
        logu=findViewById(R.id.logu);
        signup = findViewById(R.id.b_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            finish();
            startActivity(new Intent(LoginActivity.this,LoginActivity.class));
        }
        logu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(edt_logemail.getText().toString(),edt_logpassword.getText().toString());
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

    }

    private void validate (String username , String password ){
        progressDialog.setMessage("You will be registered once you verify the email id !!! ");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Login Successful ",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed ",Toast.LENGTH_SHORT).show();
                    counter--;
                    if (counter==0){
                        logu.setEnabled(false);
                    }
                }
            }
        });

    }
}
