package com.example.fontt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

 

public class Main extends ActionBarActivity {

	int r,g,b;
	Intent i;
	String hh;
    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.firstpage);
	      
	        i = new Intent(this,Editor.class);
	        Button b=(Button)findViewById(R.id.startB);
	        b.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
			        startActivity(i);
				}
			});
	        
	        
	        
//	        final Intent ii = new Intent(this,Tavajoh.class);
//	        
//	        Button bb=(Button)findViewById(R.id.tavajoh);
//	        
//	        bb.setOnClickListener(new OnClickListener() {
//				public void onClick(View arg0) {
//			        startActivity(ii);
//				}
//			});
	        
	        
	        final Intent iii = new Intent(this,About_us.class);
	        
	        Button bbb=(Button)findViewById(R.id.about_button);
	        
	        bbb.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
			        startActivity(iii);
				}
			});
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
}
