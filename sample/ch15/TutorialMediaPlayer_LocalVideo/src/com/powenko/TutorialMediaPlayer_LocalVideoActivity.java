package com.powenko;




import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class TutorialMediaPlayer_LocalVideoActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		VideoView videoView = (VideoView) findViewById(R.id.VideoView1);
	
	
	
		String uri = "android.resource://" + getPackageName() + "/" + R.raw.aaa;
	//	String uri = "android.resource://" + getPackageName() + "/" + R.raw.bbb;
		videoView.setVideoURI(Uri.parse(uri));
		videoView.requestFocus();
		videoView.setOnPreparedListener (new OnPreparedListener() {
		    @Override
		    public void onPrepared(MediaPlayer mp) {
		        mp.setLooping(true);
		    }
		});
		videoView.start();
		
	//	videoView.pause();
	//	videoView.stopPlayback();
		
		MediaController mediaController = new MediaController(this);
		videoView.setMediaController(mediaController);
		mediaController.setMediaPlayer(videoView);
		mediaController.show();
	
	}
}