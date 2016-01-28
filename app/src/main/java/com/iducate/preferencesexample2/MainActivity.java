package com.iducate.preferencesexample2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	//This will be called when other activities in our application
	//are finished.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==1) //exited our preference screen
		{
			Toast toast = 
			Toast.makeText(getApplicationContext(), "back from preferences", Toast.LENGTH_LONG);
			toast.setText("back from our preferences");
			toast.show();
			//here you could put code to do something.......
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void setPreferences(View v) {
		//Here we create a new activity and we instruct the 
		//Android system to start it
		Intent intent = new Intent(this, SettingsActivity.class);
		//startActivity(intent); //this we can use if we DONT CARE ABOUT RESULT
		
		//we can use this, if we need to know when the user exists our preference screens
		startActivityForResult(intent, 1); 
	}

	public void getPreferences(View v) {
		
		//We read the shared preferences from the 
		SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
		String email = prefs.getString("email", "");
		String gender = prefs.getString("gender", "");
		boolean soundEnabled = prefs.getBoolean("sound", false);

		Toast.makeText(
				this,
				"Email: " + email + "\nGender: " + gender + "\nSound Enabled: "
						+ soundEnabled, Toast.LENGTH_SHORT).show();
	}
}
