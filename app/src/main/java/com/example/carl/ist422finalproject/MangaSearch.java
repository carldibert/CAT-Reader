package com.example.carl.ist422finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Carl on 10/26/2017.
 */

public class MangaSearch extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Button categoriesButton = (Button) findViewById(R.id.categoriesButton);
        categoriesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MangaSearch.this, MangaCategoriesList.class));
            }
        });

        Button searchButton = (Button) findViewById(R.id.srchbutton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText searchbox = (EditText)findViewById(R.id.searchBox);
                String Search = searchbox.getText().toString();
                MangaList list = new MangaList();

                String srchEdit = Search.replaceAll(",", "%2c");
                Search = srchEdit;

                srchEdit = Search.replaceAll(" ", "+");
                Search = srchEdit;

                srchEdit = Search.replaceAll(";", "%3B");
                Search = srchEdit;

                srchEdit = Search.replaceAll("&", "%26");
                Search = srchEdit;

                srchEdit = Search.replaceAll("%", "%25");
                Search = srchEdit;

                srchEdit = Search.replaceAll("$", "%24");
                Search = srchEdit;

                srchEdit = Search.replaceAll("@", "%40");
                Search = srchEdit;

                srchEdit = Search.replaceAll("!", "%21");
                Search = srchEdit;

                srchEdit = Search.replaceAll("=", "%3D");
                Search = srchEdit;

                srchEdit = Search.replaceAll("}", "%29");
                Search = srchEdit;

                srchEdit = Search.replaceAll("]", "%5D");
                Search = srchEdit;

                srchEdit = Search.replaceAll("|", "%7C");
                Search = srchEdit;

                srchEdit = Search.replaceAll(":", "%3A");
                Search = srchEdit;

                srchEdit = Search.replaceAll("'", "%27");
                Search = srchEdit;

                srchEdit = Search.replaceAll("/", "%2F");
                Search = srchEdit;

                srchEdit = Search.replaceAll("`", "%60");
                Search = srchEdit;

                //send to MangaList.java with website search

            }
        });

        //get information from search box, do Carl thing, Hope it works.

        Button mostPopularButton = (Button) findViewById(R.id.mostPopularButton);
        mostPopularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask Carl The Code To Have JSoup Look Go To Website
            }
        });

        Button newestUpdatesButton = (Button) findViewById(R.id.newestUpdatesButton);
        newestUpdatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask Carl The Code To Have JSoup Look Go To Website
            }
        });

        Button favoritesBtn = (Button) findViewById(R.id.favortiesBtn);
        favoritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create Favorites Java
            }
        });

        Button bookmarksBtn = (Button) findViewById(R.id.bookmarksBtn);
        bookmarksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create bookmarks Java
            }
        });
    }

}
