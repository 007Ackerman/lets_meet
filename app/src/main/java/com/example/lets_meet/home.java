package com.example.lets_meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class home extends AppCompatActivity {
    EditText code;
    Button join,newmeet,log;
    SharedPreferences sharedPreferences;
     String str;
    URL serverurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences("autoLogin", Context.MODE_PRIVATE);
        code=findViewById(R.id.secretcode);
        join=findViewById(R.id.joinmeet);
        newmeet=findViewById(R.id.new1);
        log=findViewById(R.id.logout);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("key", 0);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), intro.class);
                startActivity(intent);
            }
        });


         try {
             serverurl = new URL("https://meet.jit.si");
             JitsiMeetConferenceOptions defaultoptions;
             defaultoptions = new JitsiMeetConferenceOptions.Builder()
                     .setServerURL(serverurl)
                     .setWelcomePageEnabled(false)
                     .build();
             JitsiMeet.setDefaultConferenceOptions(defaultoptions);

         }catch(MalformedURLException e)
         {
             e.printStackTrace();
         }

         join.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setRoom(code.getText().toString()).setVideoMuted(true).setAudioMuted(true)
                         .setWelcomePageEnabled(false).setFeatureFlag("invite.enabled",false).build();

                 JitsiMeetActivity.launch(home.this, options);
             }
         });

         newmeet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                  User obj=new User();
                  int rand=(int)(Math.random()*10000);
                 str=Integer.toString(rand);

                 JitsiMeetConferenceOptions options1 = new JitsiMeetConferenceOptions.Builder().setRoom(str).setVideoMuted(true).setAudioMuted(true)
                         .setFeatureFlag("requireDisplayName",true)
                         .setWelcomePageEnabled(false).setFeatureFlag("invite.enabled",false).build();

                 JitsiMeetActivity.launch(home.this, options1);
             }
         });



    }
}