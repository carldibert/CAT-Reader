package com.example.carl.ist422finalproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendToMainScreen = (Button) findViewById(R.id.sendToSearchResult);
        sendToMainScreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SearchResult.class));
            }
        });
    }


    public class internet extends AsyncTask<Void, Void, Void> {

        String words;

        @Override
        protected Void doInBackground(Void... params){

            try{
                Document doc = Jsoup.connect("http://www.mangareader.net/")
                        .followRedirects(false)
                        .get();

                words = doc.title();
            } catch(Exception e){
                e.printStackTrace();
            }


            return null;
        }

//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            TextView text = (TextView) findViewById();
//            text.setText(words);
//        }
    }
}
