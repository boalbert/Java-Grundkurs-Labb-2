package com.labb;

public class Advertisement {

    private String nameOfSeller;
    private String nameOfAd;
    private double price;
    private int adId;
    private boolean sold = false;

    public Advertisement(String nameOfSeller, String nameOfAd, double price, int adId) {
        this.nameOfSeller = nameOfSeller;
        this.nameOfAd = nameOfAd;
        this.price = price;
        this.adId = adId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAdId() {
        return adId;
    }

    public String getNameOfSeller() {
        return nameOfSeller;
    }

    public String getNameOfAd() {
        return nameOfAd;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public double getPrice() {
        return price;
    }
}
