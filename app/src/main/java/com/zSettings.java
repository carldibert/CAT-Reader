package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.carl.ist422finalproject.MainPage;
import com.example.carl.ist422finalproject.R;

/**
 * Created by aschn on 12/3/2017.
 */

public class zSettings extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.z_settings);

            EditText mEdit = (EditText) findViewById(R.id.appVersionTxt);
            mEdit.setEnabled(false);

            Button disclaimerBtn = (Button) findViewById(R.id.disclaimerBtn);
            disclaimerBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(zSettings.this, disclaimer.class));
                    //When we Get Comics Working, Get This Working ^^
                }
            });

            Button creditsBtn = (Button) findViewById(R.id.creditsBtn);
            creditsBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(zSettings.this, credits.class));
                    //When we Get Comics Working, Get This Working ^^
                }
            });
    }
}
