// 柯博文老師 www.powenko.com
package com.example.TutorialEditText;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
// 顏色定義
// 按鍵觸發事件
// 鍵盤監聽定義
// 輸入資料元件的定義檔

public class TutorialEditText extends Activity {
    /** Called when the activity is first created. */
	private TextView mmyTextView;
	private EditText mmyEditText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mmyTextView=(TextView) findViewById(R.id.myTextView);
        mmyTextView.setText("How Are you");
        mmyTextView.setBackgroundColor(Color.RED);
        mmyTextView.setTextColor(Color.rgb(0, 255, 0));
        mmyTextView.setHeight(100);
        mmyTextView.setTextSize(20);
        
         
 	   
 	   
        mmyEditText=(EditText) findViewById(R.id.myEditText);
        mmyEditText.setTextColor(Color.GREEN);
        String ttext1=mmyEditText.getText().toString();	
              
        mmyEditText.setOnKeyListener(new OnKeyListener() {      // 監聽鍵盤動作           
        @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {                 
            if(event.getAction() == KeyEvent.ACTION_UP){      // 按鍵放掉的時候
        	   String ttext=mmyEditText.getText().toString();	    
        	   mmyTextView.setText(ttext);         	   
            }
            return false;
           }
        });
        /*
        mmyEditText.setOnKeyListener(new OnKeyListener() {      // 監聽鍵盤動作           
        	@Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {                 
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
        		            (keyCode == KeyEvent.KEYCODE_ENTER)) {
        	   String ttext=mmyEditText.getText().toString();	    
        	   mmyTextView.setText(ttext);   
        	// 關閉軟鍵盤 方法1
        	   mmyEditText.setInputType(InputType.TYPE_NULL); 
        	// 關閉軟鍵盤 方法2	   
        	   InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        	   imm.hideSoftInputFromWindow(mmyEditText.getWindowToken(), 0);
        	   
            }
            return false;
           }
        });*/
               
    }
  
}