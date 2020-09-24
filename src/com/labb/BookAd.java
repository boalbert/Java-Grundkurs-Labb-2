// Model

package com.labb;

public class BookAd extends Advertisement {

    private String authorOfBook;
    private String titleOfBook;
    private String genreOfBook;

    public BookAd(String nameOfSeller, String nameOfAd, double price, int adId, String authorOfBook, String titleOfBook, String genreOfBook) {
        super(nameOfSeller, nameOfAd, price, adId);
        this.authorOfBook = authorOfBook;
        this.titleOfBook = titleOfBook;
        this.genreOfBook = genreOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public String getGenreOfBook() {
        return genreOfBook;
    }
}
