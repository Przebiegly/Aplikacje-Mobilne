package com.example.pdf_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFirstActivity = findViewById(R.id.ImieorazNazwisko);
        buttonFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

//        Button buttonSecondActivity = findViewById(R.id.URL);
//        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View x) {
//                TextInputLayout adresUrl = findViewById(R.id.link);
//                String url = adresUrl.getEditText().toString();
//
//                if (!url.isEmpty()) {
//                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                    startActivity(myIntent);
//                    finish();
//                } else {
//                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });

        TextView adresUrl = this.findViewById(R.id.link);

        Button buttonSecondActivity = findViewById(R.id.URL);
        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adresUrl.getText().toString()));
                startActivity(intent);
            }
        });


        Button buttonThirdActivity = findViewById(R.id.GEO);
        buttonThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });




    }
}