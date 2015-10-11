package com.theTeaCakeProject.app;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.location.LocationManager.GPS_PROVIDER;

public class Maps extends FragmentActivity implements CompoundButton.OnCheckedChangeListener {

    private final LatLng LOCATION_DROMROE = new LatLng(52.675844, -8.576836);
    private final LatLng LOCATION_PLASSY = new LatLng(52.668478, -8.574113);
    private final LatLng LOCATION_ALDI = new LatLng(52.664418, -8.587066);
    private final LatLng LOCATION_GARRETS = new LatLng(52.667772, -8.575712);
    private final LatLng LOCATION_CSIS = new LatLng (52.673866, -8.575479);
    private final LatLng LOCATION_MAINBUILDING = new LatLng (52.673987, -8.572381);
    private final LatLng LOCATION_FOUNDATION = new LatLng (52.674177, -8.573033);
    private final LatLng LOCATION_SCHUMAN = new LatLng (52.673167, -8.577651);
    private final LatLng LOCATION_KEMMY = new LatLng (52.672877, -8.577163);
    private GoogleMap map;
    private LocationManager locationManager;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        tv = (TextView) findViewById(R.id.currentLocation);

        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ){
            showGPSDisabledAlertToUser();
            Toast.makeText(this,"GPS is disabled!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"GPS is Enabled!", Toast.LENGTH_LONG).show();
            setUpMapIfNeed();
        }


        Switch s = (Switch) findViewById(R.id.changeView);
        if (s != null)
        {
            s.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Satellite view is " + (isChecked ? "on" : "off"),
                Toast.LENGTH_LONG).show();
        if(isChecked){
            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setUpMapIfNeed() {
        if (map == null){
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (map != null){
                setUpMap();
            }
        }
    }

    private void setUpMap() {

        map.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        String provider = GPS_PROVIDER;

        Location myLocation = locationManager.getLastKnownLocation(provider);

        double latitude = myLocation.getLatitude();
        double longitude = myLocation.getLongitude();

        LatLng latLng = new LatLng(latitude,longitude);

        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        map.animateCamera(CameraUpdateFactory.zoomTo(18));


    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onPopupBtClick(View view)
    {

        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        PopupMenu menu = new PopupMenu(this, view);
        menu.getMenuInflater().inflate(R.menu.mymenu, menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch(menuItem.getItemId()){
                     case  R.id.Schuman:
                         selectSchuman();
                         return true;

                    case  R.id.Kemmy:
                         selectKemmy();
                         return true;

                    case  R.id.MainBuilding:{
                         selectMain();
                         return true;}

                    case  R.id.CSIS:
                        selectCSIS();
                        return true;

                    case  R.id.foundation:
                        selectFoundation();
                        return true;

                    case R.id.Aldi:
                        selectAldi();
                        return true;

                    case R.id.Garrets:
                        selectGarrets();
                        return true;

                    case R.id.dromroe:
                        selectDromroe();
                        return true;

                    case R.id.plassy:
                        selectPlassy();
                        return true;
                 }
                        return true;
            }

        });
        menu.show();
        }


    public void selectDromroe(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_DROMROE, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_DROMROE).title("Dromroe Village"));
        MainActivity.text.setText("Dromroe Village");
        tv.setText("Dromroe Village");
    }

    public void selectPlassy(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_PLASSY, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_PLASSY).title("Plassy Village"));
        MainActivity.text.setText("Plassy Village");
        tv.setText("Plassy Village");
    }

    public void selectGarrets(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GARRETS, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_GARRETS).title("Garret Butchers"));
        MainActivity.text.setText("Garret Butchers");
        tv.setText("Garret Buttchers");
    }

    public void selectAldi(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_ALDI, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_ALDI).title("Aldi"));
        MainActivity.text.setText("Aldi");
        tv.setText("Aldi");
    }

    public void selectSchuman(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_SCHUMAN, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_SCHUMAN).title("Schuman building"));
        MainActivity.text.setText("Schuman building");
        tv.setText("Schuman Building");
    }

    public void selectMain(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_MAINBUILDING, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_MAINBUILDING).title("Main building"));
        MainActivity.text.setText("Main Building");
        tv.setText("Main Building");
    }

    public void selectKemmy(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_KEMMY, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_KEMMY).title("Kemmy building"));
        MainActivity.text.setText("Kemmy Building");
        tv.setText("Kemmy Building");
    }

    public void selectCSIS(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_CSIS, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_CSIS).title("CSIS building"));
        MainActivity.text.setText("Computer science building");
        tv.setText("CSIS Building");
    }

    public void selectFoundation(){
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_FOUNDATION, 18);
        map.animateCamera(update);
        map.addMarker(new MarkerOptions().position(LOCATION_FOUNDATION).title("Foundation building"));
        MainActivity.text.setText("Foundation building");
        tv.setText("Foundation Building");
    }

    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable GPS",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        map.setMyLocationEnabled(false);
        Toast toast = Toast.makeText(this,"onPause", Toast.LENGTH_SHORT);
        toast.show();
    }

}

