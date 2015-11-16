package com.looptek.AndroidOpenGLESPowenko;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class TutorialPart005OpenRenderer implements Renderer {
	private TutorialPart005Square square;
	
	public TutorialPart005OpenRenderer() {
		// Initialize our square. 
		square = new TutorialPart005Square();
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
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
	}

	
	
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();	
		gl.glTranslatef(-2.2f, 2.5f, -10); 
		gl.glScalef(.5f, .5f, .5f);
		// Draw our square.
		square.draw(gl,1); 
		
		gl.glLoadIdentity();
		gl.glTranslatef(0, 2.5f, -10); 
		gl.glScalef(.5f, .5f, .5f);
		// Draw our square.
		square.draw(gl,2); 		
		
		gl.glLoadIdentity();
		gl.glTranslatef(2.2f, 2.5f, -10); 
		gl.glScalef(.5f, .5f, .5f);
		// Draw our square.
		square.draw(gl,3); 	
		gl.glLoadIdentity();	
		gl.glTranslatef(-2.2f,0, -10); 

		gl.glScalef(.5f, .5f, .5f);
		// Draw our square.
		square.draw(gl,4); 
		
		gl.glLoadIdentity();
		gl.glTranslatef(0, 0, -10);

		gl.glScalef(.5f, .5f, .5f);
		// Draw our square.
		square.draw(gl,5); 		
		
		
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
