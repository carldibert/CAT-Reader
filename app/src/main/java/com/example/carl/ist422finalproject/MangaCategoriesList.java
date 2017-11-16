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

import static java.lang.String.valueOf;

/**
 * Created by Carl on 10/26/2017.
 */

public class MangaCategoriesList extends ListActivity {
    ArrayList<String> totalMangos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manga_categories_list);

        new MangaReaderCategories().execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //the URL for the complete URL of selection
        String categoryExtension = getCategoryExtension(position);

        //send to new page with the string categoryExtension as the websiteURL
        Intent intent = new Intent(MangaCategoriesList.this, MangaList.class);
        intent.putExtra("WebsiteURL",  categoryExtension);
        startActivity(intent);
    }

    //gets the total URL of the category that they are searching for
    private String getCategoryExtension(int n){
        String returnString = "";

        if(n==0){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=1000000000000000000000000000000000000&p=0";
        }else if (n==1){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0100000000000000000000000000000000000&p=0";
        }else if (n==2){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0100000000000000000000000000000000000&p=0";
        }else if (n==3){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0001000000000000000000000000000000000&p=0";
        }else if (n==4){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000100000000000000000000000000000000&p=0";
        }else if (n==5){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000010000000000000000000000000000000&p=0";
        }else if (n==6){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000001000000000000000000000000000000&p=0";
        }else if (n==7){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000100000000000000000000000000000&p=0";
        }else if (n==8){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000010000000000000000000000000000&p=0";
        }else if (n==9){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000001000000000000000000000000000&p=0";
        }else if (n==10){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000100000000000000000000000000&p=0";
        }else if (n==11){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000010000000000000000000000000&p=0";
        }else if (n==12){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000001000000000000000000000000&p=0";
        }else if (n==13){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000100000000000000000000000&p=0";
        }else if (n==14){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000010000000000000000000000&p=0";
        }else if (n==15){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000001000000000000000000000&p=0";
        }else if (n==16){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000100000000000000000000&p=0";
        }else if (n==17){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000010000000000000000000&p=0";
        }else if (n==18){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000001000000000000000000&p=0";
        }else if (n==19){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000100000000000000000&p=0";
        }else if (n==20){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000010000000000000000&p=0";
        }else if (n==21){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000001000000000000000&p=0";
        }else if (n==22){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000100000000000000&p=0";
        }else if (n==23){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000010000000000000&p=0";
        }else if (n==24){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000001000000000000&p=0";
        }else if (n==25){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000000100000000000&p=0";
        }else if (n==26){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000000010000000000&p=0";
        }else if (n==27){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000000001000000000&p=0";
        }else if (n==28){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000000000100000000&p=0";
        }else if (n==29){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000000000010000000&p=0";
        }else if (n==30){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000000000001000000&p=0";
        }else if (n==31){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000000000000100000&p=0";
        }else if (n==32){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000000000000010000&p=0";
        }else if (n==33){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000000000000001000&p=0";
        }else if (n==34){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000000000000000100&p=0";
        }else if (n==35){
            returnString = "http://www.mangareader.net/search/?w=&rd=0&status=0&order=0&genre=0000000000000000000000000000000000010&p=0";
        }else if (n==36){
            returnString = "http://www.mangareader.net/search/?w=&rd=&status=&order=&genre=0000000000000000000000000000000000001&p=0";
        }

        return returnString;
    }

    //populates the listview with all of the contents of the categories
    private class MangaReaderCategories extends AsyncTask<Void, Void, Void> {

        ArrayList<String> sam = new ArrayList<>();

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
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getListView().getContext(),
                    android.R.layout.simple_list_item_1, categoriesArray);
            getListView().setAdapter(adapter);
        }
    }
}


