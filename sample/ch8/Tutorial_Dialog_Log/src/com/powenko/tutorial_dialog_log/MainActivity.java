 // 柯博文老師 www.powenko.com
package com.powenko.tutorial_dialog_log;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.v("powenko.com"," this is Verbose");   // Verbose 詳細
		Log.d("powenko.com"," this is Debug");  // Debug 除錯
		Log.i("powenko.com"," this is Info"); // Info 資訊
		Log.w("powenko.com"," this is Warning"); // Warning 警告
		Log.e("powenko.com"," this is Error"); // Error 錯誤

		/*
		boolean b1=true;
		String t1=Boolean.toString(b1);
		String t2 = Integer.toString(12345);
		String t3 = Float.toString(3.1415f);
		Log.v("powenko.com"," value:"+t2);
		*/
	}
	
}
