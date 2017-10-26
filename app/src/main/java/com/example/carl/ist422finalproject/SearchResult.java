package com.example.carl.ist422finalproject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

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

        ArrayList<String> sam = new ArrayList<String>();

        @Override
        protected Void doInBackground(Void... params){

            ArrayList<String> copy  = new ArrayList<String>();

            try{
                Document doc = Jsoup.connect("http://www.mangareader.net/search")
                        .followRedirects(false)
                        .get();


                Elements genres = doc.getElementsByClass("genre r0");

                for(int i=0; i<genres.size(); i++)
                    copy.add(genres.get(i).toString());
            } catch(Exception e){
                e.printStackTrace();
            }

            String[] n;
            String[] t;
            String temp = "";
            for(int i=0; i<copy.size(); i++){
                n = copy.get(i).split(">");
                t = n[1].toString().split("<");
                temp = t[0].toString().replaceAll("\\s+", "");
                sam.add(temp);
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView text = (TextView) findViewById(R.id.textView2);
            text.setText(sam.get(36));
        }
    }

}
