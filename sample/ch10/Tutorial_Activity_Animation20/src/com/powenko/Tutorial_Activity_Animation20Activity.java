// 柯博文 www.powenko.com
package com.powenko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_Activity_Animation20Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
          Button b1 = (Button) findViewById(R.id.button1);
          b1.setOnClickListener(new Button.OnClickListener(){
                   @Override
         		public void onClick(View v)
                {
                    
                	   Intent intent = new Intent();
                       intent.setClass(Tutorial_Activity_Animation20Activity.this, page2.class);
                       startActivity(intent);
                	   //Set the transition -> method available from Android 2.0 and beyond
                	   overridePendingTransition(R.anim.zoom_enter,R.anim.zoom_exit);
                }
                 });
             
    
    }
}