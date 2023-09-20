package com.example.zadanie1pdf14092023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrzycisk = (Button)findViewById(R.id.button);

        btnPrzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wyswietl = "Bartosz Lauer";
                Toast.makeText(MainActivity.this, wyswietl, Toast.LENGTH_LONG).show();

            }
        });
    }
}