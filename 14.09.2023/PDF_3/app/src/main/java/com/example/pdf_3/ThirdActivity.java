package com.example.pdf_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class ThirdActivity extends AppCompatActivity {

        private Button tStart, tStop;
        private TextView tSzerokosc, tDlugosc;

        public LocationManager locationManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third);

            tStart = findViewById(R.id.Start);
            tStop = findViewById(R.id.Stop);
            tStop.setEnabled(false);

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            LocationListener listener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    String szerok = String.valueOf(location.getLatitude());
                    String dlugo = String.valueOf(location.getLatitude());

                    tSzerokosc = (TextView) findViewById(R.id.szerokosc);
                    tSzerokosc.setText(szerok);

                    tDlugosc = (TextView) findViewById(R.id.dlugosc);
                    tDlugosc.setText(dlugo);
                }
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }
                @Override
                public void onProviderEnabled(String provider) {

                }
                @Override
                public void onProviderDisabled(String provider) {

                }
            };


            tStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View x) {

                tStart.setEnabled(false);
                tStop.setEnabled(true);

                if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                }
            });

            tStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View x) {


                tStop.setEnabled(false);
                tStart.setEnabled(true);

                locationManager.removeUpdates(listener);
                }
            });
        }



        }
