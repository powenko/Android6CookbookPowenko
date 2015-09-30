package com.powenko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2layout);              //顯示畫面資料
        Bundle bundle= this.getIntent().getExtras();       // 取得第一頁傳遞過來的資料。
        int t_value=bundle.getInt("intvlaue");             
        String t_web=bundle.getString("Web");
        
        TextView t_textView_title = (TextView)findViewById(R.id.textView1);     //將第一頁的資料顯示在畫面上
        t_textView_title.setText(t_web+ t_value);
               
        Button b1 = (Button) findViewById(R.id.button1);     //按鈕處理
        b1.setOnClickListener(new Button.OnClickListener()
        {
          public void onClick(View v)
          {
        	  FunBack();                                      // 呼叫自己寫的函數
          }
        });
    }
    
    public void FunBack(){ 
      Intent intent = page2.this.getIntent();                //準備將資料傳遞回去
      Bundle bundle= intent.getExtras();

   	  bundle.putString("page2Result", "this info is from page2"); 
   	  intent.putExtras(bundle);
         
   	  page2.this.setResult(RESULT_OK, intent);              // 傳遞資料回上一頁
   	  page2.this.finish();                                  // 關閉第二頁
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {    //用戶按下android 機器上的back 按鍵。
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	FunBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    
}