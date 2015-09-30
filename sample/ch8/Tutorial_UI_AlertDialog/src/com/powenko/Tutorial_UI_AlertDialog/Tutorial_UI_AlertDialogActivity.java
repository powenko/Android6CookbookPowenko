package com.powenko.Tutorial_UI_AlertDialog;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tutorial_UI_AlertDialogActivity extends Activity {
    /** Called when the activity is first created. */
	final Context context = this;
	private Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button) findViewById(R.id.button1);
    		button.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
    			dialog_normal();
    			}
    		});  
    	///
    		Button	button2 = (Button) findViewById(R.id.button2);
    		button2.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
        		dialog_Message_title();

    			}
    		});    
    	///
    		Button	button3 = (Button) findViewById(R.id.button3);
    		button3.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
        		dialog_pick();

    			}
    		});	 
    	///
    		Button	button4 = (Button) findViewById(R.id.button4);
    		button4.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
    			dialog_multiple_choice();

    			}
    		});		
    	///
    		Button	button5 = (Button) findViewById(R.id.button5);
    		button5.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
    			dialog_Custom();

    			}
    		});		
    
    		
    		
    		
    }

    public void dialog_normal(){
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
 
			// set title
			alertDialogBuilder.setTitle("www.powenko.com");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Close this APP.")
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
    }
    

    public void dialog_Message_title(){
    	AlertDialog.Builder builder = new AlertDialog.Builder(context);
    	builder.setMessage("message in here")
    	       .setTitle("my dialog");
    	AlertDialog dialog = builder.create();

    	dialog.show();
    }

    public void dialog_pick(){
    	String[] t_data={"red","pink","black"};
    	 AlertDialog.Builder builder = new AlertDialog.Builder(context);
    	    builder.setTitle("please pick one")
    	           .setItems(t_data, new DialogInterface.OnClickListener() {
    	               public void onClick(DialogInterface dialog, int which) {
                              // 按下選項的反應，用戶選的事項可以在which 變數中取得。
    	           }
    	    });
 
    	       	AlertDialog dialog = builder.create();
    	        builder.show();
    }
    public void dialog_multiple_choice(){
    	String[] t_data={"red","pink","black"};
    	final ArrayList mSelectedItems = new ArrayList();  
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("please pick one")
               .setMultiChoiceItems(t_data, null,
                          new DialogInterface.OnMultiChoiceClickListener() {
                   public void onClick(DialogInterface dialog, int which,
                           boolean isChecked) {
                       if (isChecked) {
                           mSelectedItems.add(which);
                       } else if (mSelectedItems.contains(which)) {
                           mSelectedItems.remove(Integer.valueOf(which));
                       }
                   }
               })
               .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       
                   }
               })
               .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                 
                   public void onClick(DialogInterface dialog, int id) {
                     
                   }
               });

    	        // 3. Get the AlertDialog from create()
    	       	AlertDialog dialog = builder.create();
    	       	
    	           builder.show();
    }

    public void dialog_Custom(){
    	 AlertDialog.Builder builder = new AlertDialog.Builder(context);
    		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    			 

    	    builder.setView(inflater.inflate(R.layout.dialog_custom , null))
    	           .setPositiveButton("ok", new DialogInterface.OnClickListener() {
    	               public void onClick(DialogInterface dialog, int id) {

    	               }
    	           })
    	           .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
    	               public void onClick(DialogInterface dialog, int id) {
    	            	   dialog.cancel();
    	               }
    	           });      
    	 
    	       	AlertDialog dialog = builder.create();
    	       	builder.show();
    }
    
    
}