package com.example.tutorial_ui_statusbarnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String DEBUG_TAG = null;
	private static final int LIST_UPDATE_NOTIFICATION = 0;
	private static final int HELLO_ID = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		////////

		Button Button01 = (Button)findViewById(R.id.button1 );
		Button01.setOnClickListener(new OnClickListener() {
		  public void onClick(View v) {
				fun_statusbarnotification(); 
		  }
		});
		Button Button02 = (Button)findViewById(R.id.button2 );
		Button02.setOnClickListener(new OnClickListener() {
		  public void onClick(View v) {
				fun_statusbarnotification2(); 
		  }
		});

		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	private void fun_statusbarnotification2(){
		
		Context context = MainActivity.this
			    .getApplicationContext();
			NotificationManager notificationManager = (NotificationManager) context
			    .getSystemService(NOTIFICATION_SERVICE);
			////////
			Notification updateComplete = new Notification();
			updateComplete.icon = android.R.drawable.stat_notify_sync;
			updateComplete.tickerText = context.getText(R.string.notification_title);
			updateComplete.when = System.currentTimeMillis();
			////////////
			Intent notificationIntent = new Intent(context,
					MainActivity.class);
				PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				    notificationIntent, 0);
		   /////////////		
				String contentTitle = context.getText(R.string.notification_title)
					    .toString();
					String contentText;
					boolean result=true;
					if (!result) {
						Log.w(DEBUG_TAG, "XML download and parse had errors");
					    contentText = context.getText(R.string.notification_info_fail)
					        .toString();
					} else {
					    contentText = context.getText(R.string.notification_info_success).toString();
					}
					updateComplete.setLatestEventInfo(context, contentTitle,
					    contentText, contentIntent);
			////////////		
					notificationManager.notify(LIST_UPDATE_NOTIFICATION, updateComplete);
					
			
       
	}
	

	private void fun_statusbarnotification(){
		   //// Get a reference to the NotificationManager:
	    String ns = Context.NOTIFICATION_SERVICE;
	    NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
	    //// Instantiate the Notification:
	    int icon = R.drawable.ic_launcher ;
	    CharSequence tickerText = "PowenKo";
	    long when = System.currentTimeMillis();
	
	    Notification notification = new Notification(icon, tickerText, when);
	    // Define the Notification's expanded message and Intent:
	    Context context = getApplicationContext();
	    CharSequence contentTitle = "PowenKo's notification";
	    CharSequence contentText = "Hello PowenKo!";
	    Intent notificationIntent = new Intent(this, MainActivity.class);
	    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	
	    notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
	    //Pass the Notification to the NotificationManager:
	
	    mNotificationManager.notify(HELLO_ID, notification);
	}

	
	
}
