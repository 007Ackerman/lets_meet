package com.example.lets_meet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    int autoSave;

    EditText email,password;
    Button sign,login;
    FirebaseAuth auth;
    int j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.emaillogin);
        password=findViewById(R.id.passlogin);
        login=findViewById(R.id.button3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailid,pass;
                emailid=email.getText().toString();
                pass=password.getText().toString();

                auth.signInWithEmailAndPassword(emailid,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(MainActivity.this,home.class));
                            Toast.makeText(MainActivity.this,"Logged In",Toast.LENGTH_SHORT).show();

                        }else
                        {
                            Toast.makeText(MainActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });





    }
}