package com.proje.apartmenynbmg;

public class Gider {

    private int Id ;
    private String tur;
    private int giderTutar;
    private int tarih;

    public Gider(){

    }

    public Gider(int id, String tur, int giderTutar, int tarih) {
        Id = id;
        this.tur = tur;
        this.giderTutar = giderTutar;
        this.tarih = tarih;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getGiderTutar() {
        return giderTutar;
    }

    public void setGiderTutar(int giderTutar) {
        this.giderTutar = giderTutar;
    }

    public int getTarih() {
        return tarih;
    }

    public void setTarih(int tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Gider{" +
                "Id=" + Id +
                ", tur='" + tur + '\'' +
                ", giderTutar=" + giderTutar +
                ", tarih=" + tarih +
                '}';
    }
}
