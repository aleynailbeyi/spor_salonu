package com.example.sporsalonum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SporcuGiris extends AppCompatActivity {

    TextView text;
    EditText kAdi, Parola;
    Button btnGiris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sporcu_giris);
        SporcuTanimla();
    }
    public void SporcuTanimla(){
        text = ((TextView) findViewById(R.id.baslik));
        kAdi = ((EditText) findViewById(R.id.et_login_email));
        Parola = ((EditText) findViewById(R.id.et_login_parola));
        btnGiris = ((Button) findViewById(R.id.btn_login));
    }

}