package com.example.testtorche;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;
import android.os.Build;

public class MainActivity extends Activity {

	private static Camera camera;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void lightClicked(View view){
		boolean on = ((ToggleButton) view).isChecked();
		
		if (on){
			camera = Camera.open();
			Camera.Parameters params = camera.getParameters();
			params.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(params);
		} else {
			Camera.Parameters params = camera.getParameters();
			params.setFlashMode(Parameters.FLASH_MODE_OFF);
			camera.release();
		}
	}
	
	public void lightUp(View view){
		camera = Camera.open();
		Camera.Parameters params = camera.getParameters();
		params.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(params);
	}
	
	public void quit(View view){
		Camera.Parameters params = camera.getParameters();
		params.setFlashMode(Parameters.FLASH_MODE_OFF);
		camera.release();	
		this.finish();
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
