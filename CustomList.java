package com.proje.apartmenynbmg;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomList extends AppCompatActivity {

    ListView list_view;
    MyAdapter myAdapter;
    DataBase db = new DataBase(CustomList.this);

    TextView ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        list_view = findViewById(R.id.list_view);

        myAdapter = new MyAdapter(CustomList.this, db.getAllDurum() );
        list_view.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        showListview(db);

    }

    private void showListview(DataBase db2) {
        try {
            myAdapter = new MyAdapter(CustomList.this, db2.getAllDurum() );
            list_view.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}