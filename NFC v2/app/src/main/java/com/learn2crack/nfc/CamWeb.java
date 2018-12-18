package com.learn2crack.nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.learn2crack.nfc.Camera.myResult;

public class CamWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_web);
        WebView webb=(WebView) findViewById(R.id.webview);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl(myResult);
        webb.getSettings().setJavaScriptEnabled(true);
    }
}
