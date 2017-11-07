package com.example.carl.ist422finalproject;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.String.valueOf;

/**
 * Created by Carl on 10/26/2017.
 */

public class MangaCategoryViewer extends ListActivity {
    ArrayList<String> totalMangos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manga_categories);

        new MangaReaderCategories().execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String val = valueOf(position);
        String val2 = totalMangos.get(position);
        Log.d("Selection", val2);
    }

    private class MangaReaderCategories extends AsyncTask<Void, Void, Void> {

        ArrayList<String> sam = new ArrayList<String>();

        @Override
        protected Void doInBackground(Void... params) {

            ArrayList<String> copy = new ArrayList<String>();

            try {
                Document doc = Jsoup.connect("http://www.mangareader.net/search")
                        .followRedirects(false)
                        .get();


                Elements genres = doc.getElementsByClass("genre r0");

                for (int i = 0; i < genres.size(); i++)
                    copy.add(genres.get(i).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            String[] n;
            String[] t;
            String temp = "";
            for (int i = 0; i < copy.size(); i++) {
                n = copy.get(i).split(">");
                t = n[1].toString().split("<");
                temp = t[0].toString().replaceAll("\\s+", "");
                sam.add(temp);
            }

            totalMangos = sam;

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            String[] categoriesArray = sam.toArray(new String[sam.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),
                    android.R.layout.simple_list_item_1, categoriesArray);
            getListView().setAdapter(adapter);
        }
    }
}


