package com.looptek.AndroidOpenGLESPowenko;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;




public class TutorialPart001 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
 		GLSurfaceView view = new GLSurfaceView(this);
   		view.setRenderer(new TutorialPart001OpenGLRenderer());
   		setContentView(view);
    }
}

