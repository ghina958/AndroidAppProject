package com.proje.apartmenynbmg;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<BorcMesken> get;
    DataBase db;

    public MyAdapter(Context context, List<BorcMesken> get) {
        this.context = context;
        this.get = get;
    }
    @Override
    public int getCount() {
        return get.size();
    }
    @Override
    public Object getItem(int position) {
        return get.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter, null);

            TextView kapiNumara = (TextView) convertView.findViewById(R.id.kapiNumara);
            TextView MeskenAd = (TextView) convertView.findViewById(R.id.meskenAd);
            TextView tutar = (TextView) convertView.findViewById(R.id.tutar);

            final BorcMesken borcMesken = (BorcMesken) getItem(position);
            kapiNumara.setText(borcMesken.getMeskenKapi());
            MeskenAd.setText(borcMesken.getMeskenAd());
            tutar.setText(borcMesken.getTutar());
            Button durum_btn=(Button) convertView.findViewById(R.id.durum_btn);
            durum_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder=new AlertDialog.Builder(v.getRootView().getContext());
                View dialogView=LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.activity_dialog,null);
                builder.setView(dialogView);

                TextView Ad,tutar;
                Button ok,durum;

                 ok = (Button)dialogView.findViewById(R.id.ok);
                 Ad=(TextView)dialogView.findViewById(R.id.Ad);
                 tutar=(TextView)dialogView.findViewById(R.id.tutar);
                 durum=(Button)dialogView.findViewById(R.id.durum);

                 Ad.setText(borcMesken.getMeskenAd());
                 tutar.setText(borcMesken.getTutar());


               durum.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       try{
                           db.updateCustomList(String.valueOf(borcMesken.getId()));

                       }catch (Exception e){

                           e.printStackTrace();
                       }
                   }
               });


                final AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();


                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

            }
        });

        return convertView;
    }
}
