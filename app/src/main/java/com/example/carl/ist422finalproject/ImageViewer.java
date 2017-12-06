package com.example.carl.ist422finalproject;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

/**
 * Created by Tyler Brown on 11/30/2017.
 */

public class ImageViewer extends ListActivity {
String websiteURL = "";
    ImageView manga_img = (ImageView) findViewById(R.id.manga_page_img);
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_viewer);
        websiteURL = getIntent().getStringExtra("WebsiteURL");

        new ImageResults().execute();
    }

    private String getWebsiteURL (String n){
        String websiteURL = "http://www.mangareader.net/" + n;
        return websiteURL;
    }

    private class ImageResults extends AsyncTask<Void, Void, Void> {

        ArrayList<String> images = new ArrayList<>();


        protected Void doInBackground(Void... params) {

            try {
                Document doc = Jsoup.connect(websiteURL)
                        .followRedirects(false)
                        .get();

                Element totalChapters = doc.getElementById("selectpage");
                String[] pageSplit1 = totalChapters.toString().split("select");
                String[] pageSplit2 = pageSplit1[4].split("> of ");
                String[] pageSplit3 = pageSplit2[1].split("<");
                String totalPagesPerChapter = pageSplit3[0];

                ArrayList<String> totalPageURLPerChapter = new ArrayList<String>();
                StringBuilder same = new StringBuilder(3);
                for(int i=0; i<totalPagesPerChapter.toCharArray().length-1; i++) {
                    same.append(totalPagesPerChapter.toCharArray()[i]);
                }
                String notHavingFun = same.toString();
                int pagesPerChapter = Integer.parseInt(notHavingFun);

                for(int i=1; i<pagesPerChapter+1; i++) {
                    String sam = "";
                    if(i == 1) {
                        sam = websiteURL;
                    } else {
                        sam = websiteURL + "/" + i;
                    }
                    totalPageURLPerChapter.add(sam);
                }
                for(int i=0; i<totalPageURLPerChapter.size(); i++) {
                    try {
                        Document doc2 = Jsoup.connect(totalPageURLPerChapter.get(i))
                                .followRedirects(false)
                                .get();

                        Element image = doc2.getElementById("img");
                        String[] image2 = image.toString().split("=");
                        String[] image3 = image2[4].split("http://");
                        String[] image4 = image3[1].split(".jpg");
                        String sam = image4[0] + ".jpg";
                        images.add(sam);


                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            super.onPostExecute(avoid);
            Picasso.with(getApplicationContext()).load(images.get(0)).into(manga_img);
            String[] titlesArray = images.toArray(new String[images.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),
                    android.R.layout.simple_list_item_1, titlesArray);
            getListView().setAdapter(adapter);
        }
    }
}
