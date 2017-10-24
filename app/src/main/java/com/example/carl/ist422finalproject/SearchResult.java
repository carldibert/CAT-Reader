package com.example.carl.ist422finalproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by carl on 10/19/17.
 */

public class SearchResult extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reults);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new categories().execute();
            }
        });

    }

    public class categories extends AsyncTask<Void, Void, Void> {

        String words;

        Elements genres;

        @Override
        protected Void doInBackground(Void... params){

            try{
                Document doc = Jsoup.connect("http://www.mangareader.net/search")
                        .followRedirects(false)
                        .get();

                words = doc.title();

                genres = doc.getElementsByClass("genre r");
            } catch(Exception e){
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView text = (TextView) findViewById(R.id.textView2);
            text.setText(genres.size());
        }
    }

}
