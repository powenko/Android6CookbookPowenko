package com.powenko.tutorial_event_implement;

import android.content.Intent;
import android.os.Handler;

public class MyClass {
	public interface TheListener {
	    public void somethingHappened(String i_string);
	}

	
	 private TheListener mTheListener;

	    public void setTheListener(TheListener listen) {
	        mTheListener = listen;
	    }
	    public void DoSomething(){
	    	
	    	Handler handler = new Handler();
	    	handler.postDelayed(new Runnable()
	    	{
	    	@Override
	    	public void run()
	    	{
	    		reportSomethingChanged() ;
	    	}
	    	
	    	}, 5000);
	    }

	    private void reportSomethingChanged() {
	        if (mTheListener != null) {
	            mTheListener.somethingHappened("call back"); 
	        }
	    }
}


