package com.powenko.tutorial_http_downloadmanager;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private long enqueue;
    private DownloadManager dm;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                	FunComplete(intent);
                }
            }
        };
 
        registerReceiver(receiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
		        Request request = new Request(
		                Uri.parse("http://www.powenko.com/wordpress/wp-content/uploads/2015/03/Screen-Shot-2015-03-06-at-7.43.47-AM.jpg"));
		        enqueue = dm.enqueue(request);
			}});
        
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
		        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
		        startActivity(i);
		}});
	}
	
	private void FunComplete(Intent intent){
		 long downloadId = intent.getLongExtra(
                 DownloadManager.EXTRA_DOWNLOAD_ID, 0);
         Query query = new Query();
         query.setFilterById(enqueue);
         Cursor c = dm.query(query);
         if (c.moveToFirst()) {
             int columnIndex = c
                     .getColumnIndex(DownloadManager.COLUMN_STATUS);
             if (DownloadManager.STATUS_SUCCESSFUL == c
                     .getInt(columnIndex)) {

                 ImageView view = (ImageView) findViewById(R.id.imageView1 );
                 String uriString = c
                         .getString(c
                                 .getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                 view.setImageURI(Uri.parse(uriString));
             }
         }
	}

}
