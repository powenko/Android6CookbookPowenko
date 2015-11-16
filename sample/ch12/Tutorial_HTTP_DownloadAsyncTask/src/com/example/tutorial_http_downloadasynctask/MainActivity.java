package com.example.tutorial_http_downloadasynctask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	 public static final int progress_bar_type = 0;
	 private ProgressDialog mProgressDialog;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button startBtn = (Button)findViewById(R.id.button1 );
        startBtn.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                startDownload();
            }
        });
        
	}
	private void startDownload() {
	        String url = "http://www.powenko.com/download/1.jpg";
	        new DownloadFileAsync().execute(url);
	}
	
	
	//////
	
	 @Override
	    protected Dialog onCreateDialog(int id) {
	        switch (id) {
	            case progress_bar_type:
	                mProgressDialog = new ProgressDialog(this);
	                mProgressDialog.setMessage("Downloading file..");
	                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	                mProgressDialog.setCancelable(false);
	                mProgressDialog.show();
	                return mProgressDialog;
	            default:
	                return null;
	        }
	    }

class DownloadFileAsync extends AsyncTask<String, String, String> {
      
    private String tfile;
	@SuppressWarnings("deprecation")
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        showDialog(progress_bar_type);
    }

    @Override
    protected String doInBackground(String... aurl) {
        int count;

        try {
            URL url = new URL(aurl[0]);
            URLConnection conexion = url.openConnection();
            conexion.connect();

            tfile=Environment.getExternalStorageDirectory().getPath()+"/1.png";
            Log.d("ASYNC",tfile);
            int lenghtOfFile = conexion.getContentLength();
           
            InputStream input = new BufferedInputStream(url.openStream());
            OutputStream output = new FileOutputStream(tfile);
            

            byte data[] = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {}
        return null;

    }
    protected void onProgressUpdate(String... progress) {
         Log.d("ASYNC",progress[0]);
         mProgressDialog.setProgress(Integer.parseInt(progress[0]));
         
         
      
    }

    @SuppressWarnings("deprecation")
	@Override
    protected void onPostExecute(String unused) {
        dismissDialog(progress_bar_type);
        File image = new  File(tfile); 
        if(image.exists()){
                 ImageView imageView1= (ImageView) findViewById(R.id.imageView1 );
                 imageView1.setImageBitmap(BitmapFactory.decodeFile(image.getAbsolutePath()));
        }
        
    }
}
}
