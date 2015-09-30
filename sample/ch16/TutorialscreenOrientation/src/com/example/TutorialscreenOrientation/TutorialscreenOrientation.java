package com.example.TutorialscreenOrientation;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

public class TutorialscreenOrientation extends Activity {
	

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) 
    {
        super.onRestoreInstanceState(savedInstanceState);
        //---retrieve the information persisted earlier---
        String ID = savedInstanceState.getString("ID");   
    }
    
    @Override  
    public Object onRetainNonConfigurationInstance() 
    {   
        return("Hello");   
    }
    
  
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

     }


    
    
}