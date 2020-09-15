// Controller

package com.labb;
import java.util.ArrayList;

public class AdList {

    private ArrayList<BookAd> BookAds;
    private String theBookList;

    public AdList() {
        this.BookAds = new ArrayList<>();
    }

    public boolean addNewBook(BookAd addNewBook) {
        BookAds.add(addNewBook);
        return true;
    }

    public void printBookAds() {
        System.out.println("Showing book ads (" + BookAds.size() + "):");

        for (BookAd adBookSub : this.BookAds) {
            System.out.println("------");
            System.out.println(
                    "\t" + adBookSub.getNameOfAd() + "\t" +
                            "\nID# " + adBookSub.getAdId() +
                            "\nSeller: " + adBookSub.getNameOfSeller() +
                            "\nTitle: " + adBookSub.getTitleOfBook() +
                            "\nAuthor: " + adBookSub.getAuthorOfBook() +
                            "\nGenre: " + adBookSub.getGenreOfBook() +
                            "\nPrice: " + adBookSub.getPrice() + " SEK");
        }
    }

    // Returnerar false om findBookAd() inte hittar boken
    // Tar bort bok och returnerar true om bok hittas
    // Används för metod:
    // Main -> removeBookAd()
    public boolean removeBookAd(BookAd bookAd) {
        int foundBookId = findBookAd(bookAd);
        if(foundBookId < 0) {
            System.out.println(bookAd.getAdId() + " not found.");
            return false;
        }
        BookAds.remove(foundBookId);
        return true;
    }

    // Söker efter ID# för en annons
    // Returnerar villken position den finns på
    // Används för metoder:
    //  - queryBookAd()
    private int findBookAd(int bookAdId) {
        for (int i = 0; i < this.BookAds.size(); i++) {
            BookAd bookAd = this.BookAds.get(i);
            if (bookAd.getAdId() == bookAdId) {
                return i;
            }

        }
        return -1;
    }

    // Returnerar position av en Bok via ID#
    // Används för metoder:
    //  -removeBookAd()
    private int findBookAd(BookAd bookAdId) {
        return this.BookAds.indexOf(bookAdId);
    }

    // Returnerar true eller false om vi hittar boken i index
    // Används för metoder:
    // - Main -> removeBookAd()
    // - Main -> searchBookAd()
    public BookAd queryBookAd(int bookAdId) {
        int position = findBookAd(bookAdId);
        if(position >= 0) {
            return this.BookAds.get(position);
        }
        return null;
    }

}
