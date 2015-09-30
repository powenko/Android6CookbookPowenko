package com.example.TutiroalDrawableImageView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;

public class TutiroalDrawableImageView extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	LinearLayout mLinearLayout;
    	super.onCreate(savedInstanceState);
    	mLinearLayout = new LinearLayout(this);
    	Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(), R.drawable.green);
    	DrawableImageView mDrawableImageView=new DrawableImageView(this,bitmapOrg);
    	mLinearLayout.addView(mDrawableImageView);
    	setContentView(mLinearLayout);
    }           
}