package com.TutorialFileReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;



public class TutorialFileReadWrite extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context context=getApplicationContext();
        write( context,"test.txt", "How are you");
        
        write_sd("/powenko" ,"sd.txt", "How are you? Powen Ko!");
        
        String t1=read(context, "test.txt");
        String t2=read_sd( context, "/powenko" ,"sd.txt");
        
        TextView mTextView01=(TextView) findViewById(R.id.TextView01);
        mTextView01.setText(t2);
            
    }
    
    
    public static String read(Context context, String file) { 
    	String data = ""; 
    	try { 
	    	FileInputStream stream = context.openFileInput(file); 
	    	StringBuffer sb = new StringBuffer(); 
	    	int c; 
	    	while ((c = stream.read()) != -1) { 
	    	sb.append((char) c); 
	    	} 
	    	stream.close(); 
	    	data = sb.toString(); 
    	 
    	} catch (FileNotFoundException e) { 
    	} catch (IOException e) { 
    	} 
    	return data; 
    	} 
    

    public static String  read_sd(Context context, String i_filePath,String i_FileName){
    	
    	String data = ""; 
        // try to write the content
        try {
        	
        	File sdCard = Environment.getExternalStorageDirectory();
        	File dir = new File (sdCard.getAbsolutePath() + i_filePath);
        //	dir.mkdirs();
        	File file = new File(dir,i_FileName);
        	//String fileString=file.getAbsolutePath();
        //	FileOutputStream out = new FileOutputStream(file);
        	
          // write the contents on mySettings to the file
          //out.write(msg.getBytes());
          ///////
          
            FileInputStream stream =new FileInputStream(file); // context.openFileInput(fileString); 
	    	StringBuffer sb = new StringBuffer(); 
	    	int c; 
	    	while ((c = stream.read()) != -1) { 
	    	sb.append((char) c); 
	    	} 
	    	stream.close(); 
	    	data = sb.toString(); 
	    	
	    	
          // close the file
	    	stream.close();
        } catch (java.io.IOException e) {
          //do something if an IOException occurs.
        }
        return  data ; 
    }
    protected void write_sd(String i_filePath,String i_FileName,String msg){
    	
        
        // try to write the content
        try {
        	
        	File sdCard = Environment.getExternalStorageDirectory();
        	File dir = new File (sdCard.getAbsolutePath() + i_filePath);
        	dir.mkdirs();
        	File file = new File(dir,i_FileName);
        	FileOutputStream out = new FileOutputStream(file);
        	
          // write the contents on mySettings to the file
          out.write(msg.getBytes());
          // close the file
          out.close();
        } catch (java.io.IOException e) {
          //do something if an IOException occurs.
        }
    }
    
    public static void write(Context context, String file, String msg) {
    	try {
    		
	    	FileOutputStream stream = context.openFileOutput(file,
	    	Context.MODE_WORLD_WRITEABLE);
	    	stream.write(msg.getBytes());
	    	stream.flush();
	    	stream.close();
	    	
    	} catch (FileNotFoundException e) {
    	} catch (IOException e) {
    	}
    	}

 
    
    
    
}