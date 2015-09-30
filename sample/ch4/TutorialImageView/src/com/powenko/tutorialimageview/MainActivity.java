//柯博文老師 www.powenko.com
package com.powenko.tutorialimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private Button mmyButton01;
	private ImageView imageView1; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mmyButton01=(Button) findViewById(R.id.Button01);
		imageView1=(ImageView) findViewById(R.id.imageView1 );
		
		// 方法一:
		mmyButton01.setOnClickListener(new OnClickListener() {
		   public void onClick(View v) {
			   imageView1.setImageResource(R.drawable.watermelon );
		   }
		});
	}
}
