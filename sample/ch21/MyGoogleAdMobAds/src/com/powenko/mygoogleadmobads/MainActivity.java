package com.powenko.mygoogleadmobads;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 AdView mAdView = (AdView) findViewById(R.id.adView);
	     AdRequest adRequest = new AdRequest.Builder().build();
	     mAdView.loadAd(adRequest);
	        
	}


}
