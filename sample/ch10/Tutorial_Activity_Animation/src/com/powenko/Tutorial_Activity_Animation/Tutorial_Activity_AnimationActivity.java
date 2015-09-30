// 柯博文 www.powenko.com
package com.powenko.Tutorial_Activity_Animation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Tutorial_Activity_AnimationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
          @Override
		public void onClick(View v)
          {
           
        	  ActivityAnimations(getApplicationContext(),page2.class);//Tutorial_Activity_AnimationActivity.this);
          }
        });
    }
   // private Handler handler;
    private void ActivityAnimations(final Context i_Context,final Class i_class) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.mytranslate);
        a.reset();
       	RelativeLayout tv = (RelativeLayout) findViewById(R.id.relativeLayoutRoot);
        tv.clearAnimation();
        tv.startAnimation(a);
        Handler  handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
			public void run()
            {
            	  Intent intent = new Intent();
            	  intent.setClass(i_Context  , i_class);           	  
            	  startActivity(intent);
            }
        }, 900);
        
    }
  
}