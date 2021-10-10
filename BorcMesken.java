package com.proje.apartmenynbmg;

public class BorcMesken {

    private int Id ;
    private String tutar;
    private String meskenAd;
    private String meskenKapi;

    public BorcMesken(){

    }

    public BorcMesken(int id, String tutar, String meskenAd, String meskenKapi) {
        Id = id;
        this.tutar = tutar;
        this.meskenAd = meskenAd;
        this.meskenKapi = meskenKapi;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTutar() {
        return tutar;
    }

    public void setTutar(String tutar) {
        this.tutar = tutar;
    }

    public String getMeskenAd() {
        return meskenAd;
    }

    public void setMeskenAd(String meskenAd) {
        this.meskenAd = meskenAd;
    }

    public String getMeskenKapi() {
        return meskenKapi;
    }

    public void setMeskenKapi(String meskenKapi) {
        this.meskenKapi = meskenKapi;
    }

    @Override
    public String toString() {
        return "BorcMesken{" +
                "Id=" + Id +
                ", tutar='" + tutar + '\'' +
                ", meskenAd='" + meskenAd + '\'' +
                ", meskenKapi='" + meskenKapi + '\'' +
                '}';
    }
}
