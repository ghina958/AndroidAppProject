package com.proje.apartmenynbmg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_customList,btn_meskenler,btn_gider,btn_dahafazla,tahakkuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_customList=(Button) findViewById(R.id.btn_customList);
        btn_meskenler=(Button) findViewById(R.id.btn_meskenler);
        btn_gider=(Button) findViewById(R.id.btn_gider);
        btn_dahafazla=(Button) findViewById(R.id.btn_dahafazla);
        tahakkuk=(Button) findViewById(R.id.tahakkuk);

        btn_customList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { CustomList(); }
        });

        tahakkuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { TahakkukActivity(); }
        });

        btn_meskenler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeskenlerActivity();
            }
        });

        btn_gider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GiderGelenActivity();
            }
        });

        btn_dahafazla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DahaFazlaActivity();
            }
        });
    }

    public void CustomList(){
        Intent intent=new Intent(this,CustomList.class);
        startActivity(intent);

    }

    public void TahakkukActivity(){
        Intent intent=new Intent(this,TahakkukActivity.class);
        startActivity(intent);

    }

    public void MeskenlerActivity(){
        Intent intent=new Intent(this,MeskenlerActivity.class);
        startActivity(intent);

    }

    public void GiderGelenActivity(){
        Intent intent=new Intent(this,GiderGelenActivity.class);
        startActivity(intent);

    }

    public void  DahaFazlaActivity(){
        Intent intent=new Intent(this,DahaFazlaActivity.class);
        startActivity(intent);
    }
}