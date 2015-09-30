// 柯博文老師 www.powenko.com
package com.powenko.Tutorial_Activity_ActivityIntentString;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class page2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2layout);
        Bundle bundle= this.getIntent().getExtras();
        int t_value=bundle.getInt("intvlaue");
        String t_web=bundle.getString("Web");      

        TextView t_textView_title = (TextView)findViewById(R.id.textView1);
        t_textView_title.setText(t_web+ t_value);
        
    }
}