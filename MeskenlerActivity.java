package com.proje.apartmenynbmg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MeskenlerActivity extends AppCompatActivity {

    Button add,view,delete,update;
    EditText ETid,ETname,ETtelefon,ETemail,ETkatno,ETkapıno;

    DataBase db=new DataBase(MeskenlerActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meskenler);

        add =(Button)findViewById(R.id.add);
        view=(Button)findViewById(R.id.view);
        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);
        ETid =(EditText) findViewById(R.id.ETid);
        ETname=(EditText) findViewById(R.id.ETname);
        ETtelefon=(EditText) findViewById(R.id.ETtelefon);
        ETemail=(EditText) findViewById(R.id.ETemail);
        ETkatno=(EditText) findViewById(R.id.ETkatno);
        ETkapıno=(EditText) findViewById(R.id.ETkapıno);
        //list_view=(ListView) findViewById(R.id.list_view);

       // showMeskenlerListview(db);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Meskenler meskenler =new Meskenler(
                 db.getMaxIDMesken(),ETname.getText().toString(),Integer.parseInt(ETtelefon.getText().toString()),ETemail.getText().toString(),Integer.parseInt(ETkatno.getText().toString()),Integer.parseInt(ETkapıno.getText().toString()));
                DataBase db=new DataBase(MeskenlerActivity.this);
                boolean success = db.insertMeskenler(meskenler);
                Toast.makeText(MeskenlerActivity.this,"Success="+success ,Toast.LENGTH_SHORT).show();

                //ETid.setText("");
                ETname.setText("");
                ETtelefon.setText("");
                ETemail.setText("");
                ETkatno.setText("");
                ETkapıno.setText("");
            }
        });


       view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ViewMeskenlerActivity();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success= db.updateMeskenler(
                        ETid.getText().toString(),
                        ETname.getText().toString(),
                        ETtelefon.getText().toString(),
                        ETemail.getText().toString(),
                        ETkatno.getText().toString(),
                        ETkapıno.getText().toString());
                if(success==true){
                    Toast.makeText(MeskenlerActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MeskenlerActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                }
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int d= db.deleteMeskenler(ETid.getText().toString());
                if(d > 0)
                    Toast.makeText(MeskenlerActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MeskenlerActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });


    }

    public void ViewMeskenlerActivity() {

        Intent intent=new Intent(this,ViewMeskenlerActivity.class);
        startActivity(intent);

    }


}