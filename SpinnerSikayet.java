package com.proje.apartmenynbmg;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerSikayet extends ArrayAdapter<Meskenler> {

        private Context context;
        private List<Meskenler> myObjs;

        public SpinnerSikayet(Context context, int textViewResourceId, List<Meskenler> myObjs) {
            super(context, textViewResourceId, myObjs);
            this.context = context;
            this.myObjs = myObjs;
        }

        public int getCount() {

            return myObjs.size();
        }

        public Meskenler getItem(int position) {

            return myObjs.get(position);
        }

        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView label = new TextView(context);
            label.setText(myObjs.get(position).getAd_Soyad());
            return label;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            TextView label = new TextView(context);
            label.setText(myObjs.get(position).getAd_Soyad());
            return label;
        }

        public int getPosition(Long id) {
            int index = 0;

            for (int i=0;i<myObjs.size();i++){
                if (myObjs.get(i).getId()==(id)){
                    index = i;
                    break;
                }
            }
            return index;
        }
}