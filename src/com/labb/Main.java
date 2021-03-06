package com.labb;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static AdList adBooks = new AdList();

    public static void main(String[] args) {

        System.out.println("Hello and welcome to the program!");
        System.out.println("Labb 2 - Albert Andersson");
        System.out.println("---------------------------------");

        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.print("Enter choice (Press 0 for menu): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    newBookAd();
                    break;
                case 2:
                    adBooks.printAllBookAds();
                    break;
                case 3:
                    adBooks.printSoldBookAds();
                    break;
                case 4:
                    removeBookAd();
                    break;
                case 5:
                    searchBookAd();
                    break;
                case 6:
                    updatePriceBookAd();
                    break;
                case 7:
                    bookSold();
                    break;
                case 8:
                    quit = true;
                    System.out.println("Exiting program...");
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\t 0 - Show instructions");
        System.out.println("\t 1 - Post book ad");
        System.out.println("\t 2 - Show book ad(s)");
        System.out.println("\t 3 - Show sold book ad(s)");
        System.out.println("\t 4 - Remove book ad");
        System.out.println("\t 5 - Search for book ad");
        System.out.println("\t 6 - Update price for book ad");
        System.out.println("\t 7 - Mark book as sold");
        System.out.println("\t 8 - Exit program");
    }

    private static void newBookAd() {
        int adId = adBooks.generateId();
        System.out.print("Enter a (short) name for your ad: ");
        String inputNameOfAd = sc.nextLine().toUpperCase();
        System.out.print("Enter name of seller: ");
        String inputNameOfSeller = sc.nextLine();
        System.out.print("Enter title of the book: ");
        String inputBookTitle = sc.nextLine();
        System.out.print("Enter author of book: ");
        String inputAuthorBook = sc.nextLine();
        System.out.print("Enter book genre: ");
        String inputBookGenre = sc.nextLine();
        System.out.print("Enter price (SEK): ");
        double inputBookPrice = sc.nextDouble();
        sc.nextLine();

        BookAd newAdbook = new BookAd(inputNameOfSeller, inputNameOfAd, inputBookPrice, adId, inputAuthorBook, inputBookTitle, inputBookGenre);

        adBooks.newBookAd(newAdbook);
        System.out.println("\nNew book ad posted (ID# " + adId + ").");
    }

    public static void removeBookAd() {
        System.out.print("Enter ID# for book ad you want to remove: ");
        int inputId = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(inputId);
        if (existingBookAd == null) {
            System.out.println("Unable to find ad.");
            return;
        }

        if (adBooks.removeBookAd(existingBookAd)) {
            System.out.println("Book ad has been removed!");
        } else {
            System.out.println("Unable to remove book ad.");
        }
    }

    public static void searchBookAd() {
        System.out.print("Enter book ID#: ");
        int inputBookId = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(inputBookId);
        if (existingBookAd == null) {
            System.out.println("Unable to find book ad.");
            return;
        }

        System.out.println("Found book ad: " +
                "\n\t" + existingBookAd.getNameOfAd() + "\t" +
                "\nID# " + existingBookAd.getAdId() +
                "\nSeller: " + existingBookAd.getNameOfSeller() +
                "\nTitle: " + existingBookAd.getTitleOfBook() +
                "\nAuthor: " + existingBookAd.getAuthorOfBook() +
                "\nGenre: " + existingBookAd.getGenreOfBook() +
                "\nPrice: " + existingBookAd.getPrice() + " SEK");
    }

    // Hämtar aktuellt pris och ber användaren att sätta nytt via getPrice().
    public static void updatePriceBookAd() {
        System.out.print("Enter book ID#: ");
        int inputBookId = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(inputBookId);
        if (existingBookAd == null) {
            System.out.println("Unable to find book ad.");
            return;
        }
        System.out.println(
                "\nBook title: " + existingBookAd.getTitleOfBook() +
                        " (" + existingBookAd.getAuthorOfBook() + ")" +
                        "\nCurrent price: " + existingBookAd.getPrice() + " SEK");

        System.out.print("Enter new price: ");
        double newBookPrice = sc.nextInt();
        existingBookAd.setPrice(newBookPrice);
        System.out.println("Price for ID# " + existingBookAd.getAdId() + " updated!");
    }

    // Användare matar in adID som man vill markera såld
    // Om adID finns så sätter den boolean sold till true
    public static void bookSold() {
        System.out.print("Enter book ID#: ");
        int inputBookId = sc.nextInt();

        BookAd existingBookAd = adBooks.queryBookAd(inputBookId);

        if (existingBookAd == null) {
            System.out.println("Unable to find book ad.");
        } else {
            existingBookAd.setSold(true);
            System.out.println("ID#: " + existingBookAd.getAdId() + " marked as sold.");
        }
    }

}