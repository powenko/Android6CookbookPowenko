package com.powenko.TutorialHTTPTimeOut;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class TutorialHTTPTimeOut extends Activity {


private ImageView imView;
private Button bt3;
private TextView mTextView1;
private String strResult; 
	/** Called when the activity is first created. */ 
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);

		mTextView1= (TextView)findViewById(R.id.TextView01);
		Button bt3= (Button)findViewById(R.id.Button01);
		bt3.setOnClickListener(getImgListener);
		
	} 
	
		View.OnClickListener getImgListener = new View.OnClickListener()
		{
		
			@Override
			public void onClick(View view) {
				mTextView1.setText("downloading....");
			    String uriAPI ="http://www.powenko.com";
			    String strResult="";
		    	try{
		    	
		    		HttpGet httpGet = new HttpGet(uriAPI);
		    	    HttpParams httpParameters = new BasicHttpParams();
		    	  
		    	    HttpConnectionParams.setConnectionTimeout(httpParameters, 30000);

		     
		    	    HttpConnectionParams.setSoTimeout(httpParameters, 10000);

		    	    DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
		    	    HttpResponse httpResponse = httpClient.execute(httpGet);
		   
		    	    if(httpResponse.getStatusLine().getStatusCode() == 200)  
		    	    { 
		    	    	strResult = EntityUtils.toString(httpResponse.getEntity()); 
		    	    }
		        	} catch (Exception e) {   
		      
		        	}
		        	if (strResult.length()>100){strResult=strResult.substring(0,100); }	    	       
		        	mTextView1.setText(strResult);
			           
				
			}
		
		};
	
	
}
