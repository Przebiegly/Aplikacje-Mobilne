package com.example.zadanie3;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout myScreen;
    private EditText txtColorSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myScreen = findViewById(R.id.myScreen1);
        txtColorSelected = findViewById(R.id.editText1);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        txtColorSelected.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nie potrzebujemy tej metody
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setBackgroundColor(s.toString().toLowerCase());
            }
        });
    }

    private void setBackgroundColor(String chosenColor) {
        if (chosenColor.contains("red")) {
            myScreen.setBackgroundColor(0xffff0000);
        } else if (chosenColor.contains("green")) {
            myScreen.setBackgroundColor(0xff00ff00);
        } else if (chosenColor.contains("blue")) {
            myScreen.setBackgroundColor(0xff0000ff);
        } else {
            myScreen.setBackgroundColor(0xffffffff);
        }
    }
}
