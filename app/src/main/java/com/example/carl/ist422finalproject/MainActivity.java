package com.example.carl.ist422finalproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.*;
import java.io.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import static java.lang.annotation.ElementType.METHOD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button funShitButton = (Button) findViewById();
//        funShitButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                new internet().execute();
//            }
//        });
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
