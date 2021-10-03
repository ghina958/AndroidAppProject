package com.proje.apartmenynbmg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
