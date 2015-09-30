// 柯博文老師 www.powenko.com
package com.powenko;
import java.util.Random;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorialNotificationManagerActivity extends Activity {
	private static final int HELLO_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    showAppNotification();
                }
            });
    }
    
    
    public void  showAppNotification(){
        // Get a reference to the NotificationManager:
        	String ns = Context.NOTIFICATION_SERVICE;
        	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        	
            int icon = R.drawable.icon;
        	CharSequence tickerText = "Hello";
        	long when = System.currentTimeMillis();

        	Notification notification = new Notification(icon, tickerText, when); 	
        	
        	
        	
        	
        	//Define the notification's message and PendingIntent:
        	Context context = getApplicationContext();
        	CharSequence contentTitle = "My notification";
        	CharSequence contentText = "Hello World!";
        	Intent notificationIntent = new Intent(this, TutorialNotificationManagerActivity.class);
        	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        	notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        	//Pass the Notification to the NotificationManager:
        	mNotificationManager.notify(HELLO_ID, notification);
    }

    
    
    

}