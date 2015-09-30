package com.powenko.Tutorial_Activity_Animation;



import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;



public class page2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2layout);
 
    }

    // Use just onKeyDown() in Android 1.x or onBackPressed in Android 2.x
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled()) {
        	onBackPressed();
        	
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
    @Override
    public void onBackPressed() {
    	page2.this.finish();
      overridePendingTransition(R.anim.noanim, R.anim.mytranlate_out);
    }
    
}