package com.algerowalid13.user.ooredoosms;





        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.webkit.WebChromeClient;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.EditText;
        import android.annotation.SuppressLint;
        import android.app.Activity;
        import android.widget.Toast;

public class MainActivity extends Activity  {

    private static final String URL = "http://my.ooredoo.dz";
  //  private static final String URL = "file:///android_asset/index1.html";
    private WebView mWebView;
    String btn;
    @SuppressLint("SetJavaScriptEnabled")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);


        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(new WebChromeClient());

       mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                String user = ((EditText) findViewById(R.id.edit_text)).getText().toString();
                if (user.isEmpty()) {
                    user = "World";
                }

                String javascript = "javascript: document.getElementsByName('j_username')[0].value='0550489085'; javascript: document.getElementsByName('j_password')[0].value='cavock725';";

                //String javascript2="javascript: document.getElementsByName('j_password')[0].value='cavock725';";

                //String javascriptTO="document.getElementById('logoBar').focus();";


                  view.loadUrl(javascript);

            }
        });

        refreshWebView();

    }

    private void refreshWebView() {
       mWebView.loadUrl(URL);
    }

    public void connect(View v) {

        String btn = "javascript: document.getElementsByClassName('submit-button')[0].click(); ";
        mWebView.loadUrl(btn);

        // check if connection is Good
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                String jh = mWebView.getUrl();

                if (jh.toLowerCase().contains("accueil")) {

                    mWebView.loadUrl("http://my.ooredoo.dz/send-sms");
                    refreshWebView();

                    mWebView.setWebViewClient(new WebViewClient() {
                        @Override
                        public void onPageFinished(WebView view, String url) {

                            //  String javascriptTO = "javascript: document.getElementById('smsTo').value='0550489085'; javascript: $(document).ready(function() {$('#smsModelForm').validate();$('textarea#content').val('eeee');});";
                            // String javascriptMSG = "javascript: $(document).ready(function() {$('#smsModelForm').validate();$('textarea#content').val('eeee');});";
                            //  String javascriptCAPTCH="javascript: document.getElementsByName('j_captcha_response')[0].value='0550489085';";

                            String javascriptTO = "document.getElementByClass('smsImgCaptcha').focus();";

                            mWebView.loadUrl(javascriptTO);


                        }
                    });

                    refreshWebView();


                } else {
                    Toast.makeText(getApplicationContext(), "Erreur Identifiant ", Toast.LENGTH_LONG).show();
                }


            }
        });



    }





}














/*
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        try {
            fetchContent(mWebView,"http://www.google.fr");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  mWebView.loadUrl("https://my.ooredoo.dz");
    }



    public String fetchContent(WebView view, String url) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        HttpResponse response = httpClient.execute(get);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity); // assume html for simplicity
        view.loadDataWithBaseURL(url, html, "text/html", "utf-8", url); // todo: get mime, charset from entity
        if (statusCode != 200) {
            // handle fail
        }
        return html;
    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
*/