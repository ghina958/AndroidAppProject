package com.proje.apartmenynbmg;

public class Borclandirma {

    private int Id;
    private int meskenID;
    private String tutar;
    private String yil;
    private String ay;
    private String durum;


    public Borclandirma(){

    }

    public Borclandirma(int id, int meskenID, String tutar, String yil, String ay, String durum) {
        Id = id;
        this.meskenID = meskenID;
        this.tutar = tutar;
        this.yil = yil;
        this.ay = ay;
        this.durum = durum;
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMeskenID() {
        return meskenID;
    }

    public void setMeskenID(int meskenID) {
        this.meskenID = meskenID;
    }


    public String getTutar() {
        return tutar;
    }

    public void setTutar(String tutar) {
        this.tutar = tutar;
    }


    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }


    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Borclandirma{" +
                "Id=" + Id +
                ", meskenID=" + meskenID +
                ", tutar='" + tutar + '\'' +
                ", yil='" + yil + '\'' +
                ", ay='" + ay + '\'' +
                ", durum='" + durum + '\'' +
                '}';
    }
}
