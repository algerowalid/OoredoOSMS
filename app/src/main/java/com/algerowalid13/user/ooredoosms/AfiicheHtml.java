package com.algerowalid13.user.ooredoosms;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;


import java.io.IOException;


public class AfiicheHtml extends ActionBarActivity {

    private final String htmlText = "<body><h1>Heading Text</h1><p>This tutorial " +
            "explains how to display " +
            "<strong>HTML </strong>text in android text view.&nbsp;</p>" +
            "<img src=\"hughjackman.jpg\">" +
            "<blockquote>Example from <a href=\"www.javatechig.com\">" +
            "Javatechig.com<a></blockquote></body>";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        HttpConnection.Response doc = null;
        try {
            doc = (HttpConnection.Response) Jsoup.connect("http://www.google.fr/").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // String title = doc.title();



//        TextView htmlTextView = (TextView)findViewById(R.id.html_text);
  //      htmlTextView.setText(Html.fromHtml(title, new Html.ImageGetter() {
/*
            @Override
            public Drawable getDrawable(String source) {
                return null;
            }
        }, null));
*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_html, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
