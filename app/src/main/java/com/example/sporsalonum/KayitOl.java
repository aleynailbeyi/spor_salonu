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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class KayitOl extends AppCompatActivity {

    EditText email, username, parola;
    RadioGroup rg;
    Button kayitOl;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    String kullanici_tipi = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        mAuth=FirebaseAuth.getInstance();
        tanimla();
//        btnKayit();
        btnTikla();
    }

    public void tanimla(){
       email = ((EditText) findViewById(R.id.et_register_email));
       username = ((EditText) findViewById(R.id.et_register_name));
       parola = ((EditText) findViewById(R.id.et_register_parola));
       rg = ((RadioGroup) findViewById(R.id.rg_kayit));
       kayitOl = ((Button) findViewById(R.id.btn_register_kayitol));
       progressBar = ((ProgressBar) findViewById(R.id.message));

    }

//    public void btnKayit() {
//        if (sporcu_rb.isSelected()) {
//            Intent i = new Intent(KayitOl.this, SporcuProfile.class);
//            startActivity(i);
//            finish();
//        } else if (salon_rb.isSelected()) {
//            Intent i = new Intent(KayitOl.this, SalonProfile.class);
//            startActivity(i);
//            finish();
//        } else {
//            Toast.makeText(KayitOl.this, "HATA !", Toast.LENGTH_LONG).show();
//        }
//    }
    public void btnTikla(){
        kayitOl.setOnClickListener(new View.OnClickListener() {
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

                int radioButtonID = rg.getCheckedRadioButtonId();
                View rb = rg.findViewById(radioButtonID);
                int idx = rg.indexOfChild(rb);
                System.out.println(idx);

                if(idx == 0){
                    kullanici_tipi = "Sporcu";
                }
                else if (idx == 1) {
                    kullanici_tipi = "Salon";
                }
                else {
                    Toast.makeText(KayitOl.this,"Hata! Kullanıcı tipi seçmediniz!" ,Toast.LENGTH_SHORT).show();
                }
                System.out.println(kullanici_tipi);
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(KayitOl.this,"Kullanici Kaydedildi.",Toast.LENGTH_SHORT).show();
                            System.out.println(mAuth.getCurrentUser().getEmail());

                        }
                        else{
                            Toast.makeText(KayitOl.this,"HATA !" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

}