package com.example.sporsalonum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SalonGiris extends AppCompatActivity {

    TextView textSalon;
    EditText kAdiSalon, ParolaSalon;
    Button btnSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_giris);
        SalonTanimla();
    }
    public void SalonTanimla(){
        textSalon = ((TextView) findViewById(R.id.baslik_salon));
        kAdiSalon = ((EditText) findViewById(R.id.login_eposta_salon));
        ParolaSalon = ((EditText) findViewById(R.id.login_parola_salon));
        btnSalon = ((Button) findViewById(R.id.btn_login_salon));

    }
}