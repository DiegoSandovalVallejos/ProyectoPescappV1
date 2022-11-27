package com.dsv.proyectopescappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity3 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng riolaja = new LatLng(-37.1783519,-72.1199);
        LatLng rioitata = new LatLng(-36.7711146,-72.4576201);
        LatLng rio_serrano = new LatLng(-51.3029661,-73.1984841);
        LatLng rio_rahue = new LatLng(-40.3733956,-73.1607827);
        LatLng rio_lonquimay = new LatLng(-38.5245897,-71.4072919);
        mMap.addMarker(new MarkerOptions()
                .position(riolaja)
                .title("Rio Laja"));
        mMap.addMarker(new MarkerOptions()
                .position(rio_lonquimay)
                .title("Rio Lonquimay"));
        mMap.addMarker(new MarkerOptions()
                .position(rio_rahue)
                .title("Rio Rahue"));
        mMap.addMarker(new MarkerOptions()
                .position(rio_serrano)
                .title("Rio Serrano"));
        mMap.addMarker(new MarkerOptions()
                .position(rioitata)
                .title("Rio Itata"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rioitata));

    }
}