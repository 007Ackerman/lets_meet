package com.example.lets_meet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class signup extends AppCompatActivity {

    FirebaseAuth auth;
    EditText name1,emailid,phone,password;
    Button signup;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();
        database= FirebaseFirestore.getInstance();
        name1=findViewById(R.id.name);
        emailid=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,email,phon,pass;
                name=name1.getText().toString();
                email=emailid.getText().toString();
                pass=password.getText().toString();
                phon=phone.getText().toString();

                User obj=new User();
                obj.setEmail(email);
                obj.setName(name);
                obj.setPhone(phon);
                obj.setPass(pass);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            database.collection("Users")
                                    .document(name).set(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    startActivity(new Intent(signup.this,MainActivity.class));
                                }
                            });
                            Toast.makeText(signup.this,"Account is Created",Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(signup.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}