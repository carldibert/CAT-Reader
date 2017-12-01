package com.example.carl.ist422finalproject;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Tyler Brown on 11/30/2017.
 */

public class Image_Viewer extends ListActivity {
String websiteURL = "";
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manga_list);
        websiteURL = getIntent().getStringExtra("WebsiteURL");
        new ImageResults().execute();
    }


    private String getWebsiteURL (String n){
        String websiteURL = "http://www.mangareader.net/" + n;
        return websiteURL;
    }

    private class ImageResults extends AsyncTask<Void, Void, Void> {

        ArrayList<String> images = new ArrayList<>();


        @Override
        protected Void doInBackground(Void... params) {

            ArrayList<String> copy = new ArrayList<>();
            ArrayList<String> noExtra = new ArrayList<>();

            try {
                Document doc = Jsoup.connect(websiteURL)
                        .followRedirects(false)
                        .get();


                Elements imgs = doc.getElementsByTag("IMG");

                for (int i = 0; i < imgs.size(); i++)
                    copy.add(imgs.get(i).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int i=0; i<copy.size(); i++){
                String[] temp = copy.get(i).toString().split(">");
                String[] temp2 = temp[4].split("<");
                noExtra.add(temp2[0]);
            }

            images = noExtra;

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            String[] titlesArray = images.toArray(new String[images.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),
                    android.R.layout.simple_list_item_1, titlesArray);
            getListView().setAdapter(adapter);
        }
    }
}
