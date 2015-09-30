package com.powenko.tutorial_dialog_popupwindow;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    
        final Button btnOpenPopup = (Button)findViewById(R.id.button1);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			  LayoutInflater layoutInflater  = (LayoutInflater)getBaseContext()
				      .getSystemService(LAYOUT_INFLATER_SERVICE);  
				    View popupView = layoutInflater.inflate(R.layout.popupwindow, null);  
				             final PopupWindow popupWindow = new PopupWindow(
				               popupView, 
				               LayoutParams.WRAP_CONTENT,  
				                     LayoutParams.WRAP_CONTENT);  
				             
				             Button btnDismiss = (Button)popupView.findViewById(R.id.button2);
				             btnDismiss.setOnClickListener(new Button.OnClickListener(){
							     @Override
							     public void onClick(View v) {
							    	 popupWindow.dismiss();
							     }});
				             popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
		}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

