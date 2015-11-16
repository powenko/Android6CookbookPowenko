package com.looptek.AndroidOpenGLESPowenko;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;


public class util {
    public static FloatBuffer createFloatBuffer(float data[]) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(data.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        FloatBuffer outBuffer = vbb.asFloatBuffer();
        outBuffer.put(data).position(0);
        return outBuffer;
    }
    
    public static IntBuffer createIntBuffer(int data[]) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(data.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        IntBuffer outBuffer = vbb.asIntBuffer();
        outBuffer.put(data).position(0);
        return outBuffer;
    }    

    public static CharBuffer createCharBuffer(char data[]) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(data.length * 2);
        vbb.order(ByteOrder.nativeOrder());
        CharBuffer outBuffer = vbb.asCharBuffer();
        outBuffer.put(data).position(0);
        return outBuffer;
    }    
    
    public static ByteBuffer createByteBuffer(byte data[]) {
        ByteBuffer vbb = ByteBuffer.allocateDirect(data.length);
        vbb.put(data).position(0);
        return vbb;
    }
    
    public static Bitmap getTextureFromBitmapResource(Context context, int resourceId) {
        Bitmap bitmap = null;
        Matrix yFlipMatrix = new Matrix();
        yFlipMatrix.postScale(1, -1); // flip Y axis
        try {
            bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),
                    yFlipMatrix, false);
        } finally {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }    
    
}
