package com.example.lets_meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    Button join,newmeet;



    URL serverurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        code=findViewById(R.id.secretcode);
        join=findViewById(R.id.joinmeet);
        newmeet=findViewById(R.id.new1);
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
                 JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setRoom(code.getText().toString())
                         .setWelcomePageEnabled(false).build();

                 JitsiMeetActivity.launch(home.this, options);
             }
         });

         newmeet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 JitsiMeetConferenceOptions options1 = new JitsiMeetConferenceOptions.Builder().setRoom("ABCD")
                         .setWelcomePageEnabled(false).build();

                 JitsiMeetActivity.launch(home.this, options1);
             }
         });



    }
}