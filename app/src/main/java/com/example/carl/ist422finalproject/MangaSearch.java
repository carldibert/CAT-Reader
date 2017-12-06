package com.example.carl.ist422finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Carl on 10/26/2017.
 */

public class MangaSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Button categoriesButton = (Button) findViewById(R.id.categoriesButton);
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MangaSearch.this, MangaCategoriesList.class));
            }
        });

        Button searchButton = (Button) findViewById(R.id.srchbutton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText searchbox = (EditText) findViewById(R.id.searchBox);
                String Search = searchbox.getText().toString();

                String searchURL = "http://www.mangareader.net/search/?w=" + Search + "&rd=0&status=0&order=0&genre=0000000000000000000000000000000000000&p=0";

                Intent intent = new Intent(MangaSearch.this, MangaList.class);
                intent.putExtra("WebsiteURL", searchURL);
                startActivity(intent);
            }
        });

        Button mostPopularButton = (Button) findViewById(R.id.mostPopularButton);
        mostPopularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mostPopularURL = "http://www.mangareader.net/popular";

                Intent intent = new Intent(MangaSearch.this, MangaList.class);
                intent.putExtra("WebsiteURL", mostPopularURL);
                startActivity(intent);
            }
        });

        Button newestUpdatesButton = (Button) findViewById(R.id.newestUpdatesButton);
        newestUpdatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask Carl The Code To Have JSoup Look Go To Website
            }
        });

    }
}
