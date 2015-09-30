package com.powenko.mygpsmap;

import java.util.List;
import java.util.Locale;

import android.R;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.maps.GeoPoint;



public class MainActivity extends ActionBarActivity {

	private TextView textView1;
	private String strLocationPrivider = "";
    private GoogleMap googleMap;
    
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView1 = (TextView)findViewById(R.id.textView1);
		LocationManager t_LocationManager1=
				(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Location t_Location1=funGetLocationPrivider(t_LocationManager1);
		if(t_Location1!=null)
		{
			processLocationUpdated(t_Location1);
			t_LocationManager1.requestLocationUpdates(strLocationPrivider, 100000, 10, mLocationListener01);
		      
		}else{
			   textView1.setText("Please open GPS");
		}
		try {
	         initilizeMap();
	    } catch (Exception e) {
	            e.printStackTrace();
	    }
	}
	
	
	private void initilizeMap() {
        if (googleMap == null) {
        	 googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                     R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
    
    

	public Location funGetLocationPrivider(LocationManager lm){
	    Location retLocation = null;
	    try{
	      Criteria mCriteria01 = new Criteria();
	      mCriteria01.setAccuracy(Criteria.ACCURACY_FINE);
	      mCriteria01.setAltitudeRequired(false);
	      mCriteria01.setBearingRequired(false);
	      mCriteria01.setCostAllowed(true);
	      mCriteria01.setPowerRequirement(Criteria.POWER_LOW);
	      strLocationPrivider = lm.getBestProvider(mCriteria01, true);
	      retLocation = lm.getLastKnownLocation(strLocationPrivider);
	    }
	    catch(Exception e){ 	
	    }
	    return retLocation;
	  }
	///////////////////////////
	private void processLocationUpdated(Location t_Location1) {
		    GeoPoint currentGeoPoint = getGeoByLocation(t_Location1);
		    String t_address=getAddressbyGeoPoint(currentGeoPoint);
		    
		    textView1.setText
		    (
		      "long:"+      
		      String.valueOf((int)currentGeoPoint.getLongitudeE6()/1E6)+"\n lat:"+
		      String.valueOf((int)currentGeoPoint.getLatitudeE6()/1E6)+"\n" +
		      t_address
		    );
		    ///////////
		    /*
		    GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		    LatLng t_here = new LatLng(currentGeoPoint.getLatitudeE6()/1E6,currentGeoPoint.getLongitudeE6()/1E6);
	        Marker t_pin = map.addMarker(new MarkerOptions().position(t_here).title("you are here").snippet("數位生活創意系"));
	        map.moveCamera(CameraUpdateFactory.newLatLngZoom(t_here, 8));
	        */
		    ////////
	}
   ///////////////////////////
	private GeoPoint getGeoByLocation(Location location) {
		GeoPoint gp = null;
	    try{
	      if (location != null){
	        double geoLatitude = location.getLatitude()*1E6;
	        double geoLongitude = location.getLongitude()*1E6;
	        gp = new GeoPoint((int) geoLatitude, (int) geoLongitude);
	      }
	    }
	    catch(Exception e){
	    }
	    return gp;
	}
	/////////////////////////
	  public final LocationListener mLocationListener01 = new LocationListener(){
		@Override
		public void onLocationChanged(Location location) {
		    processLocationUpdated(location);
		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
		@Override
		public void onProviderEnabled(String provider) {}
		@Override
		public void onProviderDisabled(String provider) {}
	  };	
	  //////////////////
	  public String getAddressbyGeoPoint(GeoPoint gp) {
		    String strReturn = "";
		    try
		    {
		      if (gp != null)
		      {
		        Geocoder gc = new Geocoder(MainActivity.this, Locale.getDefault());
		        double geoLatitude = (int)gp.getLatitudeE6()/1E6;
		        double geoLongitude = (int)gp.getLongitudeE6()/1E6;
		        
		   List<Address> lstAddress = gc.getFromLocation(geoLatitude, geoLongitude, 1);
		        StringBuilder sb = new StringBuilder();
		        
		        if (lstAddress.size() > 0){
		          Address adsLocation = lstAddress.get(0);

		          for (int i = 0; i < adsLocation.getMaxAddressLineIndex(); i++){
		            sb.append(adsLocation.getAddressLine(i)).append("\n");
		          }
		          sb.append(adsLocation.getLocality()).append("\n");
		          sb.append(adsLocation.getPostalCode()).append("\n");
		          sb.append(adsLocation.getCountryName());
		        }
		        strReturn = sb.toString();
		      }
		    }
		    catch(Exception e){
		      e.printStackTrace();
		    }
		    return strReturn;
		  }
	  
}


