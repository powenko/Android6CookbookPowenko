package com.example.TutorialGPS;



import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;



public class TutorialGPS extends MapActivity
{
	  private TextView myTextView01;
	  private MapView myMapView01;
	  private GeoPoint currentGeoPoint;	
	  private LocationManager myLocationManager01;
	  private String strLocationPrivider = "";
	  private Location mLocation01=null;
	  private int intZoomLevel = 12;
  @Override
  protected void onCreate(Bundle icicle)
  {
    super.onCreate(icicle);
    setContentView(R.layout.main);
    
    myTextView01 = (TextView)findViewById(R.id.TextView01);
    myMapView01 = (MapView)findViewById(R.id.mapview);
    myLocationManager01 = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    mLocation01 = getLocationPrivider(myLocationManager01);
    if(mLocation01!=null)
    {
      processLocationUpdated(mLocation01);
    }
    else
    {
      myTextView01.setText
      (
        getResources().getText(R.string.str_err_location).toString()
      );
    }  
    myLocationManager01.requestLocationUpdates(strLocationPrivider, 100000, 10, mLocationListener01);
  }
  
  public final LocationListener mLocationListener01 = new LocationListener()
  {
    @Override
    public void onLocationChanged(Location location)
    {    
      processLocationUpdated(location);
    }
    
    @Override
    public void onProviderDisabled(String provider)
    {
    }
    
    @Override
    public void onProviderEnabled(String provider)
    {
    }
    
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
    }
  };
  
  public String getAddressbyGeoPoint(GeoPoint gp)
  {
    String strReturn = "";
    try
    {
      if (gp != null)
      {
        Geocoder gc = new Geocoder(TutorialGPS.this, Locale.getDefault());
        
        double geoLatitude = (int)gp.getLatitudeE6()/1E6;
        double geoLongitude = (int)gp.getLongitudeE6()/1E6;
        
        List<Address> lstAddress = gc.getFromLocation(geoLatitude, geoLongitude, 1);
        StringBuilder sb = new StringBuilder();
        
        if (lstAddress.size() > 0)
        {
          Address adsLocation = lstAddress.get(0);

          for (int i = 0; i < adsLocation.getMaxAddressLineIndex(); i++)
          {
            sb.append(adsLocation.getAddressLine(i)).append("\n");
          }
          sb.append(adsLocation.getLocality()).append("\n");
          sb.append(adsLocation.getPostalCode()).append("\n");
          sb.append(adsLocation.getCountryName());
        }
              
        strReturn = sb.toString();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return strReturn;
  }
  
  public Location getLocationPrivider(LocationManager lm)
  {
    Location retLocation = null;
    try
    {
      Criteria mCriteria01 = new Criteria();
      mCriteria01.setAccuracy(Criteria.ACCURACY_FINE);
      mCriteria01.setAltitudeRequired(false);
      mCriteria01.setBearingRequired(false);
      mCriteria01.setCostAllowed(true);
      mCriteria01.setPowerRequirement(Criteria.POWER_LOW);
      strLocationPrivider = lm.getBestProvider(mCriteria01, true);
      retLocation = lm.getLastKnownLocation(strLocationPrivider);
    }
    catch(Exception e)
    {
      myTextView01.setText(e.toString());
      e.printStackTrace();
    }
    return retLocation;
  }
  
  private GeoPoint getGeoByLocation(Location location)
  {
    GeoPoint gp = null;
    try
    {
      if (location != null)
      {
        double geoLatitude = location.getLatitude()*1E6;
        double geoLongitude = location.getLongitude()*1E6;
        gp = new GeoPoint((int) geoLatitude, (int) geoLongitude);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return gp;
  }
  
  public static void refreshMapViewByGeoPoint(GeoPoint gp, MapView mv, int zoomLevel, boolean bIfSatellite)
  {
    try
    {
      mv.displayZoomControls(true);   
      MapController tMapController = mv.getController();
      tMapController.animateTo(gp);      
      tMapController.setZoom(zoomLevel);
    
      /*
      if(bIfSatellite)
      {
        mv.setSatellite(true);
        mv.setStreetView(true);
      }
      else
      {
        mv.setSatellite(false);
      }*/
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  

  private void processLocationUpdated(Location location)
  {

    currentGeoPoint = getGeoByLocation(location);
    
    refreshMapViewByGeoPoint(currentGeoPoint, myMapView01, intZoomLevel, true);
    
    myTextView01.setText
    (
      "你在\n long:"+      
      String.valueOf((int)currentGeoPoint.getLongitudeE6()/1E6)+"\n lat:"+
      String.valueOf((int)currentGeoPoint.getLatitudeE6()/1E6)+"\n"+
      
      getAddressbyGeoPoint(currentGeoPoint)
    );
  }
  
  @Override
  protected boolean isRouteDisplayed()
  {
    return false;
  }
}