package com.example.erigom.fragmentosimple;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentoEjemplo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup group,Bundle bundle){
        return layoutInflater.inflate(R.layout.fragment_fragmento_ejemplo,group,false);
    }
}
