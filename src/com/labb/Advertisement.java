// Model
// Comment for github
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
    // Setter används när vi kör metod för att justera / uppdatera pris på bok
    public void setPrice(double price) {
        this.price = price;
    }
    // Setter används för att markera annons som såld (Lägger till -Sold- i annonsnamnet
    public void setNameOfAd(String nameOfAd) {
        this.nameOfAd = nameOfAd;
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

    public double getPrice() {
        return price;
    }
}
