package com.example.tutorial_ui_lockscreennotifications;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button Button1 =  (Button) findViewById(R.id.button1  );
		Button1.setOnClickListener(new View.OnClickListener()
		{
		    @Override
		    public void onClick(View v)
		    {

		      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.ic_launcher) // 顯示的圖片
                .setContentTitle("Notification!") //訊息的標題
                .setContentText("Hello www.powenko.com") // 訊息的內容
                .setAutoCancel(true); // 是否有清楚的按鍵
          Intent intent = new Intent(MainActivity.this, MainActivity.class);
          PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,Intent.FLAG_ACTIVITY_NEW_TASK);
          mBuilder.setContentIntent(pi);
          NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
          mNotificationManager.notify(0, mBuilder.build());
		      
        }
		});
		
	}

	
}
