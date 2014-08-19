package com.example.adduser;

import android.app.Activity;
import android.os.Bundle;

public class AddUser extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_user);
        
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        String password = extras.getString("password");
        String name = extras.getString("name");

        send(username, password, name);
        
    }
	
	private void send(String username, String password, String name){
		
		MyThread t = new MyThread(this.getApplicationContext(), username, password, name);
	    t.start();
	}
	
}
