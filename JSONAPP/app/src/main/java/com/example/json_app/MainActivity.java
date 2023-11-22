package com.example.json_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView jsonText;
    Button jsonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        jsonText = findViewById(R.id.jsonText);
        jsonButton = findViewById(R.id.jsonButton);

        jsonButton.setOnClickListener(v -> {

            try {
                URL url = new URL("http://zasob.itmargen.com/4TR/");
                URLConnection uc = url.openConnection();
                String password = "";
                String username = "";
                String userpass = username + ":" + password;

                String basicAuth = "Basic " + android.util.Base64.encodeToString(userpass.getBytes(), android.util.Base64.DEFAULT);

                uc.setRequestProperty("Authorization", basicAuth);

                System.out.println(uc.getRequestProperty("Authorization"));

                String response = "";
                try (Scanner scanner = new Scanner(uc.getInputStream())) {
                    response = scanner.useDelimiter("\\A").next();
                    System.out.println(response);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                StringBuilder finalText = new StringBuilder();

                JSONObject jobject = new JSONObject(response);

                JSONObject infoObject = (JSONObject) jobject.get("info");
                finalText.append("INFO: " + "\n");
                finalText.append("Przedmiot: " + infoObject.get("przedmiot") + "\n");
                finalText.append("Prowadzacy: " + infoObject.get("prowadzacy") + "\n");
                finalText.append("Szkola: " + infoObject.get("szkola") + "\n");
                finalText.append("Miasto: " + infoObject.get("miasto") + "\n");
                finalText.append("Data i czas: " + infoObject.get("dataczas") + "\n");

                JSONObject nazwiska2 = (JSONObject) jobject.get("Grupa2");
                finalText.append("Uczen: " + nazwiska2.get("3"));
                jsonText.setText(finalText);

            } catch (Exception e) {
                System.out.println(e);
            }
        });

    }
}

