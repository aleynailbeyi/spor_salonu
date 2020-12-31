package com.example.sporsalonum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button sporcu_giris, salon_giris, kayitOl;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        btnTanimla();
        tikla();
    }

    public void btnTanimla(){
        sporcu_giris = ((Button) findViewById(R.id.sporcu_giris));
        salon_giris = ((Button) findViewById(R.id.salon_giris));
        kayitOl = ((Button) findViewById(R.id.login));
    }
    private void tikla(){
        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,KayitOl.class);
                startActivity(intent);
            }
        });
        sporcu_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,SporcuGiris.class);
                startActivity(in);
            }
        });
        salon_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SalonGiris.class);
                startActivity(i);
            }

        });
        }

    }
