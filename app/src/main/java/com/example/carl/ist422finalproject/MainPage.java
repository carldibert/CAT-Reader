package com.example.carl.ist422finalproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Context context = getApplicationContext();
        CharSequence text = "Please read the disclaimer before using this app!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        Button comicButton = (Button) findViewById(R.id.comicButton);
        comicButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainPage.this, MangaSearch.class));
                //When we Get Comics Working, Get This Working ^^
            }
        });

        Button mangaButton = (Button) findViewById(R.id.mangaButton);
        mangaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainPage.this, MangaSearch.class));

            }
        });
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainPage.this, zSettings.class));
                //When we Get Comics Working, Get This Working ^^
            }
        });
    }

}
