package com.proje.apartmenynbmg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DahaFazlaActivity extends AppCompatActivity {
    Button btn_sikayet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daha_fazla);

        btn_sikayet=(Button)findViewById(R.id.btn_sikayet);

        btn_sikayet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sikayetActivity();
            }
        });
    }

    public void  sikayetActivity(){
        Intent intent=new Intent(this,sikayetActivity.class);
        startActivity(intent);

    }
}