package com.proje.apartmenynbmg;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewMeskenlerActivity extends AppCompatActivity {

    DataBase db=new DataBase(ViewMeskenlerActivity.this);
    ArrayAdapter arrayAdapter;

    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meskenler);

        list_view=(ListView) findViewById(R.id.list_view);

        showMeskenlerListview(db);


    }

    private void showMeskenlerListview(DataBase db2) {
        arrayAdapter = new ArrayAdapter<Meskenler>(ViewMeskenlerActivity.this, android.R.layout.simple_list_item_multiple_choice, db2.getAllMeskenler());
        list_view.setAdapter(arrayAdapter);
    }

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String selectedItems="Selectd items: \n";
        for(int i=0; i<list_view.getCount();i++){

              if(list_view.isItemChecked(i))
    {
        selectedItems+=list_view.getItemAtPosition(i)+ "\n ";
    }
      }
            Toast.makeText(ViewMeskenlerActivity.this, selectedItems,Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }*/


}