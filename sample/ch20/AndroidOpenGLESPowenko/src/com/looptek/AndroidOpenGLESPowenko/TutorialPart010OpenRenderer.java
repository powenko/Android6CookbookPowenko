package com.looptek.AndroidOpenGLESPowenko;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class TutorialPart010OpenRenderer implements Renderer {
	private TutorialPart010Square square;
	//private TutorialPart007SmoothColoredSquare smoothSquare; // NEW LINE ADDED. 
	
	public TutorialPart010OpenRenderer() {
		// Initialize our square. 
		square = new TutorialPart010Square();
	//	smoothSquare = new TutorialPart007SmoothColoredSquare(); // NEW LINE ADDED. 
	}
	 private float _width = 320f;
	    private float _height = 480f;
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
	   
		  float size = .01f * (float) Math.tan(Math.toRadians(45.0) / 2); 
		    float ratio = _width / _height;
		    // perspective:
		    gl.glFrustumf(-size, size, -size / ratio, size / ratio, 0.01f, 100.0f);
		   // orthographic:
		  //  gl.glOrthof(-1, 1, -1 / ratio, 1 / ratio, 0.01f, 100.0f);
		    gl.glViewport(0, 0, (int) _width, (int) _height);
		    gl.glMatrixMode(GL10.GL_MODELVIEW);
		    gl.glEnable(GL10.GL_DEPTH_TEST);
		  
		    
		/////////////////////////////
		    /*
		// Set the background color to black ( rgba ).
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
		// Enable Smooth Shading, default not really needed.
		gl.glShadeModel(GL10.GL_SMOOTH);
		// Depth buffer setup.
		gl.glClearDepthf(1.0f);
		// Enables depth testing.
		gl.glEnable(GL10.GL_DEPTH_TEST);
		// The type of depth testing to do.
		gl.glDepthFunc(GL10.GL_LEQUAL);
		// Really nice perspective calculations.
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		*/
		    // define the color we want to be displayed as the "clipping wall"
		    gl.glClearColor(0f, 0f, 0f, 1.0f);
		 
		    // enable the differentiation of which side may be visible 
		    gl.glEnable(GL10.GL_CULL_FACE);
		    // which is the front? the one which is drawn counter clockwise
		    gl.glFrontFace(GL10.GL_CCW);
		    // which one should NOT be drawn
		    gl.glCullFace(GL10.GL_BACK);
		 
		    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		    gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
	}

	
	private float angle; // Don't forget to add this.
	public void onDrawFrame(GL10 gl) {

		// Clears the screen and depth buffer.
		//gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

	    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		for (int i=1;i<10;i++)
		{
			gl.glLoadIdentity();  // Replace the current matrix with the identity matrix		
			//gl.glTranslatef(0, 0, -i*5); // Translates 10 units into the screen.
			gl.glTranslatef(0.0f, -1f, -1.0f + -1.5f * i);
		//	gl.glRotatef(angle, 0, 0, 1);		
			gl.glRotatef(angle, 1f, 0f, 0f);
	        gl.glRotatef(angle, 0f, 1f, 0f);
			// gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f); // setup color					
			square.draw(gl);  	// Draw our smooth square. 
		}
		
		angle=45;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.opengl.GLSurfaceView.Renderer#onSurfaceChanged(javax.microedition
	 * .khronos.opengles.GL10, int, int)
	 */
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// Sets the current view port to the new size.
		gl.glViewport(0, 0, width, height);
		// Select the projection matrix
		gl.glMatrixMode(GL10.GL_PROJECTION);
		// Reset the projection matrix
		gl.glLoadIdentity();
		// Calculate the aspect ratio of the window
		GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
				100.0f);
		// Select the modelview matrix
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		// Reset the modelview matrix
		gl.glLoadIdentity();
	}
}
