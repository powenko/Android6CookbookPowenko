 // 柯博文老師 www.powenko.com
package com.powenko.Tutorial_Activity_Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_Activity_ActivityActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()                   //按鍵觸發動作
        {
          public void onClick(View v)
          {
           
              Intent intent = new Intent();
        	  intent.setClass(Tutorial_Activity_ActivityActivity.this, page2.class);
        	  startActivity(intent);
        	  Tutorial_Activity_ActivityActivity.this.finish();
          }
        });
        
    }
}