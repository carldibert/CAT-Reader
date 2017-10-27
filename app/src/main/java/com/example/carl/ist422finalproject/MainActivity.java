package com.example.carl.ist422finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendToMainScreen = (Button) findViewById(R.id.sendToSearchResult);
        sendToMainScreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MangaCategoriesSearchTab.class));
            }
        });

        Button mangaButton = (Button) findViewById(R.id.mangaButton);
        mangaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MangaMainPage.class));
            }
        });
    }

}
