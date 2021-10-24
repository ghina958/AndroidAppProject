package com.proje.apartmenynbmg;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class GiderActivity extends AppCompatActivity {
        EditText giderTutar,tarih;
        Spinner tur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gider);

        tur=(Spinner)findViewById(R.id.tur);
        giderTutar=(EditText) findViewById(R.id.giderTutar);
        tarih=(EditText) findViewById(R.id.tarih);
    }
}