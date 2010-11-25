package com.bopbi.ui;

import java.util.ArrayList;

import com.bopbi.R;
import com.bopbi.model.LocationAdapter;
import com.bopbi.model.LocationList;
import com.bopbi.model.LocationModel;
import com.bopbi.util.RestClient;
import com.bopbi.util.RestClient.RequestMethod;
import com.google.android.maps.GeoPoint;
import com.google.gson.Gson;

import android.app.Activity;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ListRest extends Activity {
	LocationManager lm;
	GeoPoint userLocation;
	
	//static String[] TITLE;
	//static String[] DESCRIPTION;
	
	ArrayList<LocationModel> locationArray = null;
	LocationAdapter locationAdapter;
	LocationList list;
	
	ListView lv;
	TextView loadingText;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        lv = (ListView) findViewById(R.id.list_nearme);
		
        locationArray = new ArrayList<LocationModel>();
        locationAdapter = new LocationAdapter(ListRest.this, R.layout.item, locationArray);
        
        
        lv.setTextFilterEnabled(true);
		lv.setAdapter(locationAdapter);
		
		try {
			new LocationSync().execute("http://vivid-snow-43.heroku.com/nearme.json");
		} catch(Exception e) {}
    }
	
	private class LocationSync extends AsyncTask<String, Integer, LocationList> {

		protected LocationList doInBackground(String... urls) {
			LocationList list = null;
			int count = urls.length;
	        
	        for (int i = 0; i < count; i++) {
	        	try {			
	    			// ntar diganti service
	    			RestClient client = new RestClient(urls[i]);

	    			try {
	    			    client.Execute(RequestMethod.GET);
	    			} catch (Exception e) {
	    			    e.printStackTrace();
	    			}

	    			String json = client.getResponse();
	 
	    			list = new Gson().fromJson(json, LocationList.class);
	    			
	    			//
	    		} catch(Exception e) {}
	        }
	        return list;
		}
		
		protected void onProgressUpdate(Integer... progress) {
	        
	    }

	    protected void onPostExecute(LocationList loclist) {
	    	
	    	for(LocationModel lm : loclist.getLocations())
	        {
				locationArray.add(lm);
	        }
	        locationAdapter.notifyDataSetChanged();
	    }

	}
}