// 柯博文老師 www.powenko.com
package com.powenko.Tutorial_Activity_ActivityIntentString;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_Activity_ActivityIntentStringActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);      
        
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
          public void onClick(View v)
          {
              Intent intent = new Intent();
        	  intent.setClass(Tutorial_Activity_ActivityIntentStringActivity.this, page2.class);
        	  
        	  Bundle bundle=new Bundle();
        	  bundle.putInt("intvlaue", 1);
        	  bundle.putString("Web", "www.powenko.com");          	        	  
        	  
        	  intent.putExtras(bundle);
        	  
        	  startActivity(intent);
        	  Tutorial_Activity_ActivityIntentStringActivity.this.finish();
          }
        });
    }
}