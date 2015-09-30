package com.powenko.tutorial_ani_tweenanimation;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {

	  private ImageView myImageView01;
	    
	    @Override
	    public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	        setContentView(R.layout.activity_main);                                   
	        myImageView01=(ImageView)findViewById(R.id.ImageView01);
	       	
	    	Animation anim = null;
	    	anim = AnimationUtils.loadAnimation( this, R.anim.ani );	        
	    	myImageView01.startAnimation( anim );
	    	
	 
	    }

}
