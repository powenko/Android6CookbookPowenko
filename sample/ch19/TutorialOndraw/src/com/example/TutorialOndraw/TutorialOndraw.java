package com.example.TutorialOndraw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;


     
public class TutorialOndraw extends Activity {
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);     
            FrameLayout main = (FrameLayout) findViewById(R.id.main_view);
            main.addView(new Ball(this,50,50,25));
	        	 
	        	main.setOnTouchListener(new View.OnTouchListener() {
	        		 @Override
	        	    public boolean onTouch(View v, MotionEvent e) {
	        	        float x = e.getX();
	        	        float y = e.getY();
	        		   FrameLayout flView = (FrameLayout) v;
		                flView.addView(new Ball(TutorialOndraw.this, x,y,25));
	        		return true;
	        	    }
	        	});
	        
        
        }
        /////////////////////////////////
        public class Ball extends View {
        	private final float x;
            private final float y;
           
        	private final int r;
            private final Paint mPaint = new    Paint(Paint.ANTI_ALIAS_FLAG);
         
            public Ball(Context context, float x, float y, int r) {
                super(context);
                mPaint.setColor(0xFF00ffff);
                this.x = x;
                this.y = y;
                this.r = r;
            }

            @Override
           protected void onDraw(Canvas canvas) {
               super.onDraw(canvas);
               canvas.drawCircle(x, y, r, mPaint);
           }
        
        	 
        }
}