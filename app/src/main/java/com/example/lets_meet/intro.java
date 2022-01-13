package com.example.lets_meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intro extends AppCompatActivity {
    Button sign,login;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        SharedPreferences sharedpreferences = getSharedPreferences("autoLogin", Context.MODE_PRIVATE);

        sign=findViewById(R.id.button1);
        login=findViewById(R.id.button);
         User obj1=new User();
        int j = sharedpreferences.getInt("key", 0);
        if(j > 0){
            Intent activity = new Intent(getApplicationContext(), home.class);
            startActivity(activity);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(intro.this,MainActivity.class));
                int autoSave = 1;
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("key", autoSave);
                editor.apply();



            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(intro.this,signup.class));
            }
        });



    }
}