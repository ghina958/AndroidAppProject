package com.proje.apartmenynbmg;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GelenActivity extends AppCompatActivity {
    EditText toplamGelen;
    DataBase db=new DataBase(GelenActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelen);

        toplamGelen=(EditText)findViewById(R.id.toplamGelen);

        Gelen g=new Gelen();
        g.setToplamGelen(Integer.parseInt(toplamGelen.getText().toString()));

        boolean success = db.insertGelen(g);
        Toast.makeText(GelenActivity.this,"Data Added="+success ,Toast.LENGTH_SHORT).show();
    }


}