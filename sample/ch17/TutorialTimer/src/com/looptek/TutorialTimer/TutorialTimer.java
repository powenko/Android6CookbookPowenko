package com.looptek.TutorialTimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;



public class TutorialTimer extends Activity 
{
  TextView timeDisplay;
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    timeDisplay = new TextView(this);
    this.setContentView(timeDisplay);
    MyCount counter = new MyCount(5000, 1000);
    counter.start();
  }
  public class MyCount extends CountDownTimer 
  {
    public MyCount(long millisInFuture, long countDownInterval) 
    {
      super(millisInFuture, countDownInterval);
    }
    public void onFinish() 
    {
      timeDisplay.setText("Done!");
    }
    public void onTick(long millisUntilFinished) 
    {
       timeDisplay.setText("Left: " + millisUntilFinished / 1000);
    }
  }
  
}