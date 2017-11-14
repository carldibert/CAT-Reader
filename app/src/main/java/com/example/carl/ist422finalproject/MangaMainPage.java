package com.example.carl.ist422finalproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        String mostPopularWebsiteURL = "http://www.mangareader.net/popular";
        Intent mostPopularIntent = new Intent(MangaMainPage.this, MangaCategoriesSearchTab.class);
        mostPopularIntent.putExtra("WebsiteURL", mostPopularWebsiteURL);
        startActivity(mostPopularIntent);

        String searchWebsiteURL = "http://www.mangareader.net/search/?w=" + replacedSearchText + "&rd=0&status=0&order=0&genre=0000000000000000000000000000000000000&p=0";
        Intent searchItent = new Intent(MangaMainPage.this, MangaCategoriesSearchTab.class);
        searchItent.putExtra("WebsiteURL", searchWebsiteURL);
        startActivity(searchItent);

        String mostRecentWebsiteURL = "http://www.mangareader.net/latest";
        Intent mostRecentIntent = new Intent(MangaMainPage.this, MangaCategoriesSearchTab.class);
        mostRecentIntent.putExtra("WebsiteURL", mostRecentWebsiteURL);
        startActivity(mostRecentIntent);
    }
}
