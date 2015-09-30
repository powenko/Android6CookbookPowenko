package com.looptek.AndroidOpenGLESPowenko;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AndroidOpenGLESPowenko extends Activity {
  /** Called when the activity is first created. */
	public static final int FIRST_ID = Menu.FIRST;
	public static final int SECOND_ID = FIRST_ID+1;
	public static final int THIR_ID = FIRST_ID+2;
	public static final int FOUR_ID = FIRST_ID+3;
	public static final int F4_ID = FIRST_ID+4;	
	public static final int F5_ID = FIRST_ID+5;	
	public static final int F6_ID = FIRST_ID+6;	
	public static final int F7_ID = FIRST_ID+7;	
	public static final int F8_ID = FIRST_ID+8;	
	public static final int F9_ID = FIRST_ID+9;	
	public static final int F10_ID = FIRST_ID+10;	
	public static final int F11_ID = FIRST_ID+11;		
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);      
      /*
      Intent mainIntent = new Intent(AndroidOpenGLESPowenko.this,TutorialPart011.class);    //logo
      startActivity(mainIntent);
		finish();
      */
  }
  
  
  
  public boolean onCreateOptionsMenu(Menu menu) {
  	boolean res =  super.onCreateOptionsMenu(menu);
  	menu.add(0, FIRST_ID, Menu.NONE, "1");
  	menu.add(0, SECOND_ID, Menu.NONE, "2");
  	menu.add(0, THIR_ID, Menu.NONE, "3");
  	menu.add(0, FOUR_ID, Menu.NONE, "4");
  	menu.add(0, F5_ID, Menu.NONE, "5");
	menu.add(0, F6_ID, Menu.NONE, "6");
	menu.add(0, F7_ID, Menu.NONE, "7");  
	menu.add(0, F8_ID, Menu.NONE, "8"); 
	menu.add(0, F9_ID, Menu.NONE, "9");  
	menu.add(0, F10_ID, Menu.NONE, "10");  
	menu.add(0, F11_ID, Menu.NONE, "11"); 

  	return res;
  }
 
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
  	Intent i= null;
      switch (item.getItemId()) {
      case FIRST_ID:
      	i = new Intent(this,TutorialPart001.class);
      	break;
      case SECOND_ID:
      	i = new Intent(this, TutorialPart002.class);
      	break;
      case THIR_ID:
      	i = new Intent(this, TutorialPart003.class);        	
      	break;
      case FOUR_ID:
          i = new Intent(this, TutorialPart004.class);        	
          break;    
      case F5_ID:
              i = new Intent(this, TutorialPart005.class);        	
           break;
      case F6_ID:
    	  	i = new Intent(this, TutorialPart006.class);        	
           break;  
      case F7_ID:
  	  		i = new Intent(this, TutorialPart007.class);        	
  	  	   break;       
      case F8_ID:
	  		i = new Intent(this, TutorialPart008.class);        	
	  	   break;   
	  case F9_ID:
		  	i = new Intent(this, TutorialPart009.class);        	
		   break;
	  case F10_ID:
		  	i = new Intent(this, TutorialPart010.class);        	
		   break;    			  	   
	  case F11_ID:
		  	i = new Intent(this, TutorialPart011.class);        	
		   break;   		   
      default:
      	i = null;
      }
      if (i != null)
      	this.startActivity(i);
  	return super.onOptionsItemSelected(item);
  }
}