package com.example.bdtrunsport;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class GoogleMaps extends AppCompatActivity {
    //initialize variable
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;

    //search_widgets
    //private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        //asign_variable
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);
        //initialize fused location
        client = LocationServices.getFusedLocationProviderClient(this);
        //check permission
        if(ActivityCompat.checkSelfPermission(GoogleMaps.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //when permission granted
            //call method
            getCurrentLocation();
        }else {
            //when permission denied
            //request permission
            ActivityCompat.requestPermissions(GoogleMaps.this,
                    new  String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }

        //search_location
//        searchText = (EditText) findViewById(R.id.search_input);
//        init();
    }
//    private void  init(){
//        Log.d(TAG, "getting device live location ");
//        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH
//                || actionId == EditorInfo.IME_ACTION_DONE
//                || keyEvent.getAction() == keyEvent.ACTION_DOWN
//                        || keyEvent.getAction() == keyEvent.KEYCODE_ENTER){
//                    //execute our method for searching
//                    geoLocate();
//                }
//                return false;
//            }
//        });
//    }

//    private void geoLocate() {
//        Log.d(TAG,"geolocating");
//        String searchString = searchText.getText().toString();
//
//        Geocoder geocoder = new Geocoder(GoogleMaps.this);
//        List<Address>list = new ArrayList<>();
//        try {
//            list = geocoder.getFromLocationName(searchString, 1);
//        }catch (IOException e){
//            Log.e(TAG,"IOException: "+e.getMessage());
//        }
//        if (list.size() > 0){
//            Address address = list.get(0);
//            Log.d(TAG,"found a location: "+address.toString());
//            //Toast.makeText(this, address.toString(), Toast.LENGTH_SHORT).show();
//        }
//
//    }

    private void getCurrentLocation() {
        //Initialize task location
        @SuppressLint("MissingPermission") Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                //when success
                if (location != null){
                    //sync map
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng latLng = new LatLng(location.getLatitude()
                            ,location.getLongitude());
                            //create marked options
                            MarkerOptions options = new MarkerOptions().position(latLng)
                                    .title("I am there");
                            //Zoom map
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                            //add marker
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //when permisssion granted
                //call method
                getCurrentLocation();
            }
        }
    }
}