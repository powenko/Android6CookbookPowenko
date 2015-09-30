 // 柯博文老師 www.powenko.com
package com.powenko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tutorial_Activity_Activity_backPageActivity extends Activity {
	 int requestCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
          public void onClick(View v)
          {
           
            Intent intent = new Intent();
        	  intent.setClass(Tutorial_Activity_Activity_backPageActivity.this, page2.class);
        	  
        	  Bundle bundle=new Bundle();
        	  bundle.putInt("intvlaue", 1);
        	  bundle.putString("Web", "www.powenko.com");        	
        	  intent.putExtras(bundle);
       
        	  startActivityForResult(intent,0);
        //	  Tutorial_Activity_Activity_backPageActivity.this.finish();
          }
        });
    }
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("CheckStartActivity","onActivityResult and resultCode = "+resultCode);
        
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Toast.makeText(this, "Pass", Toast.LENGTH_LONG).show();
            Bundle bundle2=data.getExtras();
            String t_page2Result=bundle2.getString("page2Result");

            TextView t_textView_title = (TextView)findViewById(R.id.textView1);
            t_textView_title.setText(t_page2Result);
            
        }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }
    
}