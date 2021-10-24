package com.proje.apartmenynbmg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class sikayetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText tarih,aciklama,eid;
    Spinner tur,meskenID;
    Button add,view,delete,update;
    DataBase db=new DataBase(sikayetActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sikayet);


        tarih=(EditText) findViewById(R.id.tarih);
        tur=(Spinner)findViewById(R.id.tur);
        aciklama=(EditText) findViewById(R.id.aciklama);
        meskenID=(Spinner)findViewById(R.id.meskenID);
        eid=(EditText) findViewById(R.id.eid);

        add =(Button)findViewById(R.id.add);
        view=(Button)findViewById(R.id.view);
        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);

        tur.setOnItemSelectedListener(this);

        List<Meskenler> meskenler=db.getAllMeskenler();

        SpinnerSikayet spin=new SpinnerSikayet(this, android.R.layout.simple_spinner_item, meskenler);
        meskenID.setAdapter(spin);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         try {
             DataBase db = new DataBase(sikayetActivity.this);
             Sikayet sikayet = new Sikayet();

             sikayet.setId( db.getMaxIDSikayet());
             sikayet.setTarih(tarih.getText().toString());
             sikayet.setTur(tur.getSelectedItem().toString());
             sikayet.setAciklama(aciklama.getText().toString());
             sikayet.setMeskenID( ( (Meskenler)meskenID.getSelectedItem()).getId()  );

             boolean success = db.insertSikayet(sikayet);
             Toast.makeText(sikayetActivity.this, "Success=" + success, Toast.LENGTH_SHORT).show();
         }catch (Exception e){

            e.printStackTrace();
         }
            tarih.setText("");
            aciklama.setText("");

            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewSikayetActivity();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success= db.updateSikayetler(
                        eid.getText().toString(),
                        tarih.getText().toString(),tur.getSelectedItem().toString(),
                        aciklama.getText().toString(),( (Meskenler)meskenID.getSelectedItem()).getId() );

                if(success==true){
                    Toast.makeText(sikayetActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(sikayetActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                }
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int d= db.deleteSikayetler(eid.getText().toString());
                if(d > 0)
                    Toast.makeText(sikayetActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(sikayetActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });



        meskenID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        tur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public void ViewSikayetActivity() {

        Intent intent=new Intent(this,ViewSikayetActivity.class);
        startActivity(intent);

    }

}