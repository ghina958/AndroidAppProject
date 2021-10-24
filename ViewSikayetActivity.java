package com.proje.apartmenynbmg;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewSikayetActivity extends AppCompatActivity {

    ListView list_view;
    ArrayAdapter arrayAdapter;

    DataBase db=new DataBase(ViewSikayetActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sikayet);
        list_view=(ListView) findViewById(R.id.list_view);
        showSikayetListview(db);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });



    }

    private void showSikayetListview(DataBase db3) {
        arrayAdapter = new ArrayAdapter<Sikayet>(ViewSikayetActivity.this, android.R.layout.simple_list_item_1, db3.getAllSikayetler());
        list_view.setAdapter(arrayAdapter);
    }


}