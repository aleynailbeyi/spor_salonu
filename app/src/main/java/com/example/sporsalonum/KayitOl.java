package com.example.sporsalonum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class KayitOl extends AppCompatActivity {

    EditText email, kullaniciadi, parola;
    Button kayit;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        mAuth=FirebaseAuth.getInstance();
        tanimla();
        btnTikla();
        anlikKullanici();

    }

    public void tanimla(){
        email = ((EditText) findViewById(R.id.et_register_email));
        kullaniciadi = ((EditText) findViewById(R.id.et_register_name));
        parola = ((EditText) findViewById(R.id.et_register_parola));
        kayit = ((Button) findViewById(R.id.btn_register_kayitol));
        progressBar = ((ProgressBar) findViewById(R.id.message));
    }

    public void btnTikla(){
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String password = parola.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email alani bos birakilamaz...");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    parola.setError("Parola alani bos birakilamaz...");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(KayitOl.this,"Kullanici Kaydedildi.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(KayitOl.this,"HATA !" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    public void anlikKullanici(){
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

}