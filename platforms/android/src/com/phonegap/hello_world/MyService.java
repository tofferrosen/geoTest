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

import edu.rit.se.se561.trafficanalysis.api.ApiClient;
import edu.rit.se.se561.trafficanalysis.api.DcsException;
import edu.rit.se.se561.trafficanalysis.api.Messages;
import edu.rit.se.se561.trafficanalysis.api.Messages.RegisterRiderResponse;
import edu.rit.se.se561.trafficanalysis.tracking.*;
import edu.rit.se.se561.trafficanalysis.util.GCMHelper;

public class MyService extends BackgroundService {
	
	private final static String TAG = MyService.class.getSimpleName();
	
	private String mHelloTo = "World";
//	private Location loc = null;
	//Testing
	private Messages.LocationUpdate loc = null;
	
	private boolean locationInit = false;
	private LocationListener locationListener = null;
	private TrackingService trackingService = null;
	private LocationReceiver test = null;
	private StateBroadcaster stateCaster= null;
	
	// Acquire a reference to the system Location Manager
	LocationManager locationManager;
	
	protected void locationUpdates(){
		String lolwut = null;
	}


	protected void initLoc() {

		Log.d(TAG,"init loc: HelloWorld calling CycleOps");
		/*final Handler h = new Handler();
		h.post(new Runnable() {
			public void run() {
				locationUpdates();
				h.postDelayed(this, TIME)
			}
		}); */
		
		// Register the listener with the Location Manager to receive location updates
//		locationManager =  (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
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
		
//		locationListener = new TrackingService();
		trackingService = new TrackingService();
		stateCaster = new StateBroadcaster(getApplicationContext());
		test = new LocationReceiver();
		
		ApiClient apc = new ApiClient(getApplicationContext());
		try {
			RegisterRiderResponse rr = apc.register();
			Log.d(getPackageName(), rr.toString());
		} catch (DcsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GCMHelper.registerPush(getApplicationContext());
		TrackingService.startTracking(getApplicationContext());
		
		locationInit = true;
		
		
	}
	@Override
	protected synchronized JSONObject doWork() {
		JSONObject result = new JSONObject();
		LocationDBOpenHelper dbhelper = new LocationDBOpenHelper(getApplicationContext()); //Testing
		
		if(!locationInit){
			initLoc();
		}
		
		try {
			//Testing
			if(dbhelper.getLocations(1).size()>0) {
				loc = dbhelper.getLocations(1).get(0);
			}
			
			//SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			//String now = df.format(new Date(System.currentTimeMillis())); 
			
			String msg;
			if(loc != null){
//				msg = "Lat " + loc.getLatitude() + " Long " +loc.getLongitude();
				msg = "Lat " + loc.latitude + " Long " +loc.longitude; //Testing
			} else {
				msg = "LOCATION IS NULL, LOL";
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
