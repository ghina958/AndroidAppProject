package com.proje.apartmenynbmg;

public class Sikayet {

    private int Id ;
    private String Tarih;
    private String tur;
    private String aciklama;
    private int  meskenID;

    public Sikayet(){

    }

    public Sikayet(int id, String tarih, String tur, String aciklama, int meskenID) {
        Id = id;
        Tarih = tarih;
        this.tur = tur;
        this.aciklama = aciklama;
        this.meskenID = meskenID;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getMeskenID() {
        return meskenID;
    }

    public void setMeskenID(int meskenID) {
        this.meskenID = meskenID;
    }

    @Override
    public String toString() {
        return "Sikayet{" +
                "Id=" + Id +
                ", Tarih='" + Tarih + '\'' +
                ", sikayetAciklama='" + aciklama + '\'' +
                ", sikayetci='" + meskenID + '\'' +
                '}';
    }
}
