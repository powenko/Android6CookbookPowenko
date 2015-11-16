package com.looptek.AndroidOpenGLESPowenko;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

import com.looptek.AndroidOpenGLESPowenko.mesh.Cube;
import com.looptek.AndroidOpenGLESPowenko.mesh.Group;
import com.looptek.AndroidOpenGLESPowenko.mesh.Mesh;
import com.looptek.AndroidOpenGLESPowenko.mesh.Plane;

public class TutorialPart009OpenRenderer implements Renderer {
	//private TutorialPart008Square square;
	private Mesh root;
	
	//private TutorialPart007SmoothColoredSquare smoothSquare; // NEW LINE ADDED. 
	
	public TutorialPart009OpenRenderer() {
		Group group = new Group();
		Cube cube = new Cube(0.5f, 0.5f, 0.5f);
			
		cube.rx = 45;
		cube.ry = 45;
		cube.x=1.0f;
		cube.y=1.0f;
		cube.z=-1.0f;
		
		group.add(cube);
		
		Plane plane = new Plane(0.5f, 0.5f);
		plane.x=-1.0f;
		plane.y=1.0f;
		plane.z=-1.0f;		
		group.add(plane);
		
			
	
		
		
		root = group;
		root.setColor(0,0,1,1);
		
		
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

	
	private float angle; // Don't forget to add this.
	private float mx=0;
	private float my=0;
	private float mz=-10;
	private float mColorR=0.5f;
	private float mColorG=0.5f;
	private float mColorB=0.5f;
	private float mColorA=1.0f;
	
	public void onDrawFrame(GL10 gl) {

		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();
		// Translates 10 units into the screen.
		//gl.glTranslatef(mx, my, mz); 
		
		gl.glTranslatef(0, 0, -10); 

		// SQUARE A

		//gl.glRotatef(angle, 0, 0, 1);
		// setup color
		//gl.glColor4f(mColorR,mColorG,mColorB,mColorA);
		
		//square.draw(gl);
		root.draw(gl); 
		
		//angle++;
	}
	
	public void SetLocation(float i_x,float i_y,float i_z) 
	{
		mx=i_x;
		my=i_y;
		mz=i_z;		
	}
	public void SetColor(float i_R,float i_G,float i_B,float i_A) 
	{
		mColorR=i_R;
		mColorG=i_G;
		mColorB=i_B;	
		mColorA=i_A;		
	}

	
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
