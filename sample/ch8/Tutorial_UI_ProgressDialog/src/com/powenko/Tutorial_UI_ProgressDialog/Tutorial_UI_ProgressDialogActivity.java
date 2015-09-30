package com.powenko.Tutorial_UI_ProgressDialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tutorial_UI_ProgressDialogActivity extends Activity {
	
	private ProgressDialog progressDialog;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {
			fun1();
			}
		});  
	
		Button	button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {
			fun2();

			}
		}); 
        
    }
    
    public void fun1(){
    	progressDialog = ProgressDialog.show(this, "PowenKo.com, Please wait....", "Here your message");

    	new Thread(new Runnable(){
    		public void run(){
    			try {
    				int seconds=10;
			                Thread.sleep(seconds * 1000);
			        // dosomething();        
					progressDialog.dismiss();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}).start();
    }
    
    


	/////////
	private int progressBarStatus = 0;
	private ProgressDialog progressBar;
	private long fileSize = 0;
	
	private Handler progressBarHandler = new Handler();
	
	   public void fun2(){
		
			// prepare for a progress bar dialog
			progressBar = new ProgressDialog( Tutorial_UI_ProgressDialogActivity.this);
			progressBar.setCancelable(true);
			progressBar.setMessage("downloading ...");
			progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressBar.setProgress(0);
			progressBar.setMax(100);
			progressBar.show();
			/*
			new Thread(new Runnable(){
	    		public void run(){
	    			try {
	    				for(int i=0;i<100;i++){
	    					progressBar.setProgress(i);
	    					Thread.sleep(100);
	    				}
	    				progressBar.dismiss();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    		}
	    	}).start();
	  */
			
			progressBarStatus = 0;
			fun2_UI();
	   }
	   public void fun2_UI(){
	 //  int progressBarStatus = 0; //reset progress bar status
		fileSize = 0;   //reset filesize
		new Thread(new Runnable() {
		  public void run() {
			while (progressBarStatus < 100) {
			  progressBarStatus=doSomeTasks(); // process some tasks
			  try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }

			  // Update the progress bar
			  progressBarHandler.post(new Runnable() {
				public void run() {
				  progressBar.setProgress(progressBarStatus);
				}
			  });
			}
			// ok, file is downloaded,
			if (progressBarStatus >= 100) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progressBar.dismiss();
			}
		  }
	       }).start();
   }

	   public int doSomeTasks() {
	   		while (fileSize <= 1000000) {
	   			fileSize++;
	   			if (fileSize == 100000) {
	 				return 10;
	 			} else if (fileSize == 200000) {
	 				return 20;
	 			} else if (fileSize == 300000) {
	 				return 30;
	 			}
	      }
	  return 100;
	   	}


	
	
    
}