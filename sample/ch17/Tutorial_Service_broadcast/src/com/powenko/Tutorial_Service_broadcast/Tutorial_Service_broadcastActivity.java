package com.powenko.Tutorial_Service_broadcast;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tutorial_Service_broadcastActivity extends Activity implements OnClickListener {
	private static final String TAG = "debug";
	private Button buttonStart;
	private Button buttonStop;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
     
      }

      public void onClick(View src) {
        switch (src.getId()) {
        case R.id.buttonStart:
          Log.d(TAG, "onClick: starting srvice");
          startService(new Intent(this, PowenKoService.class));
          break;
        case R.id.buttonStop:
          Log.d(TAG, "onClick: stopping srvice");
          stopService(new Intent(this, PowenKoService.class));
          break;
        }
      }
}