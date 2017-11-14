package com.example.carl.ist422finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carl on 10/26/2017.
 */

public class MangaMainPage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Button categoriesButton = (Button) findViewById(R.id.categoriesButton);
        categoriesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MangaMainPage.this, MangaCategoryViewer.class));
            }
        });
        Button srchbutton = (Button) findViewById(R.id.srchbutton);
        //insert onclick Activity

        //get information from search box, do Carl thing, Hope it works.

        Button mostPopularButton = (Button) findViewById(R.id.mostPopularButton);
        //insert onclick ACtivity

        Button newestUpdatesButton = (Button) findViewById(R.id.newestUpdatesButton);
        //insert onclick Activity

        Button favortiesBtn = (Button) findViewById(R.id.favortiesBtn);
        //inset onclick Activity

        Button bookmarksBtn = (Button) findViewById(R.id.bookmarksBtn);
        //inset onclick activity
    }

}
