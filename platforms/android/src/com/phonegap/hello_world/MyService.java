package com.phonegap.hello_world;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.red_folder.phonegap.plugin.backgroundservice.BackgroundService;

import edu.rit.se.se561.trafficanalysis.tracking.*;

public class MyService extends BackgroundService {
	
	private final static String TAG = MyService.class.getSimpleName();
	
	private String mHelloTo = "World";
	private Location loc = null;
	private boolean locationInit = false;
	private LocationListener locationListener = null;
	private TrackingService trackingService = null;
	
	// Acquire a reference to the system Location Manager
	LocationManager locationManager;
	
	protected void locationUpdates(){
		
	}


	protected void initLoc() {

		Log.d(TAG,"init loc: HelloWorld calling CycleOps");
		/*final Handler h = new Handler();
		h.post(new Runnable() {
			public void run() {
				locationUpdates();
				h.postDelayed(this, TIME)
			}
		})l */
		
		// Register the listener with the Location Manager to receive location updates
		locationManager =  (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		/*
		// Define a listener that responds to location updates
		locationListener = new LocationListener() {
		    public void onLocationChanged(Location location) {
		    	loc = location;
		    	Log.d(TAG,"location change");
		    }
		    public void onStatusChanged(String provider, int status, Bundle extras) {
		    	Log.d(TAG,"LOCATION ON STATUS CHANGED");
		    }
		    public void onProviderEnabled(String provider) {
		    	Log.d(TAG,"LOCATION ON PROVIDER ENABLED");
		    }

		    public void onProviderDisabled(String provider) {
		    	Log.d(TAG,"LOCATION ON PROVIDER DISABLED");
		    }
		};
		
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 15000, 400f, locationListener, getMainLooper());
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 45000, 250f, locationListener);
		 */
		
		locationListener = new TrackingService();
		
		TrackingService.startTracking(getApplicationContext());
		
		locationInit = true;
		
		
	}
	@Override
	protected synchronized JSONObject doWork() {
		JSONObject result = new JSONObject();
		
		if(!locationInit){
			initLoc();
		}
		
		try {
			//SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			//String now = df.format(new Date(System.currentTimeMillis())); 
			
			String msg;
			if(loc != null){
				msg = "Lat " + loc.getLatitude() + " Long " +loc.getLongitude();
			} else {
				msg = "LOCATION IS NULL";
			}
		
			result.put("Message", msg);
			
			String mySite = "http://winterfel.student.rit.edu/ian?=" + msg.replace(' ', '-') ;
			Log.d(TAG,mySite);
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(mySite);
			
			
			try {
				HttpResponse response = httpClient.execute(httppost);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		
					

			Log.d(TAG, msg);
		} catch (JSONException e) {
		}
		
		return result;	
	}

	@Override
	protected JSONObject getConfig() {
		JSONObject result = new JSONObject();
		
		try {
			result.put("HelloTo", this.mHelloTo);
		} catch (JSONException e) {
		}
		
		return result;
	}

	@Override
	protected void setConfig(JSONObject config) {
		try {
			if (config.has("HelloTo"))
				this.mHelloTo = config.getString("HelloTo");
		} catch (JSONException e) {
		}
		
	}     

	@Override
	protected JSONObject initialiseLatestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onTimerEnabled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTimerDisabled() {
		// TODO Auto-generated method stub
		
	}


}
