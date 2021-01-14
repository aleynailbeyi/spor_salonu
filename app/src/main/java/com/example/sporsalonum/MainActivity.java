package com.example.sporsalonum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button  kayitOl, girisYap;
    TextView tv, baslik;

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
        kayitOl = ((Button) findViewById(R.id.sign_up));
        girisYap = ((Button) findViewById(R.id.giris_yap));
        tv = (TextView)findViewById(R.id.text);
        baslik = ((TextView) findViewById(R.id.tx_baslik));
    }
    public void tikla(){
        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,KayitOl.class);
                startActivity(intent);
            }
        });
        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GirisYap.class);
                startActivity(intent);
            }
        });

        }

    }
