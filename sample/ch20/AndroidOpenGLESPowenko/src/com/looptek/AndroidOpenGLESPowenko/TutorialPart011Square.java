package com.looptek.AndroidOpenGLESPowenko;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;



import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLUtils;

public class TutorialPart011Square {
	// Our vertices.
	private float vertices[] = {
		      -1.0f,  1.0f, 0.0f,  // 0, Top Left
		      -1.0f, -1.0f, 0.0f,  // 1, Bottom Left
		       1.0f, -1.0f, 0.0f,  // 2, Bottom Right
		       1.0f,  1.0f, 0.0f,  // 3, Top Right
		};

	
	   private float texCoords[] = {
	            // FRONT
	             0.0f, 1.0f,
	             0.0f, 0.0f,
	             1.0f, 0.0f,
	             1.0f, 1.0f
	   };

	// The order we like to connect them.
	private short[] indices = { 0, 1, 2, 0, 2, 3 };
	
	// Our vertex buffer.
	private FloatBuffer vertexBuffer;

	// Our index buffer.
	private ShortBuffer indexBuffer;
	
	public TutorialPart011Square(Context context) {
		
		mContext=context;
		// a float is 4 bytes, therefore we multiply the number if 
		// vertices with 4.
		
		
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		
		// short is 2 bytes, therefore we multiply the number if 
		// vertices with 2.
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer = ibb.asShortBuffer();
		indexBuffer.put(indices);
		indexBuffer.position(0);
		
		//----
		/*
		  // float has 4 bytes, colors (RGBA) * 4 bytes 
	    ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4); 
	    cbb.order(ByteOrder.nativeOrder()); 
	    colorBuffer = cbb.asFloatBuffer(); 
	    colorBuffer.put(colors); 
	    colorBuffer.position(0); 
	    */
		
		
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        mCubeTexBuffer = util.createFloatBuffer(texCoords);
        loadBitmapTex(gl, R.drawable.icon);
        
        

        gl.glEnable(GL10.GL_TEXTURE_2D); // Enable Texture Mapping ( NEW )
        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_FASTEST);

	}

    private FloatBuffer mCubeTexBuffer;
	protected Context mContext;
    private int mTextureID[];
	  private void loadBitmapTex(GL10 gl, int res){
	        Bitmap bmp = util.getTextureFromBitmapResource(mContext, res);
	        
	        mTextureID = new int[1];
	        gl.glGenTextures(1, mTextureID, 0);
	        gl.glBindTexture(GL10.GL_TEXTURE_2D, mTextureID[0]);

	        // Use Nearest for performance.
	        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
	                        GL10.GL_NEAREST);
	        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
	                        GL10.GL_NEAREST);


	        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,
	                        GL10.GL_CLAMP_TO_EDGE);
	        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,
	                        GL10.GL_CLAMP_TO_EDGE);

	        gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE,
	                        GL10.GL_REPLACE);

	        gl.glBindTexture(GL10.GL_TEXTURE_2D, mTextureID[0]);
	        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bmp, 0);
	        bmp.recycle();
	        return;
	    }
	/**
	 * This function draws our square on screen.
	 * @param gl
	 */
	public void draw(GL10 gl) {
		
		
		// Counter-clockwise winding.
		gl.glFrontFace(GL10.GL_CCW);
		// Enable face culling.
		gl.glEnable(GL10.GL_CULL_FACE);
		// What faces to remove with the face culling.
		gl.glCullFace(GL10.GL_BACK);

		//--Tutoirial 7-----------------------
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);


		//--Tutoirial 10 color-----------------------
		// Enable the color array buffer to be used during rendering.
		//gl.glEnableClientState(GL10.GL_COLOR_ARRAY); // NEW LINE ADDED.
		// Point out the where the color buffer is.
		//gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer); // NEW LINE ADDED.

		//--Tutoirial 10 color-----------------------
		

		//--Tutoirial 11 Texture-----------------------

        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mCubeTexBuffer);
		//--Tutoirial 11 Texture-----------------------
		
		
	 //	gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,			GL10.GL_UNSIGNED_SHORT, indexBuffer);
		
		

		//--Tutoirial 7-----------------------
		
		// Enabled the vertices buffer for writing and to be used during 
		// rendering.
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		// Specifies the location and data format of an array of vertex
		// coordinates to use when rendering.
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, 
				GL10.GL_UNSIGNED_SHORT, indexBuffer);
		
		// Disable the vertices buffer.
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		// Disable face culling.
		gl.glDisable(GL10.GL_CULL_FACE);
		
		//--Tutoirial 7-----------------------
		   // Disable the color buffer.
	//	gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		//--Tutoirial 7-----------------------
	}
	
}
