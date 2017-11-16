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

public class MangaSearchTab extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Button categoriesButton = (Button) findViewById(R.id.categoriesButton);
        categoriesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MangaSearchTab.this, MangaCategoryViewer.class));
            }
        });

        Button mostPopularButton = (Button) findViewById(R.id.mostPopularButton);
        mostPopularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mostPopularWebsiteURL = "http://www.mangareader.net/popular";
                Intent mostPopularIntent = new Intent(MangaSearchTab.this, MangaCategoriesSearchTab.class);

                mostPopularIntent.putExtra("websiteURL", mostPopularWebsiteURL);

            }
        });

        Button newestUpdatesButton = (Button) findViewById(R.id.newestUpdatesButton);
        newestUpdatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to newest updates on the website
            }
        });

        Button favortiesBtn = (Button) findViewById(R.id.favortiesBtn);
        favortiesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button bookmarksBtn = (Button) findViewById(R.id.bookmarksBtn);
        bookmarksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to bookmark page
            }
        });

        Button srchbutton = (Button) findViewById(R.id.srchbutton);
        srchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText searchbox = (EditText)findViewById(R.id.searchBox);
                String Search = searchbox.getText().toString();

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

                srchEdit = Search.replaceAll("[", "%5B");
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

                String searchWebsiteURL ="http://www.mangareader.net/search/?w=" + Search +
                        "&rd=0&status=0&order=0&genre=0000000000000000000000000000000000000&p=0";
                Intent searchIntent = new Intent(MangaSearchTab.this, MangaCategoriesSearchTab.class);
                searchIntent.putExtra("websiteURL", searchWebsiteURL);
                startActivity(searchIntent);
            }
        });
    }
}
