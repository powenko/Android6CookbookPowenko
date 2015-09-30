package com.example.TutorialHTTPDownloadImage;


import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TutorialHTTPDownloadImage extends Activity {


private ImageView imView;
private Button bt3;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		
		Button bt3= (Button)findViewById(R.id.Button01);
		bt3.setOnClickListener(getImgListener);
		imView = (ImageView)findViewById(R.id.ImageView01);
	} 
	
		View.OnClickListener getImgListener = new View.OnClickListener()
		{
		
			@Override
			public void onClick(View view) {

		      
				downloadFile("http://spaceflightnow.com/news/n0211/04soho/sun.jpg");
			}
		
		};
	
	
		private Bitmap bmImg;
		void downloadFile(String fileUrl){
			URL myFileUrl =null; 
			try {
				myFileUrl= new URL(fileUrl);
			} catch (MalformedURLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
				conn.setDoInput(true);
				conn.connect();
				int length = conn.getContentLength();
				int[] bitmapData =new int[length];
				byte[] bitmapData2 =new byte[length];
				InputStream is = conn.getInputStream();
				
				bmImg = BitmapFactory.decodeStream(is);
				imView.setImageBitmap(bmImg);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}

//Read more: http://getablogger.blogspot.com/2008/01/android-download-image-from-server-and.html#ixzz0hQ4f6C3F