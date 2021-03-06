package com.labb;

import java.util.ArrayList;

public class AdList {
    private ArrayList<BookAd> BookAds;

    public AdList() {
        this.BookAds = new ArrayList<>();
    }

    public void newBookAd(BookAd addNewBook) {
        BookAds.add(addNewBook);
    }

    public void printAllBookAds() {
        System.out.println("Showing all book ads (" + BookAds.size() + "):");

        for (BookAd BookAds : this.BookAds) {
            System.out.println("------");
            System.out.println("\t" + BookAds.getNameOfAd() + "\t");
            if (BookAds.isSold()) {
                System.out.println("\t - SOLD - \t");
            }
            System.out.print(
                    "ID# " + BookAds.getAdId() +
                            "\nSeller: " + BookAds.getNameOfSeller() +
                            "\nTitle: " + BookAds.getTitleOfBook() +
                            "\nAuthor: " + BookAds.getAuthorOfBook() +
                            "\nGenre: " + BookAds.getGenreOfBook() +
                            "\nPrice: " + BookAds.getPrice() + " SEK\n");

        }
    }

    // Skriver ut endast böcker som är isSold()
    public void printSoldBookAds() {
        System.out.print("Showing sold book ads (");
        int counter = 0;
        for (BookAd bookAd : BookAds) {
            if (bookAd.isSold()) {
                counter++;
            }
        }
        System.out.print(counter + "): \n");

        for (BookAd soldBooks : this.BookAds) {

            if (soldBooks.isSold()) {
                System.out.println("------");
                System.out.println(
                        "\t" + soldBooks.getNameOfAd() + "\t" +
                                "\n\t - SOLD - \t" +
                                "\nID# " + soldBooks.getAdId() +
                                "\nSeller: " + soldBooks.getNameOfSeller() +
                                "\nTitle: " + soldBooks.getTitleOfBook() +
                                "\nAuthor: " + soldBooks.getAuthorOfBook() +
                                "\nGenre: " + soldBooks.getGenreOfBook() +
                                "\nPrice: " + soldBooks.getPrice() + " SEK\n");
            }

        }
    }

    // Genererar int mellan 1 - 9999, om nummer redan existerar körs metod igen för att generera nytt adID
    public int generateId() {

        int adId = (int) (1 + Math.random() * 9999);

        for(BookAd bookId : this.BookAds) {
            if(bookId.getAdId() == adId) {
                generateId();
            }
        }
        return adId;
    }

    public boolean removeBookAd(BookAd bookAd) {
        int foundBookId = findBookAd(bookAd);
        if (foundBookId < 0) {
            System.out.println(bookAd.getAdId() + " not found.");
            return false;
        }
        BookAds.remove(foundBookId);
        return true;
    }

    private int findBookAd(int bookAdId) {
        for (int i = 0; i < this.BookAds.size(); i++) {
            BookAd bookAd = this.BookAds.get(i);
            if (bookAd.getAdId() == bookAdId) {
                return i;
            }

        }
        return -1;
    }

    private int findBookAd(BookAd bookAdId) {
        return this.BookAds.indexOf(bookAdId);
    }

    public BookAd queryBookAd(int bookAdId) {
        int position = findBookAd(bookAdId);
        if (position >= 0) {
            return this.BookAds.get(position); // returnerar objektet på "position"
        }
        return null;
    }

}


