// Controller
// Comment for github
package com.labb;
import java.util.ArrayList;


    // TODO Göra denna abstract och ta bort metoder, lägga dom direkt i advertisement
public class AdList {
    private ArrayList<BookAd> BookAds;
    //TODO Ta bort denna
    private String theBookList;

    public AdList() {
        this.BookAds = new ArrayList<>();
    }
    //TODO Lägg till kontroll om annons redan finns
    // if(findBook(book.getAdId()) >= 0)
    // "Bok redan sparad", return false;
    // Se exempel i Jerry / Udemy kurs
    // Ha med denna kontroll på adID?
    public void newBookAd(BookAd addNewBook) {
        BookAds.add(addNewBook);
    }

    // Varför används .this här?
    // Behövs ej, båda funkar och är lika rätt
    // this. förtydligar att det är en instansvariabel
    public void printBookAds() {
        System.out.println("Showing book ads (" + BookAds.size() + "):");
    // Todo Läs på om for each loop så jag kan förklara hur det funkar
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

    // Returnerar true objektet (om det existerar)
    // Används för metoder:
    // - Main -> removeBookAd()
    // - Main -> searchBookAd()
    public BookAd queryBookAd(int bookAdId) {
        int position = findBookAd(bookAdId);
        if(position >= 0) {
            return this.BookAds.get(position); // returnerar objektet på "position"
        }
        return null;
    }

}
