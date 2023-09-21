package com.example.pdf_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        TextView Name = findViewById(R.id.Imie_i_nazwisko);
        Name.setText("Bartosz Lauer");

        TextView back = findViewById(R.id.powrót);
        back.setText("Kliknij przycisk back by wrócić do poprzedniego ekranu");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}