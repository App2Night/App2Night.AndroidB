package com.julianriegraf.app2night.GPS;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import com.julianriegraf.app2night.ContactFragment;
import com.julianriegraf.app2night.LocationFragment;

/**
 * Created by Julian Riegraf on 27.10.2016.
 */

public class GPSAccess extends Service implements LocationListener {

    private boolean GPSaktiv = false;
    Location position;
    protected LocationManager locationManager;
    Fragment fragment;

    private final Context c;

    public GPSAccess(Context context, Fragment cf) {
        this.c = context;
        this.fragment = cf;
        setPosition();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        position = location;
        LocationFragment locFrag = (LocationFragment) fragment;
        locFrag.updateMapView();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        setPosition();
    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void stopGPSposition() {
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.removeUpdates(this);
            }

        }
    }

    public double getLatitude() {
        if (position != null) {
            return position.getLatitude();
        } else {
            return -1;
        }
    }

    public double getLongitude() {
        if (position != null) {
            return position.getLongitude();
        } else {
            return -1;
        }
    }

    public boolean istGPSaktiv() {
        return this.GPSaktiv;
    }

    public void setPosition() {
        try {
            locationManager = (LocationManager) c.getSystemService(LOCATION_SERVICE);
            GPSaktiv = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (ActivityCompat.checkSelfPermission(fragment.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(fragment.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
            if (locationManager != null) {
                position = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
