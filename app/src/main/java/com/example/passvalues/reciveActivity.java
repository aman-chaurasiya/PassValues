package com.example.passvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class reciveActivity extends AppCompatActivity {


    TextView textView, mobile,email,gender,course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);
        textView=findViewById(R.id.textView);
        mobile=findViewById(R.id.mobile);
        email=findViewById(R.id.email);
        gender=findViewById(R.id.gender);
        course = findViewById(R.id.course);


        Intent intent = getIntent();
        String name=intent.getStringExtra("name_key");
        String mobiles=intent.getStringExtra("mobile_key");
        String emails=intent.getStringExtra("email_key");
        String genders=intent.getStringExtra("gender_key");

        StringBuffer  buffer = new StringBuffer();
        String androidCH ="null";
        if(intent.hasExtra("android"))
        {
            androidCH=intent.getStringExtra("android");
            buffer.append(androidCH +" ,");
        }
        String iOSCH ="null";
        if(intent.hasExtra("iOS"))
        {
            iOSCH=intent.getStringExtra("iOS");
            buffer.append(iOSCH +" ,");
        }
        String javaCH ="null";
        if(intent.hasExtra("java"))
        {
            javaCH=intent.getStringExtra("java" );
            buffer.append(javaCH +", ");
        }
        String phpCH ="null";
        if(intent.hasExtra("php"))
        {
            phpCH=intent.getStringExtra("php");
            buffer.append(phpCH +", ");
        }
        if (TextUtils.isEmpty(buffer.toString()))
        {
            course.setText("no course selected");
        }else
        {
            course.setText(buffer.toString());
        }






        textView.setText(name);
        mobile.setText(mobiles);
        email.setText(emails);
        gender.setText(genders);




    }
}