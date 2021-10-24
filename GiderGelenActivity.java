package com.proje.apartmenynbmg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GiderGelenActivity extends AppCompatActivity {

Button btn_gider,btn_gelen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gider_gelen);

        btn_gider=(Button)findViewById(R.id.btn_gider);
        btn_gelen=(Button)findViewById(R.id.btn_gelen);

        btn_gider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GiderActivity();
            }
        });

        btn_gelen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GelenActivity();
            }
        });

    }

    public void  GiderActivity(){
        Intent intent=new Intent(this,GiderActivity.class);
        startActivity(intent);

    }

    public void  GelenActivity(){
        Intent intent=new Intent(this,GelenActivity.class);
        startActivity(intent);

    }

}