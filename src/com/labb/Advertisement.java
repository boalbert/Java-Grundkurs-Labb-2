// Model

package com.labb;

public class Advertisement {

    private String nameOfSeller;
    private String nameOfAd;
    private double price;
    private int adId;

    public Advertisement(String nameOfSeller, String nameOfAd, double price, int adId) {
        this.nameOfSeller = nameOfSeller;
        this.nameOfAd = nameOfAd;
        this.price = price;
        this.adId = adId;
    }

    public int getAdId() {
        return adId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameOfSeller() {
        return nameOfSeller;
    }

    public String getNameOfAd() {
        return nameOfAd;
    }

    public void setNameOfAd(String nameOfAd) {
        this.nameOfAd = nameOfAd;
    }

    public double getPrice() {
        return price;
    }
}
