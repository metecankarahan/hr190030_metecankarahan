package com.hr190030.metecan_karahan_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TakimModel {

    @SerializedName("TakimAdi")
    @Expose
    private String takimAdi;
    @SerializedName("TakimKurulusTarihi")
    @Expose
    private String takimKurulusTarihi;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("TakimTarihcesi")
    @Expose
    private String takimTarihcesi;

    public String getTakimAdi() {
        return takimAdi;
    }

    public void setTakimAdi(String takimAdi) {
        this.takimAdi = takimAdi;
    }

    public String getTakimKurulusTarihi() {
        return takimKurulusTarihi;
    }

    public void setTakimKurulusTarihi(String takimKurulusTarihi) {
        this.takimKurulusTarihi = takimKurulusTarihi;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getTakimTarihcesi() {
        return takimTarihcesi;
    }

    public void setTakimTarihcesi(String takimTarihcesi) {
        this.takimTarihcesi = takimTarihcesi;
    }

}
