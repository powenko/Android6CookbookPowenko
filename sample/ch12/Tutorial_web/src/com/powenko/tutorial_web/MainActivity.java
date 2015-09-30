package com.powenko.tutorial_web;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView t_webView1=(WebView) findViewById(R.id.webView1);
		
		 WebSettings webSettings = t_webView1.getSettings();
	        

	        webSettings.setSaveFormData(false);
	        webSettings.setJavaScriptEnabled(true);
	        
	        webSettings.setSupportZoom(false);
	    t_webView1.setWebViewClient(new WebViewClient());
		
		t_webView1.loadUrl("http://www.powenko.com");
		
		
		
	   // <WebView
       // android:id="@+id/webView1"
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
