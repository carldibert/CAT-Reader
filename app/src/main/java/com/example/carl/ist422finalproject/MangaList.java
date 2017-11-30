package com.example.carl.ist422finalproject;


import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by carl on 10/19/17.
 */

public class MangaList extends ListActivity {
    String websiteURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manga_list);
        websiteURL = getIntent().getStringExtra("WebsiteURL");

        new MangaCategoryResults().execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //the URL for the complete URL of selection
        String title = l.getItemAtPosition(position).toString();
        String titleExtension = getTitleExtension(title);
        String websiteURL = getWebsiteURL(titleExtension);

        //send to new page with the string categoryExtension as the websiteURL
        Intent intent = new Intent(MangaList.this, MangaResults.class);
        intent.putExtra("WebsiteURL",  websiteURL);
        startActivity(intent);
    }

    //creates website URL based on the title of the mango
    private String getWebsiteURL (String n){
        String websiteURL = "http://www.mangareader.net/" + n;
        return websiteURL;
    }

    //Intakes Search Information and Sends It Through the Website
    private String SearchResults (String n){
        //get Search Results and Send it here
        String SearchResults = "";
        return SearchResults;
    }


    //changes the title for a form that is able to be read by the website
    private String getTitleExtension(String n){
        String title = n;

        String titleEdited = title.replaceAll(" ", "-");
        title = titleEdited;

        titleEdited = title.replaceAll("!", "");
        title = titleEdited;

        titleEdited = title.replaceAll(":", "");
        title = titleEdited;

        titleEdited = title.replaceAll(";", "");
        title = titleEdited;

        return title;
    }

    //populates the listview with all of the titles
    private class MangaCategoryResults extends AsyncTask<Void, Void, Void> {

        ArrayList<String> titles = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... params) {

            ArrayList<String> copy = new ArrayList<>();
            ArrayList<String> noExtra = new ArrayList<>();

            try {
                Document doc = Jsoup.connect(websiteURL)
                        .followRedirects(false)
                        .get();


                Elements titles = doc.getElementsByClass("manga_name");

                for (int i = 0; i < titles.size(); i++)
                    copy.add(titles.get(i).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int i=0; i<copy.size(); i++){
                String[] temp = copy.get(i).toString().split(">");
                String[] temp2 = temp[4].split("<");
                noExtra.add(temp2[0]);
            }

            titles = noExtra;

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            String[] titlesArray = titles.toArray(new String[titles.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getListView().getContext(),
                    android.R.layout.simple_list_item_1, titlesArray);
            getListView().setAdapter(adapter);
        }
    }
}
