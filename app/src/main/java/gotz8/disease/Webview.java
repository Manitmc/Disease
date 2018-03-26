package gotz8.disease;

import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * Created by Gotz8 on 2/14/2018.
 */

public class Webview extends Activity {
    private WebView webView;
    String url;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent i = getIntent();
        url = i.getStringExtra("url");

        webView = findViewById(R.id.wvDisplay);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

}