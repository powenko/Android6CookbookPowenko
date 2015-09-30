package com.example.tutorial_mediaplayer_audio_recording;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button buttonPlayStop = (Button) findViewById(R.id.button1);
		buttonPlayStop.setOnClickListener(new OnClickListener() {
			@Override 
			public void onClick(View v) {
				if(mIsRecord==false){
					mIsRecord=true;
					buttonPlayStop.setText("Stop Recording.");
					AudioRecorder("/powenko.3gp");
					try {
						start();
					} catch (IOException e) {
				
						e.printStackTrace();
					}
				}else{

					buttonPlayStop.setText("Start Recording.");
					mIsRecord=false;
				
					try {
						stop();
					} catch (IOException e) {
	
						e.printStackTrace();
					}
				}
				
			}
			});
		
		recorder = new MediaRecorder();
		
	}

	private boolean mIsRecord=false;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	   MediaRecorder recorder; // = new MediaRecorder();
	   String m_path;

	  
	  
	      public void AudioRecorder(String filename) {
		     m_path = sanitizePath(filename);
		  }

		  private String sanitizePath(String path) {
		    if (!path.startsWith("/")) {
		    	m_path = "/" + m_path;
		    }
		    if (!path.contains(".")) {
		    	m_path += ".3gp";
		    }
		    return Environment.getExternalStorageDirectory().getAbsolutePath() + path;
		  }


		  public void start() throws IOException {
		    String state = android.os.Environment.getExternalStorageState();
		    if(!state.equals(android.os.Environment.MEDIA_MOUNTED))  {
		        throw new IOException("SD Card is not mounted.  It is " + state + ".");
		    }

		    // make sure the directory we plan to store the recording in exists
		    File directory = new File(m_path).getParentFile();
		    if (!directory.exists() && !directory.mkdirs()) {
		      throw new IOException("Path to file could not be created.");
		    }

		    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		    recorder.setOutputFile(m_path);
		    recorder.prepare();
		    recorder.start();
		  }

	
		  public void stop() throws IOException {
		    recorder.stop();
		    recorder.release();
		  }


}
