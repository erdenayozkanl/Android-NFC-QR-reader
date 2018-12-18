package com.learn2crack.nfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.learn2crack.nfc.NFCReadFragment.message;
import static com.learn2crack.nfc.NFCReadFragment.ndefMessage;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        WebView webb=(WebView) findViewById(R.id.webview);
        webb.setWebViewClient(new WebViewClient());

        webb.loadUrl(message);

        Intent intent = getIntent();
        onNewIntent(intent);
        String name = intent.getStringExtra("name");
        webb.loadUrl(name);
        webb.getSettings().setJavaScriptEnabled(true);
    }
}
