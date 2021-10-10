package com.proje.apartmenynbmg;

public class Tahakkuk {

    int yil;
    String ay;
    int tutar;


    public Tahakkuk(int yil, String ay, int tutar) {
        this.yil = yil;
        this.ay = ay;
        this.tutar = tutar;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return "Tahakkuk{" +
                "yil=" + yil +
                ", ay='" + ay + '\'' +
                ", tutar=" + tutar +
                '}';
    }
}
