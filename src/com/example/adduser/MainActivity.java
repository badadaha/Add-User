package com.example.adduser;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	EditText username, password, name;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.username = (EditText)findViewById(R.id.etUsername);
        this.password = (EditText)findViewById(R.id.etPassword);
        this.name = (EditText)findViewById(R.id.etName);
        Button save = (Button)findViewById(R.id.btnSave);
        
        save.setOnClickListener(saveData);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    private OnClickListener saveData = new OnClickListener(){
    	public void onClick(View view)
        {  
    		boolean check = checkData();
    		Intent myIntent = new Intent(getBaseContext(), AddUser.class);
    		if(check != true){
    			String str = "Some Fields Are Empty!";
    			Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    		}else{
    			myIntent.putExtra("username", username.getText().toString());
    			myIntent.putExtra("password", password.getText().toString());
    			myIntent.putExtra("name", name.getText().toString());
    			startActivity(myIntent);
    		}
        }
    };
    
    private boolean checkData(){
    	boolean check = true;
    	String[] str = new String[3];
    	str[0] = this.username.getText().toString();
    	str[1] = this.password.getText().toString();
    	str[2] = this.name.getText().toString();
    	
		for(int i = 0; i < 3; i++){
			check = (str[i].equals("")) ? false : true;
		}
		
		return check;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
