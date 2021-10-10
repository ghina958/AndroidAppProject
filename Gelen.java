package com.proje.apartmenynbmg;

public class Gelen {
    private int Id;
    private int toplamGelen;


    public  Gelen(){

    }

    public Gelen(int id, int toplamGelen) {
        Id = id;
        this.toplamGelen = toplamGelen;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getToplamGelen() {
        return toplamGelen;
    }

    public void setToplamGelen(int toplamGelen) {
        this.toplamGelen = toplamGelen;
    }


    @Override
    public String toString() {
        return "Gelen{" +
                "toplamGelen=" + toplamGelen +
                '}';
    }
}
