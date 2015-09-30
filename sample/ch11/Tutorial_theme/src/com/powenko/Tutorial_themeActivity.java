package com.powenko;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;


public class Tutorial_themeActivity extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
         if ("Large".equalsIgnoreCase( getIntent().getStringExtra( "Theme" )))
         {
             setTheme(R.style.Theme_Large);
         }
         else if ("Small".equalsIgnoreCase( getIntent().getStringExtra( "Theme" )))
         {
             setTheme(R.style.Theme_Small);
         }
         super.onCreate(savedInstanceState);
         setContentView(R.layout.main);

         RadioButton largeText = ( RadioButton ) findViewById( R.id.textSizeLarge );
         largeText.setOnClickListener( new OnClickListener() {
             public void onClick( View view ) 
             {
                 Toast.makeText(Tutorial_themeActivity.this, "Large Text Selected", Toast.LENGTH_SHORT).show();
	            Intent intent = getIntent();
	            intent.putExtra( "Theme", "Large" );
	            finish();
	            startActivity(intent);
             }
    } );

    RadioButton smallText = ( RadioButton ) findViewById( R.id.textSizeSmall );
    smallText.setOnClickListener( new OnClickListener() {
        public void onClick( View view ) {
            Toast.makeText(Tutorial_themeActivity.this, "Small Text Selected", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            intent.putExtra( "Theme", "Small" );
            finish();
            startActivity(intent);
        }
    } );
}
}

