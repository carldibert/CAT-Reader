package com.example.carl.ist422finalproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by carl on 11/10/17.
 */

public class MangaResults extends AppCompatActivity {

    String websiteURL = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manga_result);

        websiteURL = getIntent().getStringExtra("WebsiteURL");

        new MangaReaderCategories().execute();
    }

    private class MangaReaderCategories extends AsyncTask<Void, Void, Void> {

        String title = "";
        String author = "";
        String image = "";
        ArrayList<String> chapterList = new ArrayList<>();
        ArrayList<String> chapterDateList = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Document doc = Jsoup.connect(websiteURL.toLowerCase())
                        .followRedirects(false)
                        .get();

                //Initialize the elements we are pulling from the site
                Elements mangaName = doc.getElementsByClass("aname");
                Element mangaAuthor = doc.select("table").get(0);
                Element mangaImage = doc.getElementById("mangaimg");
                Element mangaChapters = doc.getElementById("listing");

                //gets the manga title
                String[] mangaSplit = mangaName.get(0).toString().split(">");
                String[] mangaSplit2 = mangaSplit[1].split("<");
                title = mangaSplit2[0];

                //gets the manga author
                String[] authorSplit = mangaAuthor.toString().split("<td>");
                String[] authorSplit2 = authorSplit[6].split("<");
                author = authorSplit2[0];

                //gets the image from the website
                String[] imageSplit = mangaImage.toString().split("<");
                String[] imageSplit2 = imageSplit[2].split("=");
                char[] imageChar = imageSplit2[1].toCharArray();
                ArrayList<Character> imageCharacters = new ArrayList<>();
                for(int i=1; i<imageChar.length-5; i++) {
                    imageCharacters.add(imageChar[i]);
                }
                StringBuilder builder = new StringBuilder(imageCharacters.size());
                for(int i=0; i<imageCharacters.size(); i++) {
                    builder.append(imageCharacters.get(i));
                }
                image = builder.toString();

                //gets the list off all of the chapters titles and their dates
                String[] mangaChapters1 = mangaChapters.toString().split("<td>");
                for(int i=1; i<mangaChapters1.length; i = i+2) {
                    String[] mangaChapterTitle = mangaChapters1[i].split(">");
                    String[] mangaChapterTitle1 = mangaChapterTitle[4].split("<");

                    String[] mangaChapterDate = mangaChapters1[i+1].split("<");

                    chapterList.add(mangaChapterTitle1[0]);
                    chapterDateList.add(mangaChapterDate[0]);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Log.e("title", title);

            TextView titleText = (TextView) findViewById(R.id.titleTextView);
            titleText.setText(title);

            TextView authorText = (TextView) findViewById(R.id.authorTextView);
            authorText.setText(author);

            ListView chapters = (ListView) findViewById(R.id.chaptersListView);

            ArrayList<String> chaptersArrayList = new ArrayList<>();
            for(int i=0; i<chapterList.size(); i++){
                int sampleNumber = i+1;
                String chapter = sampleNumber + chapterList.get(i) + "\t\t" + chapterDateList.get(0);
                chaptersArrayList.add(chapter);
            }
            String[] chaptersArray = chaptersArrayList.toArray(new String[chaptersArrayList.size()]);
            chapters.setAdapter(new ArrayAdapter<String>(chapters.getContext(), android.R.layout.simple_list_item_1 , chaptersArrayList));



            Log.e("chapter name", chapterList.get(0));
            Log.e("chapter date", chapterDateList.get(0));
        }
    }
}
