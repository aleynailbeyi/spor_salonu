package com.example.sporsalonum;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class KullaniciTipi extends Fragment {

    RadioButton rbSporcu;
    RadioButton rbSalon;
    View view;
  // String kullanici_tipi = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void gecSporcuFragment(View v){
        SporcuProfile sporcuProfile = new SporcuProfile();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_kullanici_tipi,sporcuProfile,"Sporcu Profile Fragment");
        transaction.commit();
    }
    public void gecSalonFragment(View v){
        SalonProfile salonProfile = new SalonProfile();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_kullanici_tipi,salonProfile,"Salon Profile Fragment");
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kullanici_tipi, container, false);
        onRadioButtonClicked(view);


//                int radioButtonID = rg.getCheckedRadioButtonId();
//                View rb = rg.findViewById(radioButtonID);
//                int idx = rg.indexOfChild(rb);
//                System.out.println(idx);
//
//                if(idx == 0){
//                    kullanici_tipi = "Sporcu";
//                    gecSporcuFragment(myView);
//                }
//                else if (idx == 1) {
//                    kullanici_tipi = "Salon";
//                    gecSalonFragment(myView);
//                }
//                System.out.println(kullanici_tipi);
     return v;
    }
    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.rb_sporcu:
                if(checked){
                    gecSporcuFragment(rbSporcu);
                    break;
                }
            case R.id.rb_salon:
                if(checked){
                    gecSalonFragment(rbSalon);
                    break;
                }
        }
    }

}