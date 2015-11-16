package com.example.TutorialImageProcess;



import java.io.FileOutputStream;


import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;

public class TutorialImageProcess extends Activity {
    private ImageView mIV;
    private Bitmap mBitmap;
    private int picw = 320;
    private int pich = 240;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);                                   
        

        
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a1);  
        picw = mBitmap.getWidth();
        pich = mBitmap.getHeight();

        mIV=(ImageView)findViewById(R.id.ImageView01);
   	
		Matrix mtx = new Matrix();
		mtx.postRotate(90);

		Bitmap rotatedBMP = Bitmap.createBitmap(mBitmap, 0, 0, picw, pich, mtx, true);
		BitmapDrawable bmd = new BitmapDrawable(rotatedBMP);

		mIV.setImageDrawable(bmd);

         }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {

		TintThePicture(20);	


		SaveThePicture();					        		     		         
		
	        return (true);
	    }
	    
	    return super.onKeyDown(keyCode, event);
	}
    
    private void TintThePicture(int deg) {
    	   int[] pix = new int[picw * pich];
    	   mBitmap.getPixels(pix, 0, picw, 0, 0, picw, pich);

    	   int RY, GY, BY, RYY, GYY, BYY, R, G, B, Y;
    	   double angle = (3.14159d * (double)deg) / 180.0d;
    	   int S = (int)(256.0d * Math.sin(angle));
    	   int C = (int)(256.0d * Math.cos(angle));

    	   for (int y = 0; y < pich; y++)
    	   for (int x = 0; x < picw; x++)
    	      {
    	      int index = y * picw + x;
    	      int r = (pix[index] >> 16) & 0xff;
    	      int g = (pix[index] >> 8) & 0xff;
    	      int b = pix[index] & 0xff;
    	      RY = ( 70 * r - 59 * g - 11 * b) / 100;
    	      GY = (-30 * r + 41 * g - 11 * b) / 100;
    	      BY = (-30 * r - 59 * g + 89 * b) / 100;
    	      Y  = ( 30 * r + 59 * g + 11 * b) / 100;
    	      RYY = (S * BY + C * RY) / 256;
    	      BYY = (C * BY - S * RY) / 256;
    	      GYY = (-51 * RYY - 19 * BYY) / 100;
    	      R = Y + RYY;
    	      R = (R < 0) ? 0 : ((R > 255) ? 255 : R);
    	      G = Y + GYY;
    	      G = (G < 0) ? 0 : ((G > 255) ? 255 : G);
    	      B = Y + BYY;
    	      B = (B < 0) ? 0 : ((B > 255) ? 255 : B);
    	      pix[index] = 0xff000000 | (R << 16) | (G << 8) | B;
    	      }


    	   Bitmap bm = Bitmap.createBitmap(picw, pich,Config.ARGB_8888  );
    	   bm.setPixels(pix, 0, picw, 0, 0, picw, pich);  	   
    		BitmapDrawable tBitmapDrawable = new BitmapDrawable(bm);

    		mIV.setImageDrawable(tBitmapDrawable);

    	   mBitmap = bm;
    	   pix = null;
    	}
      // Save the result onto a file
    private void SaveThePicture() {		  
	try { 	            
	    FileOutputStream fos = super.openFileOutput("output.jpg", MODE_WORLD_READABLE);
   
	    mBitmap.compress(CompressFormat.JPEG, 75, fos);
	            		          
	    fos.flush();	           
	    fos.close();	           
	} catch (Exception e) {	        
	    Log.e("MyLog", e.toString());	           
	} 	    
    }
}
