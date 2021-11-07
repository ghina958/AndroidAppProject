package com.proje.apartmenynbmg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context) {

        super(context, "bmg.db", null, 1);

    }

    public static final String TABLE_MESKENLER = "TABLE_MESKENLER";
    public static final String TABLE_BORCLANDIRMA = "TABLE_BORCLANDIRMA";
    public static final String TABLE_GIDER = "TABLE_GIDER";
    public static final String TABLE_GELEN = "TABLE_GELEN";
    public static final String TABLE_SIKAYET = "TABLE_SIKAYET";

    public static final String MESKENLER_ID = "Id";
    public static final String MESKENLER_ADI = "Ad_Soyad";
    public static final String MESKENLER_NUMARA = "Numara";
    public static final String MESKENLER_EMAIL = "Email";
    public static final String MESKENLER_KATNO = "KatNo";
    public static final String MESKENLER_KAPINO = "kapiNo";

    public static final String SIKAYET_ID = "Id";
    public static final String SIKAYET_TARIH = "tarih";
    public static final String SIKAYET_TUR = "tur";
    public static final String SIKAYET_ACIKLAMA = "aciklama";
    public static final String SIKAYET_MESKENID = "meskenID";

    public static final String GIDER_ID = "Id";
    public static final String GIDER_TUR = "tur";
    public static final String GIDER_TUTAR = "tutar";
    public static final String GIDER_TARIH = "tarih";

    public static final String GELEN_ID = "Id";
    public static final String GELEN_TOPLAM = "toplamGelen";
    public static final String GELEN_ODEMEYAPANLAR = "odemeYapanlar";


    public static final String BORC_ID = "Id";
    public static final String BORC_MESKENID = "meskenID";
    public static final String BORC_TUTAR = "tutar";
    public static final String BORC_YIL = "yil";
    public static final String BORC_AY = "ay";
    public static final String BORC_DURUM = "durum";


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1 = "CREATE TABLE " + TABLE_MESKENLER + "("
                + MESKENLER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + MESKENLER_ADI + " TEXT," + MESKENLER_NUMARA + " TEXT, " + MESKENLER_EMAIL + " TEXT,"
                + MESKENLER_KATNO + " TEXT, " + MESKENLER_KAPINO + " TEXT)";
        db.execSQL(sql1);

        String sql2 = "CREATE TABLE "
                + TABLE_SIKAYET + "(" + SIKAYET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + SIKAYET_TARIH + " TEXT," +SIKAYET_TUR+" TEXT, "+ SIKAYET_ACIKLAMA + " TEXT, " + SIKAYET_MESKENID + " INTEGER)";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE " + TABLE_GIDER + "(" + GIDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + GIDER_TUR + " TEXT," +GIDER_TUTAR+" TEXT, "+ GIDER_TARIH + " TEXT )";
        db.execSQL(sql3);

        String sql4 = "CREATE TABLE " + TABLE_BORCLANDIRMA + "(" + BORC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + BORC_MESKENID + " INTEGER," + BORC_TUTAR + " TEXT, " + BORC_YIL + " TEXT," + BORC_AY + " TEXT, " + BORC_DURUM + " TEXT)";
        db.execSQL(sql4);

        String sql5 = "CREATE TABLE " + TABLE_GELEN + "(" + GELEN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + GELEN_TOPLAM + " INTEGER," + GELEN_ODEMEYAPANLAR +" INTEGER)";
        db.execSQL(sql5);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESKENLER);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIKAYET);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIDER);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BORCLANDIRMA);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GELEN);
        onCreate(db);
    }

    public boolean insertMeskenler(Meskenler meskenler) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(MESKENLER_ID, meskenler.getId());
        contentValues.put(MESKENLER_ADI, meskenler.getAd_Soyad());
        contentValues.put(MESKENLER_NUMARA, meskenler.getNumara());
        contentValues.put(MESKENLER_EMAIL, meskenler.getEmail());
        contentValues.put(MESKENLER_KATNO, meskenler.getKatNo());
        contentValues.put(MESKENLER_KAPINO, meskenler.getKapıNo());

        long result = db.insert(TABLE_MESKENLER, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<Meskenler> getAllMeskenler() {

        List<Meskenler> c = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryList = "SELECT * FROM " + TABLE_MESKENLER;
        Cursor cursor = db.rawQuery(queryList, new String[]{});

        while (cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex(MESKENLER_ID));
            String adi = cursor.getString(cursor.getColumnIndex(MESKENLER_ADI));
            int numara = cursor.getInt(cursor.getColumnIndex(MESKENLER_NUMARA));
            String email = cursor.getString(cursor.getColumnIndex(MESKENLER_EMAIL));
            int katNo = cursor.getInt(cursor.getColumnIndex(MESKENLER_KATNO));
            int kapiNo = cursor.getInt(cursor.getColumnIndex(MESKENLER_KAPINO));

            Meskenler meskenler = new Meskenler(id, adi, numara, email, katNo, kapiNo);
            c.add(meskenler);
        }

        cursor.close();
        db.close();
        return c;
    }


    public boolean updateMeskenler(String id, String adi, String numara, String email, String katNo, String kapiNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(MESKENLER_ID, id);
        contentValues.put(MESKENLER_ADI, adi);
        contentValues.put(MESKENLER_NUMARA, numara);
        contentValues.put(MESKENLER_EMAIL, email);
        contentValues.put(MESKENLER_KATNO, katNo);
        contentValues.put(MESKENLER_KAPINO, kapiNo);
        db.update(TABLE_MESKENLER, contentValues, "id=?", new String[]{id});
        return true;
    }

    public Integer deleteMeskenler(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_MESKENLER, "id=?", new String[]{Id});

    }


    public boolean insertSikayet(Sikayet sikayet) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SIKAYET_ID, sikayet.getId());
        contentValues.put(SIKAYET_TARIH, sikayet.getTarih());
        contentValues.put(SIKAYET_TUR, sikayet.getTur());
        contentValues.put(SIKAYET_ACIKLAMA, sikayet.getAciklama());
        contentValues.put(SIKAYET_MESKENID, sikayet.getMeskenID());

        long result = db.insert(TABLE_SIKAYET, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<Sikayet> getAllSikayetler() {

        List<Sikayet> s = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryList = "SELECT * FROM " + TABLE_SIKAYET;
        Cursor cursor = db.rawQuery(queryList, new String[]{});

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(SIKAYET_ID));
            String Tarih = cursor.getString(cursor.getColumnIndex(SIKAYET_TARIH));
            String tur=cursor.getString(cursor.getColumnIndex(SIKAYET_TUR));
            String aciklama = cursor.getString(cursor.getColumnIndex(SIKAYET_ACIKLAMA));
            int meskenID = cursor.getInt(cursor.getColumnIndex(SIKAYET_MESKENID));

            Sikayet sikayet = new Sikayet(id, Tarih, tur,aciklama, meskenID);
            s.add(sikayet);
        }
        cursor.close();
        db.close();
        return s;
    }

    public boolean updateSikayetler(String id, String Tarih, String tur, String aciklama,int meskenID ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SIKAYET_TARIH, Tarih);
        contentValues.put(SIKAYET_TUR, tur);
        contentValues.put(SIKAYET_ACIKLAMA, aciklama);
        contentValues.put(SIKAYET_MESKENID, meskenID);

        db.update(TABLE_SIKAYET, contentValues, "id=?", new String[]{id});
        return true;
    }

    public Integer deleteSikayetler(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_SIKAYET, "id=?", new String[]{Id});

    }

    public boolean insertBorclandirma(Borclandirma borc) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(BORC_ID, borc.getId());
            contentValues.put(BORC_MESKENID, borc.getMeskenID());
            contentValues.put(BORC_TUTAR, borc.getTutar());
            contentValues.put(BORC_YIL, borc.getYil());
            contentValues.put(BORC_AY, borc.getAy());
            contentValues.put(BORC_DURUM, "Y");

            long result = db.insert(TABLE_BORCLANDIRMA, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public List<BorcMesken> getAllDurum() {

        List<BorcMesken> b = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        int yil = cal.get(Calendar.YEAR);
        int ay = cal.get(Calendar.MONTH) + 1;

        String queryList = "select borc.Id as Id ,borc.tutar as tutar,mes.Ad_Soyad as Ad_Soyad,mes.kapiNo as kapiNo from TABLE_BORCLANDIRMA borc " +
                ",TABLE_MESKENLER mes WHERE borc.durum = 'Y' and borc.meskenID = mes.Id and borc.yil=" + String.valueOf(yil) + " and borc.ay=" + String.valueOf(ay) + "";

        Cursor cursor = db.rawQuery(queryList, new String[]{});
        while (cursor.moveToNext()) {

            int Id = cursor.getInt(cursor.getColumnIndex(BORC_ID));
            String tutar = cursor.getString(cursor.getColumnIndex(BORC_TUTAR));
            String meskenAd = cursor.getString(cursor.getColumnIndex(MESKENLER_ADI));
            String meskenKapi = cursor.getString(cursor.getColumnIndex(MESKENLER_KAPINO));

            BorcMesken borcMesken = new BorcMesken(Id, tutar, meskenAd, meskenKapi);
            b.add(borcMesken);
        }
        cursor.close();
        db.close();
        return b;

    }

    public int getAllGelenOdeme() {

        SQLiteDatabase db = this.getReadableDatabase();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        int yil = cal.get(Calendar.YEAR);
        int ay = cal.get(Calendar.MONTH) + 1;

        String queryList = "select borc.Id as Id ,Sum(borc.tutar) as tutar,mes.Ad_Soyad as Ad_Soyad from TABLE_BORCLANDIRMA borc " +
                ",TABLE_MESKENLER mes WHERE borc.durum = 'E' and borc.yil=" + String.valueOf(yil) + " and borc.ay=" + String.valueOf(ay) + "";

        Cursor cursor = db.rawQuery(queryList, new String[]{});
        int sum = cursor.getInt(cursor.getColumnIndex("tutar"));
        cursor.close();
        db.close();
        return sum;

    }


    public boolean updateCustomList(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("durum", "E");

        db.update(TABLE_BORCLANDIRMA, contentValues,"Id=?" ,new String[]{Id});
        return true;
    }

    public Integer deleteCustomList(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_BORCLANDIRMA, "id=?", new String[]{Id});

    }


    public boolean insertGider(Gider gider) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(GIDER_TUR, gider.getTur());
        contentValues.put(GIDER_TUTAR, gider.getGiderTutar());
        contentValues.put(GIDER_TARIH,gider.getTarih() );

        long result = db.insert(TABLE_GIDER, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<Gider> getAllGider() {

        List<Gider> g = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryList = "SELECT * FROM " + TABLE_GIDER;
        Cursor cursor = db.rawQuery(queryList, new String[]{});

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(GIDER_ID));
            String tur = cursor.getString(cursor.getColumnIndex(GIDER_TUR));
            int tutar = cursor.getInt(cursor.getColumnIndex(GIDER_TUTAR));
            int  tarih = cursor.getInt(cursor.getColumnIndex(GIDER_TARIH));


            Gider gider = new Gider(id, tur, tutar, tarih);
            g.add(gider);
        }
        cursor.close();
        db.close();
        return g;
    }

    public boolean updateGider(String id, String tur, int tutar,int tarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(GIDER_TUR, tur);
        contentValues.put(GIDER_TUTAR, tutar);
        contentValues.put(GIDER_TARIH, tarih);

        db.update(TABLE_GIDER, contentValues, "id=?", new String[]{id});
        return true;
    }

    public Integer deleteGider(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_GIDER, "id=?", new String[]{Id});
    }


    public Integer deleteBorclandirma(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_BORCLANDIRMA, "id=?", new String[]{Id});
    }


    public boolean insertGelen(Gelen gelen) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(GELEN_ID, gelen.getId());
        contentValues.put(GELEN_TOPLAM, gelen.getToplamGelen());


        long result = db.insert(TABLE_GELEN, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<Gelen> getAllGelen() {

        List<Gelen> c = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryList = "SELECT * FROM " + TABLE_GELEN;
        Cursor cursor = db.rawQuery(queryList, new String[]{});

        while (cursor.moveToNext()) {

            int Id = cursor.getInt(cursor.getColumnIndex(GELEN_ID));
            int toplamGelen = cursor.getInt(cursor.getColumnIndex(GELEN_TOPLAM));
            int odemeYapanlar = cursor.getInt(cursor.getColumnIndex(GELEN_ODEMEYAPANLAR));

            Gelen gelen = new Gelen(Id, toplamGelen);
            c.add(gelen);
        }
        cursor.close();
        db.close();
        return c;
    }




    public int getMaxIDMesken() {
        int mx = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX ("+  MESKENLER_ID +") FROM " + TABLE_MESKENLER, null);
        if (cursor != null)
            if (cursor.moveToFirst()) {
                mx = cursor.getInt(0);
            }
        return mx+1;
    }

    public int getMaxIDBorc() {
        int mx = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX ("+ BORC_ID +") FROM " + TABLE_BORCLANDIRMA, null);
        if (cursor != null)
            if (cursor.moveToFirst()) {
                mx = cursor.getInt(0);
            }
        return mx+1;
    }


    public int getMaxIDSikayet() {
        int mx = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX ("+ SIKAYET_ID +") FROM " + TABLE_SIKAYET, null);
        if (cursor != null)
            if (cursor.moveToFirst()) {
                mx = cursor.getInt(0);
            }
        return mx+1;
    }

    public int getMaxIDGelen() {
        int mx = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX ("+ GELEN_ID +") FROM " + TABLE_GELEN, null);
        if (cursor != null)
            if (cursor.moveToFirst()) {
                mx = cursor.getInt(0);
            }
        return mx+1;
    }
}
