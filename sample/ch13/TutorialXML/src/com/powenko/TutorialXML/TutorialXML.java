package com.powenko.TutorialXML;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class TutorialXML extends Activity {
	private ListView listView;
	private List<News> data;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       
        getRss("http://www.powenko.com/en/?feed=rss2");
       
        
        
        String[] converted = convert(data);
        ListAdapter adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, converted);

        
        listView = (ListView) findViewById(R.id.lv_country); 
        listView.setAdapter(adapter);
    }
    
    
    static String[] convert(List<News> from) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0;i<from.size();i++) {
        	list.add(from.get(i)._title);
        }
        return list.toArray(new String[list.size()]);
    }
    
    
    public String HTTP_getHTTPResultWithTimeOut(String i_url,int timeoutConnection,int timeoutSocket)
    {

    	
    	String strResult="";
    	try{
    		HttpGet httpGet = new HttpGet(i_url);
    	    	HttpParams httpParameters = new BasicHttpParams();
    	HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
    	HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

    	DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
    	HttpResponse httpResponse = httpClient.execute(httpGet);
       // HttpResponse response = client.execute(request);   
    	if(httpResponse.getStatusLine().getStatusCode() == 200)  
	    { 
	         strResult = EntityUtils.toString(httpResponse.getEntity()); 
	    }
        } catch (Exception e) {   
      
        }
    	return strResult;
    }
    
    private void getRss(String path)
    {
      data=new ArrayList<News>();
      URL url = null;     
      try
      {  
        url = new URL(path);
        SAXParserFactory spf = SAXParserFactory.newInstance(); 
        SAXParser sp = spf.newSAXParser(); 
        XMLReader xr = sp.getXMLReader(); 
        MyHandler myExampleHandler = new MyHandler(); 
        xr.setContentHandler(myExampleHandler);    
        xr.parse(new InputSource(url.openStream()));
        data =myExampleHandler.getParsedData(); 
      }
      catch (Exception e)
      { 
        Intent intent=new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("error",""+e);
        intent.putExtras(bundle);
        
      }
      return;
    }
    
}