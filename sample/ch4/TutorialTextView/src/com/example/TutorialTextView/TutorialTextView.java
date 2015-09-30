// www.powenko.com
package com.example.TutorialTextView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class TutorialTextView extends Activity {
  
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView mmyTextView=(TextView) findViewById(R.id.myTextView);
        mmyTextView.setText("How Are you");
        mmyTextView.setBackgroundColor(Color.RED);
        mmyTextView.setTextColor(Color.rgb(0, 255, 0));
        mmyTextView.setHeight(100);
        mmyTextView.setTextSize(20);
                          
    }
}