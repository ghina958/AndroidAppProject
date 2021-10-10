package com.proje.apartmenynbmg;

public class Meskenler {
    private int Id ;
    private String Ad_Soyad;
    private int Numara;
    private String Email;
    private int KatNo;
    private int KapıNo;

    public Meskenler(){

    }

    public Meskenler(int id, String ad_Soyad, int numara, String email, int katNo, int kapıNo) {
        Id = id;
        Ad_Soyad = ad_Soyad;
        Numara = numara;
        Email = email;
        KatNo = katNo;
        KapıNo = kapıNo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAd_Soyad() {
        return Ad_Soyad;
    }

    public void setAd_Soyad(String ad_Soyad) {
        Ad_Soyad = ad_Soyad;
    }

    public int getNumara() {
        return Numara;
    }

    public void setNumara(int numara) {
        Numara = numara;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getKatNo() {
        return KatNo;
    }

    public void setKatNo(int katNo) {
        KatNo = katNo;
    }

    public int getKapıNo() {
        return KapıNo;
    }

    public void setKapıNo(int kapıNo) {
        KapıNo = kapıNo;
    }



    @Override
    public String toString() {
        return "Meskenler{" +
                "Id=" + Id +
                ", Ad_Soyad='" + Ad_Soyad + '\'' +
                ", Numara=" + Numara +
                ", Email='" + Email + '\'' +
                ", KatNo=" + KatNo +
                ", KapıNo=" + KapıNo +
                '}';
    }
}
