//柯博文老師 www.powenko.com
package com.example.TutorialImageButton;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class TutorialImageButton extends Activity {    
	private ImageButton mmyImageButton01;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);                
        mmyImageButton01=(ImageButton) findViewById(R.id.ImageButton01);
        mmyImageButton01.setOnClickListener(new OnClickListener() {
               public void onClick(View v) {            	 
            	   Bitmap tIcon1 = BitmapFactory.decodeResource(getResources(),R.drawable.pic1);                 
                   mmyImageButton01.setImageBitmap(tIcon1);             
               }
           });
    }
}
