package com.example.passvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText name, mobile, email;
    private Button submit;
    private RadioGroup genderGroup;
    private  String genderstr;
    private CheckBox javaCHK,iOSCHK,androidCHK,phpCHK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        genderGroup=findViewById(R.id.genderGroup);
        androidCHK=findViewById(R.id.androidCHK);
        iOSCHK=findViewById(R.id.iOSCHK);
        javaCHK=findViewById(R.id.javaCHK);
        phpCHK=findViewById(R.id.phpCHK);


        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedID= findViewById(checkedId);
                 genderstr = selectedID.getText().toString();
            }
        });





        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namevalue = name.getText().toString();
                String mobilevalue = mobile.getText().toString();
                String emailvalue = email.getText().toString();
                String android = null;
                if(androidCHK.isChecked())
                {
                    android=androidCHK.getText().toString();
                }
                String iOS = null;
                if(iOSCHK.isChecked())
                {
                    iOS=iOSCHK.getText().toString();
                }
                String java = null;
                if(javaCHK.isChecked())
                {
                    java=javaCHK.getText().toString();
                }
                String php = null;
                if(phpCHK.isChecked())
                {
                    php=phpCHK.getText().toString();
                }





                Intent intent = new Intent(MainActivity.this, reciveActivity.class);
                intent.putExtra("name_key", namevalue);
                intent.putExtra("mobile_key", mobilevalue);
                intent.putExtra("email_key", emailvalue);
                intent.putExtra("gender_key",genderstr);


                if(!TextUtils.isEmpty(android))
                {
                    intent.putExtra("android",android);
                }
                if(!TextUtils.isEmpty(iOS))
                {
                    intent.putExtra("iOS",iOS);
                }
                if(!TextUtils.isEmpty(java))
                {
                    intent.putExtra("java",java);
                }
                if(!TextUtils.isEmpty(php))
                {
                    intent.putExtra("php",php);
                }


                startActivity(intent);


            }
        });

    }
}