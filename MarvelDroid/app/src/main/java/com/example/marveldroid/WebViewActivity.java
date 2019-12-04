package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //Defino Webview
        browser = (WebView)findViewById((R.id.webViewId));
        browser.setWebViewClient(new WebViewClient(){


            public boolean ShouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
            }
        });
        //Cargo la web
        browser.loadUrl("https://www.youtube.com/");
    }
}
