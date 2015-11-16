package com.looptek.AndroidOpenGLESPowenko;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class TutorialPart009 extends Activity {
    /** Called when the activity is first created. */
	private TutorialPart009OpenRenderer mTutorialPart009OpenRenderer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
 		GLSurfaceView view = new GLSurfaceView(this);
 		mTutorialPart009OpenRenderer=new TutorialPart009OpenRenderer();
   		view.setRenderer(mTutorialPart009OpenRenderer);
   		setContentView(view);
    }

    @Override 
    public boolean onTouchEvent(MotionEvent event) 
    {
    	   int action = event.getAction();
    	   switch (action) { 
    	      case (MotionEvent.ACTION_DOWN) : // Touch screen pressed
    	         break; 
    	      case (MotionEvent.ACTION_UP) : // Touch screen touch ended
    	         break; 
    	      case (MotionEvent.ACTION_MOVE) : // Contact has moved across screen
    	    	  float t_x=event.getX();
    	          float t_y=event.getY();
    	          float t_x1=((t_x/320)-0.5f)*10.0f;
    	          float t_y1=-((t_y/480)-0.5f)*10.0f;    	              	         
    	    	  mTutorialPart009OpenRenderer.SetLocation(t_x1,t_y1,-10);
    	         break; 
    	      case (MotionEvent.ACTION_CANCEL) : // Touch event cancelled
    	         break;
    	   } 
    	   return super.onTouchEvent(event);
    }    
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent msg){
            switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_CENTER:                       	         
  	    	  		mTutorialPart009OpenRenderer.SetColor(1,0,0,1);
                    return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:                
	    	  		mTutorialPart009OpenRenderer.SetColor(0,1,0,1);                   
                    return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:                
    	  			mTutorialPart009OpenRenderer.SetColor(0,0,1,1);                   
    	  			return true;                    
            }

    return false;
    } 
	 
}