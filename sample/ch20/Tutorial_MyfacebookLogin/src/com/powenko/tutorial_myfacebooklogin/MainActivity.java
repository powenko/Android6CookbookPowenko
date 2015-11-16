package com.powenko.tutorial_myfacebooklogin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends Activity {

	TextView textView1;
	CallbackManager callbackManager;
	private AccessToken accessToken;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
		setContentView(R.layout.activity_main);
	    textView1 = (TextView) findViewById(R.id.textView1 );
	    callbackManager = CallbackManager.Factory.create();
	    LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
	    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
	        @Override
	        public void onSuccess(LoginResult loginResult) {
	            accessToken = loginResult.getAccessToken();
	            Log.d("FB","access token got.");
	            GraphRequest request = GraphRequest.newMeRequest(
	            accessToken,
	            new GraphRequest.GraphJSONObjectCallback() {
                     @Override
                     public void onCompleted(JSONObject object, GraphResponse response) {
	                    Log.d("FB","complete");
	                    Log.d("FB",object.optString("name"));
	                    Log.d("FB",object.optString("link"));
	                    Log.d("FB",object.optString("id"));
	                    textView1.setText("FB:"+
	    	           	            "name:"+object.optString("name")+
	    	           	            "\n link is:"+object.optString("link")+
	    	           	            "\n id:"+object.optString("id") );
	    	           ProfilePictureView   profilePictureView =
	    	        		   (ProfilePictureView) findViewById(R.id.profilePicture);
	    	           profilePictureView.setDrawingCacheEnabled(true);
	    	           profilePictureView.setProfileId(object.optString("id"));
	                }
	             });
	           Bundle parameters = new Bundle();
	           parameters.putString("fields", "id,name,link");
	           request.setParameters(parameters);
	           request.executeAsync();
	        }
	        @Override
	        public void onCancel() {
	           Log.d("FB","CANCEL");
 	           textView1.setText("FB: CANCEL" );
	        }
	        //登入失敗
	        @Override
	        public void onError(FacebookException exception) {
	           Log.d("FB",exception.toString());
	           textView1.setText("FB: Error"+ exception.toString());
	        }
	    });	    
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    callbackManager.onActivityResult(requestCode, resultCode, data);
	}
}
