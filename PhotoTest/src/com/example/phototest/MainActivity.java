package com.example.phototest;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        LocationListener mlocListener = new MyLocationLister();
        
        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void openCamera(View view){
    	startActivity(intent);
    }
    public class MyLocationLister implements LocationListener {

    	@Override
    	public void onLocationChanged(Location arg0) {
    		arg0.getLatitude();
    		arg0.getLongitude();
    		String Text = "My current location is: " +
    		"Latitud = " + arg0.getLatitude() +
    		"Longitud = " + arg0.getLongitude();
    		Toast.makeText( getApplicationContext(),
    		Text, Toast.LENGTH_SHORT).show();
    	}

    	@Override
    	public void onProviderDisabled(String provider) {
    		// TODO Auto-generated method stub
    		Toast.makeText( getApplicationContext(),
    				"Gps Disabled", Toast.LENGTH_SHORT ).show();
    	}

    	@Override
    	public void onProviderEnabled(String provider) {
    		// TODO Auto-generated method stub
    		Toast.makeText( getApplicationContext(),
    				"Gps Enabled", Toast.LENGTH_SHORT).show();
    	}

    	@Override
    	public void onStatusChanged(String provider, int status, Bundle extras) {
    		// TODO Auto-generated method stub

    	}

    }

    
}
