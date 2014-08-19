package com.example.adduser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;

public class MyThread extends Thread{
	Context context;
	String username, password, name;
	
	public MyThread(Context context, String username, String password, String name){
		this.context = context;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	@Override
	public void run(){
		AndroidHttpClient httpClient = AndroidHttpClient.newInstance("Android");
		//insert php page into parameter
    	HttpPost httpPost = new HttpPost("http://10.0.0.14/insert/index.php");
    	
    	List<NameValuePair> params = new ArrayList<NameValuePair>(2);
    	params.add(new BasicNameValuePair("username", this.username));
    	params.add(new BasicNameValuePair("password", this.password));
    	params.add(new BasicNameValuePair("name", this.name));
    	
    	try{
    		httpPost.setEntity(new UrlEncodedFormEntity(params));
    	}catch(UnsupportedEncodingException e){
    		e.printStackTrace();
    	}
    	
    	try{
    		HttpResponse response = httpClient.execute(httpPost);
    		Log.d("Response", response.toString());
    		Log.d("Whatver", "OKAY");
    	}catch(ClientProtocolException e){
    		e.printStackTrace();
    	}catch(IOException e){
    		e.printStackTrace();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
}
