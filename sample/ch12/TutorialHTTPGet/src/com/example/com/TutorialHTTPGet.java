package com.example.com;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorialHTTPGet extends Activity {


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
			
			    String uriAPI ="http://search.yahooapis.com/ImageSearchService/V1/imageSearch?appid=YahooDemo&query=Madonna&output=json";
			         HttpPost httpRequest = new HttpPost(uriAPI); 
			         List <NameValuePair> params = new ArrayList <NameValuePair>(); 
			         params.add(new BasicNameValuePair("str", "I am Post String")); 
			         try 
			         { 
			           httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));         
			           HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);       
			           if(httpResponse.getStatusLine().getStatusCode() == 200)  
			           { 
			             
			             strResult = EntityUtils.toString(httpResponse.getEntity());
			             strResult="222";
			             mTextView1.setText(strResult);
			            // mTextView1.setText("1111111"); 
			           } 
			           else 
			           { 
			             mTextView1.setText("Error Response: "+httpResponse.getStatusLine().toString()); 
			           } 
			         } 
			         catch (ClientProtocolException e) 
			         {  
			           mTextView1.setText(e.getMessage().toString()); 
			           e.printStackTrace(); 
			         } 
			         catch (IOException e) 
			         {  
			           mTextView1.setText(e.getMessage().toString()); 
			           e.printStackTrace(); 
			         } 
			         catch (Exception e) 
			         {  
			           mTextView1.setText(e.getMessage().toString()); 
			           e.printStackTrace();  
			         }  
				
			}
		
		};
	
	
}

//Read more: http://getablogger.blogspot.com/2008/01/android-download-image-from-server-and.html#ixzz0hQ4f6C3F