
package com.powenko.tutorial_service_sample2a;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;



public class PowenKoService extends Service {
	private static final String TAG = "MyService";
	MediaPlayer player;
	
	
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		player = MediaPlayer.create(this, R.raw.beep_v7);
		player.setLooping(true); // Set looping
	}

	@Override
	public void onDestroy() {

		MainActivity.updateLog(TAG + " ----> onDestroy()");
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		MainActivity.updateLog(TAG + " , onStart()");
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		player.start();
	}
	


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		MainActivity.updateLog(TAG + " , onStartCommand()");
		

	        new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	            	player.start();
	                try {  
	                    Thread.sleep(60*1000);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	                player.stop();
	            }  
	        }).start();  
	   
		
		
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		MainActivity.updateLog(TAG + " ,> onBind()");
		return null;
	}


	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		MainActivity.updateLog(TAG + ", onRebind()");
	}



	@Override
	public boolean onUnbind(Intent intent) {
		MainActivity.updateLog(TAG + ",onUnbind()");
		return super.onUnbind(intent);
	}
	
	
	
}
